package resources.piece;

import java.util.List;

import resources.chessboard.Board;

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
	 * Use to facilitate comparison with anohter piece.
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
     * Return a list with all position which cannot be used to place a piece.
     * Movement change for each piece
     * 
     * @param offset value to use as a index of a 2dimension matrix(board).
     * @param board current board layout used to get its dimensions.
     * @see List<>
     * @see ArrayList<>
     */
	public abstract List<Integer> disableSquare(int offset, Board board);
	
	public abstract boolean isInAttackArea(int row,  int column);
	
	public int getRow(){
		return row;
	}
	
	public int getColumn(){
		return column;
	}
	
	public void setRow( int currentRow){
		row = currentRow;
	}
	
	public void setColumn(int currentColumn){
		column = currentColumn;
	}
	
	
}
