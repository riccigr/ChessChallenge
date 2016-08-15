package resources.piece;

import java.util.ArrayList;
import java.util.List;

import resources.chessboard.Board;
import resources.helper.SquareHelper;

public class Knight extends GenericPiece{
	
	/**
	 * Return a identification for this piece
	 * 
	 * @see char
	 */
	public char getAbbreviation(){
		return 'N';
	}

    /**
     * Return a list with all position which cannot be used to place a piece.
     * Its movement uses L rules.
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
				if(isUpRightPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
				if(isUpLeftPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
				else if(isDownRightPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
				else if(isDownLeftPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
				else if(isLeftUpPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
				else if(isLeftDownPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
				else if(isRightUpPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
				else if(isRightDownPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));							
				}
				else if(isItOwnPosition(row, column, currentRow, currentColumn))
				{
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
				}
			}
		}
		
		return disabledSquareOffset;
		
	}
	
	/**
	 * Validate if values are the same, to abstract when they are in the same L.
	 * Example:
	 * 				 _target
	 * 				|
	 * 				|
	 * 			   Piece
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isUpRightPosition(int row, int column, int currentRow, int currentColumn){
		if(((row-2) == currentRow) && ((column+1) ==currentColumn)){
			return true;
		}
		return false;
	}
	
	/**
	 * Validate if values are the same, to abstract when they are in the same L.
	 * Example:
	 * 		 target_
	 * 				|
	 * 				|
	 * 			   Piece
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isUpLeftPosition(int row, int column, int currentRow, int currentColumn) {
		if(((row-2) == currentRow) && ((column-1) ==currentColumn)){
			return true;
		}
		return false;
	}
	
	/**
	 * Validate if values are the same, to abstract when they are in the same L.
	 * Example:
	 * 		      Piece
	 * 				|
	 * 				|_target 			    
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isDownRightPosition(int row, int column, int currentRow, int currentColumn) {
		if(((row+2) == currentRow) && ((column +1)==currentColumn)){
			return true;
		}
		return false;
	}
	
	/**
	 * Validate if values are the same, to abstract when they are in the same L.
	 * Example:
	 * 		      Piece
	 * 				|
	 * 				|_target 			    
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isDownLeftPosition(int row, int column, int currentRow, int currentColumn) {
		if(((row+2) == currentRow) && ((column-1) ==currentColumn)){
			return true;
		}
		return false;
	}
	
	/**
	 * Validate if values are the same, to abstract when they are in the same L.
	 * Example:
	 * 		     target
	 * 				|__ __Piece	    
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isLeftUpPosition(int row, int column, int currentRow, int currentColumn) {
		if(((row -1) == currentRow) && ((column-2) ==currentColumn)){
			return true;
		}
		return false;
	}
	
	/**
	 * Validate if values are the same, to abstract when they are in the same L.
	 * Example:
	 * 		         __ __Piece
	 * 				|
	 * 	    	  target
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isLeftDownPosition(int row, int column, int currentRow, int currentColumn) {
		if(((row +1) == currentRow) && ((column-2) ==currentColumn)){
			return true;
		}
		return false;
	}
	
	/**
	 * Validate if values are the same, to abstract when they are in the same L.
	 * Example:
	 * 		         
	 * 						target
	 * 	    	  Piece__ __|
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isRightUpPosition(int row, int column, int currentRow, int currentColumn) {
		if(((row -1) == currentRow) && ((column+2) ==currentColumn)){
			return true;
		}
		return false;
	}

	/**
	 * Validate if values are the same, to abstract when they are in the same L.
	 * Example:
	 * 		         
	 * 				Piece__ __		
	 * 	    	  			  |
	 * 						target
	 * 
	 * @param row
	 * @param column
	 * @param currentRow
	 * @param currentColumn
	 * @return
	 */
	private boolean isRightDownPosition(int row, int column, int currentRow, int currentColumn) {
		if(((row +1) == currentRow) && ((column+2) ==currentColumn)){
			return true;
		}
		return false;
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
	 * Use to compare with another pieces.
	 */
    @Override
    public boolean equals(Object obj) {
        return !super.equals(obj);
    }

}
