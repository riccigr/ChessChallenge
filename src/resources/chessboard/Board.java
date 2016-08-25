
package resources.chessboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import resources.piece.GenericPiece;

/**
 * Class to abstract a chess board, containing all functions and properties in
 * this context.
 * 
 * @author Guilherme Ricci
 *
 */
public class Board {

	private int rows;
	private int columns;
	private int totalOfSquares;
	public HashMap<Integer, Square> currentLayout;
	public HashMap<Integer, Square> solutionLayout;
	public List<GenericPiece> piecesInGame = new ArrayList<>();
	public static Set<HashMap<Integer, Square>> allConfiguration = new HashSet<>();

	/**
	 * Constructor used to create a new board.
	 * 
	 * @param numberOfRows
	 *            Axis X.
	 * @param numberOfColumns
	 *            Axis Y.
	 * @param piecesToBoard
	 *            Contains all pieces to be set in board.
	 */
	public Board(int numberOfRows, int numberOfColumns, List<GenericPiece> piecesToBoard) {
		this.rows = numberOfRows;
		this.columns = numberOfColumns;
		this.totalOfSquares = numberOfRows * numberOfColumns;
		this.piecesInGame = piecesToBoard;
		this.currentLayout = new HashMap<Integer, Square>();
		this.solutionLayout = new HashMap<Integer, Square>();

		prepareBoard();
	}

	/**
	 * Constructor used to create a copy of an existent board object.
	 * 
	 * @param another
	 */
	@SuppressWarnings("unchecked")
	public Board(Board another) {
		this.rows = another.rows;
		this.columns = another.columns;
		this.totalOfSquares = another.totalOfSquares;
		this.piecesInGame = another.piecesInGame;
		this.currentLayout = (HashMap<Integer, Square>) another.currentLayout.clone();
		this.solutionLayout = (HashMap<Integer, Square>) another.solutionLayout.clone();
	}

	/**
	 * Include one new square for each position inside the board.
	 * 
	 */
	protected void prepareBoard() {
		solutionLayout = new HashMap<Integer, Square>();
		for (int i = 0; i < totalOfSquares; i++) {
			currentLayout.put(i, new Square(i, this));
		}
	}

	/**
	 * Validate and set piece in the next square available, checking pieces movement rules.
	 * This will not look back or change order in the board.  
	 * Can return -1 if no offset is enabled to the board current configuration.
	 * 
	 * @param initialOffset
	 * @param targetPiece
	 * @return offset where piece was placed. If not possible to set in any offset, return -1.
	 */
	public int trySetPieceInEnableOffset(int initialOffset, GenericPiece targetPiece) {
		for (int offset = initialOffset; offset < totalOfSquares; offset++) {
			int row = offset / rows;
			int column = offset % rows;
			if (canSetPiece(targetPiece, row, column)) {
				setPiece(offset, targetPiece);
				return offset;
			}
		}

		return -1;
	}

	/**
	 * Validate if one specific piece can be set inside a square(based in row and column). 
	 * Will check against all already set if this new piece affect some old piece or the contrary idea. 
	 * 
	 * @param candidatePiece
	 *            Piece to be included.
	 * @param row
	 *            Candidate row to be verified for piece in parameter.       
	 * @param column
	 *            Candidate column to be verified for piece in parameter.      
	 * @return
	 */
	public boolean canSetPiece(GenericPiece candidatePiece, int row, int column) {
		candidatePiece.setColumn(column);
		candidatePiece.setRow(row);
		for (Square square : solutionLayout.values()) {
			GenericPiece myPiece = square.getPiece();
			if (myPiece.isInAttackArea(row, column)) {
				return false;
			}
			if (candidatePiece.isInAttackArea(myPiece.getRow(), myPiece.getColumn())) {
				return false;
			}
		}
		return true;

	}

	/**
	 * Update a square inside the currentLayout with a piece.
	 * 
	 * @param offset
	 *            Index of a square to be updated.
	 * @param piece
	 *            Piece to be included inside a square.
	 * 
	 * @return
	 */
	public void setPiece(int offset, GenericPiece piece) {
		Square position = new Square();
		position = currentLayout.get(offset);
		position.setPiece(piece);
		position.setStatus(Square.FILLED);
		position.setOffset(offset);
		currentLayout.put(offset, position);
		solutionLayout.put(offset, position);
	}

	public int getTotalRows() {
		return this.rows;
	}

	public int getTotalColumns() {
		return this.columns;
	}

	/**
	 * return total of Squares inside the board.
	 * 
	 * @return
	 */
	public int getTotalOfSquares() {
		return this.columns * this.rows;
	}


}