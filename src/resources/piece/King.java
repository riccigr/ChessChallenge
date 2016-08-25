package resources.piece;


public class King extends GenericPiece {

	/**
	 * Return a identification for this piece
	 * 
	 * @see char
	 */
	public char getAbbreviation() {
		return 'K';
	}
	
	/**
	 * Validate if coordinates x,y can be conflicted with Squares base on original position of the piece.
	 * It piece has it own move to validate.
	 * King validates squares in all 8 positions around with 1 distance of difference.
	 * 
	 * @param row Axis X to be verified. Start in 0.
	 * @param column Axis y to be verified. Start in 0.
	 * @return boolean true if conflict.
	 */
	@Override
	public boolean isInAttackArea(int row, int column) {
		
		//Math.abs is used to ignore negative. Difference must be 1.
		if (Math.abs(this.getRow() - row) == 1 && Math.abs(this.getColumn() - column) == 1) {
			return true;
		} 
		if ((this.getRow() == row && Math.abs(this.getColumn() - column) == 1) || (this.getColumn() == column && Math.abs(this.getRow() - row) == 1)) {
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
