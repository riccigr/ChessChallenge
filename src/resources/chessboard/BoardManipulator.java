package resources.chessboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

	public static Set<HashMap<Integer, Square>> allConfigurationFound = new HashSet<>();
	public static List<String> uniqueConfig = new ArrayList<>();
	private int totalOfConfiguration = 0;

	/**
	 * Start function to discover all configurations based in board dimension
	 * and pieces selected. Responsible to iterate for all possibilities found
	 * for pieces in board.
	 * 
	 * It will count total time spent and manage the loop through all possible
	 * combinations of pieces order.
	 * 
	 * @param board
	 */
	public void findAllUniqueConfigurations(Board board) {

		long startTime = System.currentTimeMillis();

		Set<List<GenericPiece>> splitedSequence = new PieceHelper().getAllPiecesSequence(board.piecesInGame);
		System.out.println("total de voltas: " + splitedSequence.size());

		for (List<GenericPiece> combination : splitedSequence) {
			board.prepareBoard();
			checkCombination(combination, 0, 0, board);
		}

		long endTime = System.currentTimeMillis();

		System.out.println("Time spent " + (endTime - startTime) + "ms");
		System.out.println("Total of Configuration Found : " + totalOfConfiguration);
	}

	/**
	 * Recursive function to validate each piece inside the board, one by one,
	 * in each position. Update a currentLayout with pieces, representing a
	 * solution.
	 * 
	 * @param piecesCombination
	 *            Bunch of pieces to be checked in recursive function. Get a
	 *            unique combination, because this method will not change the
	 *            order of the pieces.
	 * @param initialOffset
	 *            Current position enabled to be tested. Piece will begin from
	 *            it value and loop enabled positions until the and of the
	 *            board.
	 * @param index
	 *            Next piece index to be used.
	 * @param currentBoard
	 *            Official layout with a solution.
	 */
	public void checkCombination(List<GenericPiece> piecesCombination, int initialOffset, int index,
			Board currentBoard) {

		if (index == piecesCombination.size()) {
			addToConfigurationsFound(currentBoard);
			return;
		} else {
			int targetOffset = -1;
			int offset = initialOffset;
			GenericPiece targetPiece = piecesCombination.get(index);

			while (offset < currentBoard.getTotalOfSquares()) {
				targetOffset = currentBoard.trySetPieceInEnableOffset(offset, targetPiece);

				if (targetOffset == -1) {
					break;
				} else {
					checkCombination(piecesCombination, targetOffset + 1, index + 1, new Board(currentBoard));

					if (currentBoard.currentLayout.get(targetOffset).hasPiece()) {
						currentBoard.currentLayout.get(targetOffset).setStatus(Square.EMPTY);
						currentBoard.solutionLayout.remove(targetOffset);
					}
					offset = targetOffset + 1;

				}
			}
		}

	}

	/**
	 * Include a new exclusive configuration in final results list.
	 * 
	 * @param board
	 */
	private void addToConfigurationsFound(Board board) {
		allConfigurationFound.add(board.currentLayout);
		totalOfConfiguration++;
		showConfigurations(board);
	}

	/**
	 * Print results in console. It will iterate the object how contains all
	 * configurations and print the chess board representing pieces with its
	 * abbreviation.
	 * 
	 * @param board
	 */
	private void showConfigurations(Board board) {
		int counter = 1;
		int totalOfColumns = board.getTotalColumns();

		StringBuilder sb = new StringBuilder();
		for (Integer piecePositioned : board.currentLayout.keySet()) {
			Square n = board.currentLayout.get(piecePositioned);
			if (counter > totalOfColumns) {
				sb.append("\n");
				counter = 1;
			}
			if (n.hasPiece()) {
				sb.append("| " + board.currentLayout.get(piecePositioned).getPiece().getAbbreviation() + " |");
			} else {
				sb.append("|   |");
			}
			counter++;
		}
		System.out.println(sb.toString());
		System.out.println();
	}
}
