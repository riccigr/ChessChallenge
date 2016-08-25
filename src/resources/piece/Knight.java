package resources.piece;

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
	 * Validate if coordinates x,y can be conflicted with Squares base on original position of the piece.
	 * It piece has it own move to validate.
	 * Knight validates squares in all 8 "L draws" directions. around with 2 distance of difference for one axis and 1 distance for another one.
	 * 
	 * @param row Axis X to be verified. Start in 0.
	 * @param column Axis y to be verified. Start in 0.
	 * @return boolean true if conflict.
	 */
	@Override
	public boolean isInAttackArea(int row, int column) {
		
		//Math.abs is used to ignore negative. Difference must be 2 distance of difference for one axis and 1 distance for another one.
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
