package resources.piece;

/**
 * Represent a Generic Piece to instantiate objects which can contains any piece.
 * @author Guilherme Ricci
 *
 */
public abstract class GenericPiece {
	
	private int row;
	private int column;
	
	/**
	 * Return a identification for this piece
	 * 
	 * @see char
	 */
	public abstract char getAbbreviation();
	
	/**
	 * Use to facilitate comparison with another piece.
	 */
	public String toString() {
		return String.valueOf(getAbbreviation());
	}
	
	/**
	 * Method implemented to make HashSet to prevent duplication  in combination of pieces
	 * source: http://stackoverflow.com/questions/16238182/hashset-contains-duplicate-entries
	 */
    public boolean equals(Object obj) {
        return this.toString() == obj.toString();
    }
    
	/**
	 * Method implemented to make HashSet to prevent duplication in combination of pieces
	 * source: http://stackoverflow.com/questions/16238182/hashset-contains-duplicate-entries
	 */
	@Override
	public int hashCode() {
		return getAbbreviation();
	}  
    
	/**
	 * Validate if coordinates x,y can be conflicted with Squares base on original position of the piece.
	 * It piece has it own move to validate.
	 * 
	 * @param row Axis X to be verified. Start in 0.
	 * @param column Axis y to be verified. Start in 0.
	 * @return boolean true if conflict.
	 */
	public abstract boolean isInAttackArea(int row,  int column);
	
	/**
	 * return current row (axis x)  where piece is allocated.
	 * 
	 * @return int Start from 0.
	 */
	public int getRow(){
		return this.row;
	}
	
	/**
	 * return current column (axis y) where piece is allocated.
	 * 
	 * @return int Start from 0.
	 */
	public int getColumn(){
		return this.column;
	}
	
	/**
	 * set current row (axis x)  where piece is allocated.
	 * 
	 * @return int Start from 0.
	 */
	public void setRow( int currentRow){
		this.row = currentRow;
	}
	
	/**
	 * set current column (axis y) where piece is allocated.
	 * 
	 * @return int Start from 0.
	 */
	public void setColumn(int currentColumn){
		this.column = currentColumn;
	}
	
	
}
