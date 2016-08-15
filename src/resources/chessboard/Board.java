package resources.chessboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import resources.piece.GenericPiece;

/**
 * Class to abstract a chess board, containing all functions and properties in this context.
 * 
 * @author Guilherme Ricci
 *
 */
public class Board {

	private int rows;
	private int columns;
	private int dimension;
	public HashMap<Integer, Square> currentLayout;
	public GenericPiece[][] piecesLayout;
	public List<GenericPiece> piecesInGame = new ArrayList<>();
	public HashMap<Integer, Square> position = new HashMap<>();
	public static Set<HashMap<Integer, Square>> allConfiguration = new HashSet<>();
	public boolean solution = false;

	
	/**
	 * Constructor used to create a new board.
	 * 
	 * @param numberOfRows Axis X.
	 * @param numberOfColumns Axis Y.
	 * @param piecesToBoard Contains all pieces to be set in board.
	 */
	public Board(int numberOfRows, int numberOfColumns, List<GenericPiece> piecesToBoard) {
		this.rows = numberOfColumns;
		this.columns = numberOfColumns;
		this.dimension = numberOfRows * numberOfColumns;
		this.piecesInGame = piecesToBoard;
		currentLayout = new HashMap<Integer, Square>();
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
		this.dimension = another.dimension;
		this.piecesInGame = another.piecesInGame;
		this.currentLayout = (HashMap<Integer, Square>) another.currentLayout.clone();
	}

	/**
	 * Include one new square for each position inside the board.
	 * 
	 */
	private void prepareBoard() {
		for (int i = 1; i <= dimension; i++) {
			currentLayout.put(i, new Square(i, this));
		}
	}

	/**
	 * Validate if one specific piece can be set inside a square(based in offset).
	 * Also remove all square affected by Piece attack area from currentLayout.
	 * 
	 * @param offset Index of a square to be checked.
	 * @param piece Piece to be included
	 * @return
	 */
	public boolean canSetPiece(int offset, GenericPiece piece) {
		List<Integer> disabledSquaresOffset = piece.disableSquare(offset, this);
		for (int disabledOffset : disabledSquaresOffset) {
			if(this.currentLayout.get(disabledOffset).hasPiece()){
				return false;
			}
			int positionToRemove = disabledOffset;
			this.currentLayout.remove(positionToRemove);
		}
		return true;
	}

	/**
	 * Update a square inside the currentLayout with a piece.
	 * 
	 * @param offset Index of a square to be updated.
	 * @param piece Piece to be included inside a square.
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
	public int getDimension() {
		return this.columns * this.rows;
	}



}
