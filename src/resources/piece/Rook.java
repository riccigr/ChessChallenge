package resources.piece;

import java.util.ArrayList;
import java.util.List;

import resources.chessboard.Board;
import resources.helper.SquareHelper;

/**
 * Represent a Piece Rook of Chess
 * @author Guilherme Ricci
 *
 */
public class Rook extends GenericPiece{
	
	/**
	 * Return a identification for this piece
	 * 
	 * @see char
	 */
	public char getAbbreviation(){
		return 'R';
	}

    /**
     * Return a list with all position which cannot be used to place a piece.
     * Its movement is base in Horizontal and Verticals.
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
		int currentRow =  squareHelper.getRowBasedOnOffset(offset, totalOfRows);
		int currentColumn =  squareHelper.getColumnBasedOnOffset(offset, totalOfRows, totalOfColumns);
		List<Integer> disabledSquareOffset = new ArrayList<>();
		
		for(int row=1; row <= totalOfRows; row++){
			for(int column=1; column <= totalOfColumns; column++){
				if(isInVertical(column, currentColumn)){
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
					continue;
				}
				if(isInHorizontal(row, currentRow)){
					disabledSquareOffset.add(squareHelper.calculateOffset(row, column, totalOfColumns));
					continue;
				}
			}
		}		
		return disabledSquareOffset;		
	}
	
	/**
	 * Validate if values are the same, to abstract when they are in the same Row.
	 * 
	 * @param rowCandidate 
	 * @param currentRow
	 * @return boolean
	 * @see Boolean
	 */	
	private boolean isInHorizontal(int rowCandidate, int currentRow){
		if(rowCandidate == currentRow){
			return true;
		}
		return false;
	}
	
	/**
	 * Validate if values are the same, to abstract when they are in the same Column.
	 * 
	 * @param columnCandidate 
	 * @param currentColumn
	 * @return boolean
	 * @see Boolean
	 */	
	private boolean isInVertical(int columnCandidate, int currentColumn){
		if(columnCandidate == currentColumn){
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
