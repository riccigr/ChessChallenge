package resources.piece;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import resources.chessboard.Board;
import resources.helper.SquareHelper;

/**
 * Represent a Piece Bishop of Chess
 * @author Guilherme Ricci
 *
 */
public class Bishop extends GenericPiece {

	/**
	 * Return a identification for this piece
	 * @see char
	 */
	public char getAbbreviation() {
		return 'B';
	}

    /**
     * Return a list with all position which cannot be used to place a piece.
     * Its movement is base in diagonals.
     * 
     * @param offset value to use as a index of a 2dimension matrix(board).
     * @param board current board layout used to get its dimensions.
     * @see List<>
     * @see ArrayList<>
     */
	@Override
	public List<Integer> disableSquare(int offset, Board board) {
		SquareHelper squareHelper = new SquareHelper();
		int totalOfRows = board.getTotalRows();
		int totalOfColumns = board.getTotalColumns();
		int currentRow = squareHelper.getRowBasedOnOffset(offset, totalOfRows);
		int currentColumn = squareHelper.getColumnBasedOnOffset(offset, totalOfRows, totalOfColumns);
		Set<Integer> uniqueDisabledSquareOffset = new HashSet<>();

		// UpRight from my piece
		for (int row = currentRow, column = currentColumn; row > 0 || column <= totalOfColumns; row--, column++) {
			uniqueDisabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
		}
		
		// UpLeft from my piece
		for (int row = currentRow, column = currentColumn; row > 0 && column > 0; row--, column--) {
			uniqueDisabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
		}
		
		// DownLeft from my piece
		for (int row = currentRow, column = currentColumn; row <= totalOfRows && column > 0; row++, column--) {
			uniqueDisabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
		}
		
		// DownRight from my piece
		for (int row = currentRow, column = currentColumn; row <= totalOfRows && column <= totalOfColumns; row++, column++) {
			uniqueDisabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
		}
		
		List<Integer> disabledSquareOffset = new ArrayList<>(uniqueDisabledSquareOffset);
		return disabledSquareOffset;
	}
	
	/**
	 * Use to compare with another pieces.
	 */
    @Override
    public boolean equals(Object obj) {
        return !super.equals(obj);
    }

}
