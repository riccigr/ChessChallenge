package resources.chessboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import resources.piece.GenericPiece;

/**
 * Class to manage all action inside the board.
 * 
 * @author Guilherme Ricci
 *
 */
public class BoardManipulator {
	
	public static Set<HashMap<Integer, Square>> allConfigurationFound = new HashSet<>();
	public static List<String> hashFinal = new ArrayList<>();
	private int totalOfConfiguration = 0;
	
	/**
	 * Start function to discover all configurations based in board dimension and pieces selected.
	 * Responsible to iterate for all possibilities found for pieces in board.
	 * 
	 * @param board 
	 */
	public void findAllUniqueConfigurations(Board board) {
		
		long startTime = System.currentTimeMillis();
		int totalOfSquares = board.getDimension();

		LinkedList<GenericPiece> linkedCombination = new LinkedList<>(board.piecesInGame);
		GenericPiece nextPiece = linkedCombination.pollFirst();
		for (int nextPosition = 1; nextPosition <= totalOfSquares; nextPosition++) {					
			checkCombination(new LinkedList<GenericPiece>(linkedCombination), nextPiece, nextPosition, board,	new Board(board));
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Time spent " + (endTime - startTime) + "ms");
		System.out.println("Total of Configuration Found : " + totalOfConfiguration);	
	}

	/**
	 * Recursive function to validate each piece inside the board, one by one, in each position.
	 * Update a currentLayout with pieces, representing a solution.
	 * 
	 * @param piecesRemaining Pieces to be checked in recursive function.
	 * @param targetPiece Current piece to be tested.
	 * @param offset Current position enabled to be tested.
	 * @param currentBoard Official layout with a solution.
	 * @param boardWithEnabledSquares Board without squares filled or in attack areas.
	 */
	public void checkCombination(LinkedList<GenericPiece> piecesRemaining, GenericPiece targetPiece, int offset, Board currentBoard,
			Board boardWithEnabledSquares) {
		
		if(piecesRemaining.size() == (currentBoard.piecesInGame.size() -1 )){
			currentBoard.finalLayout = new HashMap<Integer, Square>();
		}
		
		Board disabledSquaresBoard = new Board(boardWithEnabledSquares);
		if(disabledSquaresBoard.canSetPiece(offset, targetPiece)){
			currentBoard.setPiece(offset, targetPiece);
		}else{
			return;
		}
		
		while(hasPiecesRemaining(piecesRemaining)){
			GenericPiece nextPiece = piecesRemaining.pollFirst();
			for (Integer nextEnabledSquare : disabledSquaresBoard.disabledLayout.keySet()) {
				checkCombination(new LinkedList<>(piecesRemaining), nextPiece, nextEnabledSquare, new Board(currentBoard), disabledSquaresBoard);
				currentBoard.currentLayout.get(nextEnabledSquare).setStatus(Square.EMPTY);
			}
			currentBoard.currentLayout.get(offset).setStatus(Square.EMPTY);
		}			
		
		if(canAddToConfigurationsFound(currentBoard)){
			addToConfigurationsFound(currentBoard);
		}				
		currentBoard.currentLayout.get(offset).setStatus(Square.EMPTY);			

		return;
	}
	
	/**
	 * Validate if a LinkedList of Pieces has some 
	 * 
	 * @param piecesRemaining
	 * @return boolean
	 */
	private boolean hasPiecesRemaining(LinkedList<GenericPiece> piecesRemaining){
		if(piecesRemaining.size() > 0){
			return true;
		}
		return false;			
	}
	
	/**
	 * Validate if the final layout has the same number of position as are Pieces in game
	 * 
	 * @param board
	 * @return boolean
	 */
	private boolean canAddToConfigurationsFound(Board board){
		if(board.finalLayout.size() == board.piecesInGame.size()){
			return true;
		}
		return false;
	}

	/**
	 * Include a new exclusive configuration in final results.
	 * 
	 * @param board
	 */
	private void addToConfigurationsFound(Board board) {	
		String candidate = "";
		for (Integer piecePositioned : board.currentLayout.keySet()) {
			Square square = board.currentLayout.get(piecePositioned);
			if(square.hasPiece()){
				HashMap<Integer, Character> tempPiece = new HashMap<>();
				tempPiece.put(piecePositioned, square.getPiece().getAbbreviation());
				candidate += tempPiece.hashCode();				
			}
		}		
		
		if(isOriginalString(hashFinal,candidate)){
			hashFinal.add(candidate);
			allConfigurationFound.add(board.currentLayout);
			totalOfConfiguration++;
			showConfigurations(board);
		}		
	}
	
	/**
	 * Validate if a new item exists inside a list of them.
	 * 
	 * @param bunchOfItems List<String> to checkInsite
	 * @param item String to be validated
	 * @return boolean
	 */
	private boolean isOriginalString(List<String> bunchOfItems, String item){
		if(!bunchOfItems.contains(item)){
			return true;
		}
		return false;
	}
	
	/**
	 * Print results in console.
	 * @param board
	 */
	private void showConfigurations(Board board){
		int counter = 1;
		int totalOfColumns = board.getTotalColumns();
		
		for (HashMap<Integer, Square> possibility : allConfigurationFound) {
			StringBuilder sb = new StringBuilder();
			for (Integer piecePositioned : possibility.keySet()) {
				Square n = possibility.get(piecePositioned);
				if(counter > totalOfColumns){
					sb.append("\n");
					counter = 1;
				}
				if (n.hasPiece()) {
					sb.append("| "+ possibility.get(piecePositioned).getPiece().getAbbreviation() +" |");
				}
				else{
					sb.append("|   |");
				}
				counter++;
			}
			System.out.println(sb.toString());
			System.out.println();
		}	
	}
}
