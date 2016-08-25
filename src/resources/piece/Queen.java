package resources.piece;

public class Queen extends GenericPiece {

	/**
	 * Return a identification for this piece
	 * 
	 * @see char
	 */
	public char getAbbreviation() {
		return 'Q';
	}

	/**
	 * Validate if coordinates x,y can be conflicted with Squares base on original position of the piece.
	 * It piece has it own move to validate.
	 * Queen validates squares in all vertical, horizontal and all 4 diagonals.
	 * 
	 * @param row Axis X to be verified. Start in 0.
	 * @param column Axis y to be verified. Start in 0.
	 * @return boolean true if conflict.
	 */
	@Override
	public boolean isInAttackArea(int row, int column) {
		
		//Math.abs is used to ignore negative. Difference must be equals for rows and columns.
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
