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

	@Override
	public boolean isInAttackArea(int row, int column) {
		if(Math.abs(this.getRow() - row) == Math.abs(this.getColumn() - column))
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
