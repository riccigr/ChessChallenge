package resources.chessboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
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
	public static List<String> uniqueConfig = new ArrayList<>();
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
		for (int nextPosition = 0; nextPosition < totalOfSquares; nextPosition++) {					
			checkCombination(new LinkedList<GenericPiece>(linkedCombination), nextPiece, nextPosition, board);
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
	 * @param initialOffset Current position enabled to be tested.
	 * @param currentBoard Official layout with a solution.
	 * @param boardWithEnabledSquares Board without squares filled or in attack areas.
	 */
	public void checkCombination(LinkedList<GenericPiece> piecesRemaining, GenericPiece targetPiece, int initialOffset, Board currentBoard) {
		
		int targetOffset = -1;
		
		System.out.println(targetPiece.getAbbreviation() + " e a peca " );
		
		if(piecesRemaining.size() == (currentBoard.piecesInGame.size() -1 )){
			currentBoard.finalLayout = new HashMap<Integer, Square>();
		}
		
		targetOffset = currentBoard.trySetPieceInEnableOffset(initialOffset, targetPiece);
		
		if(targetOffset == -1){
			System.out.println("Fail");
			return;
		}else{
			System.out.println("Setou na casa " + targetOffset);
		}
		
		while(!piecesRemaining.isEmpty()){
			GenericPiece nextPiece = piecesRemaining.pollFirst();				
				checkCombination(new LinkedList<>(piecesRemaining), nextPiece, targetOffset+1, new Board(currentBoard));
//				currentBoard.currentLayout.get(nextOffset).setStatus(Square.EMPTY);
//			currentBoard.currentLayout.get(targetOffset).setStatus(Square.EMPTY);
		}			
		
		if(canAddToConfigurationsFound(currentBoard)){
			addToConfigurationsFound(currentBoard);
		}				
//		currentBoard.currentLayout.get(targetOffset).setStatus(Square.EMPTY);			

		return;
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
		String configCandidate = board.toString();
		
		if(isOriginalString(uniqueConfig,configCandidate)){
			uniqueConfig.add(configCandidate);
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
