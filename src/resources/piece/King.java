package resources.piece;

import java.util.ArrayList;
import java.util.List;

import resources.chessboard.Board;
import resources.helper.SquareHelper;

public class King extends GenericPiece{
	
	/**
	 * Return a identification for this piece
	 * @see char
	 */
	public char getAbbreviation(){
		return 'K';
	}

    /**
     * Return a list with all position which cannot be used to place a piece.
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
		int currentRow =  squareHelper.getRowBasedOnOffset(offset, totalOfRows);
		int currentColumn =  squareHelper.getColumnBasedOnOffset(offset, totalOfRows, totalOfColumns);
		List<Integer> disabledSquareOffset = new ArrayList<>();
		
		for(int row=1; row <= totalOfRows; row++){
			for(int column=1; column <= totalOfColumns; column++){
				if(isUpPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
				else if(isDownPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
				else if(isLeftPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
				else if(isRightPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
				else if(isUpLeftPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
				else if(isUpRightPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
				else if(isDownLeftPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
				else if(isDownRightPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}else if(isItOwnPosition(row, column, currentRow, currentColumn)){
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
			}
		}
		
		return disabledSquareOffset;
		
	}
	
	/**
	 * Validate if candidate column and row have the same value from current column and current row.
	 * Represents the candidate position are the same in terms of coordinates.
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isItOwnPosition(int row, int column, int currentRow, int currentColumn) {
		if((row == currentRow) && (column==currentColumn)){
			return true;
		}
		return false;
	}

	/**
	 * Validate if candidate row and column represents a position on Down and Right from current row and Column.
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isDownRightPosition(int row, int column, int currentRow, int currentColumn) {
		if(((row+1) == currentRow) && ((column+1) ==currentColumn)){
			return true;
		}
		return false;
	}

	/**
	 * Validate if candidate row and column represents a position on Down and Left from current row and Column.
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isDownLeftPosition(int row, int column, int currentRow, int currentColumn) {
		if(((row+1) == currentRow) && ((column-1) ==currentColumn)){
			return true;
		}
		return false;
	}

	/**
	 * Validate if candidate row and column represents a position on Up and Right from current row and Column.
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isUpRightPosition(int row, int column, int currentRow, int currentColumn) {
		if(((row-1) == currentRow) && ((column+1) ==currentColumn)){
			return true;
		}
		return false;
	}

	/**
	 * Validate if candidate row and column represents a position on Up and Left from current row and Column.
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isUpLeftPosition(int row, int column, int currentRow, int currentColumn) {
		if(((row-1) == currentRow) && ((column-1) ==currentColumn)){
			return true;
		}
		return false;
	}

	/**
	 * Validate if candidate row and column represents a position on Right side from current row and Column.
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isRightPosition(int row, int column, int currentRow, int currentColumn) {
		if((row == currentRow) && ((column+1) ==currentColumn)){
			return true;
		}
		return false;
	}

	/**
	 * Validate if candidate row and column represents a position on Left side from current row and Column.
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isLeftPosition(int row, int column, int currentRow, int currentColumn) {
		if((row == currentRow) && ((column-1) ==currentColumn)){
			return true;
		}
		return false;
	}

	/**
	 * Validate if candidate row and column represents a position on Down side from current row and Column.
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isDownPosition(int row, int column, int currentRow, int currentColumn) {
		if(((row+1) == currentRow) && (column ==currentColumn)){
			return true;
		}
		return false;
	}

	/**
	 * Validate if candidate row and column represents a position on Up side from current row and Column.
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isUpPosition(int row, int column, int currentRow, int currentColumn){
		if(((row-1) == currentRow) && (column ==currentColumn)){
			return true;
		}
		return false;
	}
	
	/**
	 * Use to compare with another pieces.
	 */
    @Override
    public boolean equals(Object obj) {
        return !super.equals(obj);
    }
	

}
