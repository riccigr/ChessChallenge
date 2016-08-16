package tests.piece;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import resources.chessboard.Board;
import resources.piece.Queen;
import resources.piece.GenericPiece;

public class QueenTest {
	@Test
	public void testGetQueenAbbreviation(){
		char abbreviation = new Queen().getAbbreviation();			
		assertEquals(abbreviation, 'Q');
	}
	
	@Test
	public void testGetQueenDisabledSquares(){
		Board board = new Board(3,3, new ArrayList<GenericPiece>());
		List<Integer> disabledSquares = new ArrayList<Integer>();
		disabledSquares = new Queen().disableSquare(5, board);			
		assertEquals(disabledSquares.get(0).intValue(), 1);
		assertEquals(disabledSquares.get(1).intValue(), 2);
		assertEquals(disabledSquares.get(2).intValue(), 3);
		assertEquals(disabledSquares.get(3).intValue(), 4);
		assertEquals(disabledSquares.get(4).intValue(), 5);
		assertEquals(disabledSquares.get(5).intValue(), 6);
		assertEquals(disabledSquares.get(6).intValue(), 7);
		assertEquals(disabledSquares.get(7).intValue(), 8);
		assertEquals(disabledSquares.get(8).intValue(), 9);
	}
}
