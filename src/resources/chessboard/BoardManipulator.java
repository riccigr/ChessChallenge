package resources.chessboard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import resources.helper.PieceHelper;
import resources.piece.GenericPiece;

/**
 * Class to manage all action inside the board.
 * 
 * @author Guilherme Ricci
 *
 */
public class BoardManipulator {
	
	public static Set<HashMap<Integer, Square>> allConfiguration = new HashSet<>();
	public static Set<HashMap<Integer, Character>> config = new HashSet<>();
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
		Set<List<GenericPiece>> splitedSequence = new PieceHelper().getAllPiecesSequence(board.piecesInGame);

		for (List<GenericPiece> combination : splitedSequence) {
			LinkedList<GenericPiece> linkedCombination = new LinkedList<>(combination);
				GenericPiece nextPiece = linkedCombination.pollFirst();
				for (int nextPosition = 1; nextPosition <= totalOfSquares; nextPosition++) {					
					checkCombination(new LinkedList<GenericPiece>(linkedCombination), nextPiece, nextPosition, board,	new Board(board));
				}
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
		
		Board disabledSquaresBoard = new Board(currentBoard);
		if(disabledSquaresBoard.canSetPiece(offset, targetPiece)){
			currentBoard.setPiece(offset, targetPiece);
		}else{
			return;
		}
		
		while(piecesRemaining.size() > 0){
			GenericPiece nextPiece = piecesRemaining.pollFirst();
			for (Integer nextEnabledSquare : disabledSquaresBoard.currentLayout.keySet()) {
				checkCombination(new LinkedList<>(piecesRemaining), nextPiece, nextEnabledSquare, new Board(currentBoard), disabledSquaresBoard);
				currentBoard.currentLayout.get(nextEnabledSquare).setStatus(Square.EMPTY);
			}
			currentBoard.currentLayout.get(offset).setStatus(Square.EMPTY);
		}
		
		addToConfigurationsFound(currentBoard);
		
		if (piecesRemaining.size() == 0) {
			currentBoard.currentLayout.get(offset).setStatus(Square.EMPTY);
			return;
		}

	}

	/**
	 * Include a new exclusive configuration in final results.
	 * 
	 * @param board
	 */
	private void addToConfigurationsFound(Board board) {		
		for (Integer piecePositioned : board.currentLayout.keySet()) {
			Square square = board.currentLayout.get(piecePositioned);
			boolean isOriginal = true;
			if(square.hasPiece()){
				HashMap<Integer, Character> tmp = new HashMap<>();
				tmp.put(piecePositioned, square.getPiece().getAbbreviation());
				if(config.size() == 0){
					config.add(tmp);
					allConfiguration.add(board.currentLayout);
				}
				for(HashMap<Integer, Character> possibility : config){
					if(!possibility.equals(tmp)){
						isOriginal = false;
					}
				}
				if(isOriginal){
					config.add(tmp);
					allConfiguration.add(board.currentLayout);
					totalOfConfiguration++;
					showConfigurations(board);
				}
			}
		}
		
	}
	
	/**
	 * Print results in console.
	 * @param board
	 */
	private void showConfigurations(Board board){
		int counter = 1;
		int totalOfColumns = board.getTotalColumns();
		
		for (HashMap<Integer, Square> possibility : allConfiguration) {
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
	
	/**
	 * Return integer with total of configurations.
	 * 
	 * @return
	 */
	public int getTotalOfConfigurationsFound(){
		return this.totalOfConfiguration;
	}

	
	
	
}
