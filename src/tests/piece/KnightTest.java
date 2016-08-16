package tests.piece;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import resources.chessboard.Board;
import resources.piece.Knight;
import resources.piece.GenericPiece;

public class KnightTest {

	@Test
	public void testGetKnightAbbreviation(){
		char abbreviation = new Knight().getAbbreviation();			
		assertEquals(abbreviation, 'N');
	}
	
	@Test
	public void testGetKnightDisabledSquares(){
		Board board = new Board(6,6, new ArrayList<GenericPiece>());
		List<Integer> disabledSquares = new ArrayList<Integer>();
		disabledSquares = new Knight().disableSquare(15, board);			
		assertEquals(disabledSquares.get(0).intValue(), 2);
		assertEquals(disabledSquares.get(1).intValue(), 4);
		assertEquals(disabledSquares.get(2).intValue(), 7);
		assertEquals(disabledSquares.get(3).intValue(), 11);
		assertEquals(disabledSquares.get(4).intValue(), 15);
		assertEquals(disabledSquares.get(5).intValue(), 19);
		assertEquals(disabledSquares.get(6).intValue(), 23);
		assertEquals(disabledSquares.get(7).intValue(), 26);
		assertEquals(disabledSquares.get(8).intValue(), 28);
	}
}
