package tests.piece;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

import resources.chessboard.Board;
import resources.piece.Bishop;
import resources.piece.GenericPiece;

public class BishopTest {
	
	@Test
	public void testGetBishopAbbreviation(){
		char abbreviation = new Bishop().getAbbreviation();			
		assertEquals(abbreviation, 'B');
	}
	
	@Test
	public void testGetBishopDisabledSquares(){
		Board board = new Board(3,3, new ArrayList<GenericPiece>());
		List<Integer> disabledSquares = new ArrayList<Integer>();
		disabledSquares = new Bishop().disableSquare(5, board);			
		assertEquals(disabledSquares.get(0).intValue(), 1);
		assertEquals(disabledSquares.get(1).intValue(), 3);
		assertEquals(disabledSquares.get(2).intValue(), 5);
		assertEquals(disabledSquares.get(3).intValue(), 7);
		assertEquals(disabledSquares.get(4).intValue(), 9);
	}
	
}
