package resources.piece;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import resources.chessboard.Board;
import resources.helper.SquareHelper;

public class Queen extends GenericPiece {

	/**
	 * Return a identification for this piece
	 * 
	 * @see char
	 */
	public char getAbbreviation() {
		return 'Q';
	}

	
	@Override
	public boolean isInAttackArea(int row, int column) {
		if(Math.abs(this.getRow() - row) == Math.abs(this.getColumn() - column))
			return true;
		
		if(this.getRow() == row || this.getColumn() == column)
			return true;
		
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
