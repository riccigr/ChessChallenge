package resources.piece;

/**
 * Represent a Piece Rook of Chess
 * 
 * @author Guilherme Ricci
 *
 */
public class Rook extends GenericPiece {

	/**
	 * Return a identification for this piece
	 * 
	 * @see char
	 */
	public char getAbbreviation() {
		return 'R';
	}

	/**
	 * Validate if coordinates x,y can be conflicted with Squares base on original position of the piece.
	 * It piece has it own move to validate.
	 * Rook validates squares in all vertical and horizontal.
	 * 
	 * @param row Axis X to be verified. Start in 0.
	 * @param column Axis y to be verified. Start in 0.
	 * @return boolean true if conflict.
	 */
	@Override
	public boolean isInAttackArea(int row, int column) {

		if (this.getRow() == row || this.getColumn() == column) {
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
