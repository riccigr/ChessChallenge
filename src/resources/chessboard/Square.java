package resources.chessboard;

import resources.piece.GenericPiece;

/**
 * Class to abstract a square(position inside a board), containing all functions and properties in this context.
 * 
 * @author Guilherme Ricci
 *
 */
public class Square{
	
	private int offset;
	private GenericPiece piece;
	private int status;
	
	public static final int EMPTY = 0;
	public static final int FILLED = 1;
	
	public Square(){}
	
	/**
	 * Constructor used when a new square is initialized.
	 * 
	 * @param initialOffset Official index.
	 * @param board 
	 */
	public Square(int initialOffset, Board board){		
		this.offset = initialOffset;
		this.status = 0;
	}	
	
	/**
	 * Validate if pieces has status different of empty.
	 * 
	 * @return
	 */
	public boolean hasPiece(){
		if(this.status == FILLED){
			return true;
		}
		return false;
	}
	
	/**
	 * Return status of Square (empty or filled).
	 * 
	 * @return
	 */
	public int getStatus(){
		return this.status;
	}
	
	/**
	 * Return current status of Square (empty or filled).
	 * 
	 * @param status
	 */
	public void setStatus(int status){
		this.status = status;
	}
	
	/**
	 * Return instance of Piece
	 * 
	 * @return
	 */
	public GenericPiece getPiece(){
		return this.piece;
	}
	
	/**
	 * Update instance of Piece.
	 * 
	 * @param piece
	 */
	public void setPiece(GenericPiece piece){
		this.piece = piece;
	}
	
	/**
	 * Update index of Square.
	 * 
	 * @param offset
	 */
	public void setOffset(int offset){
		this.offset = offset;
	}
	
	/**
	 * Return index of Square.
	 * 
	 * @return
	 */
	public int getOffset(){
		return this.offset;
	}
}

