package resources.piece;

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

	/**
	 * Validate if coordinates x,y can be conflicted with Squares base on original position of the piece.
	 * It piece has it own move to validate.
	 * Bishop validates squares in all 4 diagonals. around with difference distance equals for rows and columns.
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
