package tests.chessboard;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import resources.chessboard.Square;
import resources.piece.GenericPiece;
import resources.piece.King;

public class SquareTest {
	
	@Test
	public void testGetPiece(){
		King originalPiece = new King();
		Square square = new Square();
		
		square.setPiece(new King());		
		GenericPiece piece = square.getPiece();
		
		assert(piece.equals(originalPiece));		
	}
	
	@Test
	public void testHasPiece(){
		Square square = new Square();		
		square.setPiece(new King());		
		
		assert(square.hasPiece());
	}
	
	@Test
	public void testGetOffset(){
		Square square = new Square();		
		square.setOffset(1);
		
		assertEquals(square.getOffset(), 1);
	}

}
