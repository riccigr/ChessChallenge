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


	@Override
	public boolean isInAttackArea(int row, int column) {
		int currentRow = Math.abs(getRow() - row);
		int currentColumn = Math.abs(getColumn() - column);
		if((Math.abs(getRow() - row) == 2 && Math.abs(getColumn() - column) == 1) || (Math.abs(getRow() - row) == 1 && Math.abs(getColumn() - column) == 2)){
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
