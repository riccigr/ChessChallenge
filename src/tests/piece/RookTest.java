package tests.piece;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import resources.chessboard.Board;
import resources.piece.GenericPiece;
import resources.piece.Rook;

public class RookTest {
	
	@Test
	public void testGetRookAbbreviation(){
		char abbreviation = new Rook().getAbbreviation();			
		assertEquals(abbreviation, 'R');
	}
	
	@Test
	public void testGetRookDisabledSquares(){
		Board board = new Board(3,3, new ArrayList<GenericPiece>());
		List<Integer> disabledSquares = new ArrayList<Integer>();
		disabledSquares = new Rook().disableSquare(5, board);			
		assertEquals(disabledSquares.get(0).intValue(), 2);
		assertEquals(disabledSquares.get(1).intValue(), 4);
		assertEquals(disabledSquares.get(2).intValue(), 5);
		assertEquals(disabledSquares.get(3).intValue(), 6);
		assertEquals(disabledSquares.get(4).intValue(), 8);
	}

}
