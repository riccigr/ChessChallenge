package tests.helper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import resources.chessboard.Board;
import resources.helper.PieceHelper;
import resources.piece.GenericPiece;
import resources.piece.King;
import resources.piece.Rook;

public class PieceHelperTest {

	@Test
	public void testGetAllPiecesSequence(){
		
		List<GenericPiece> piecesToGame = new ArrayList<>();
		
		piecesToGame.add(new King());
		piecesToGame.add(new King());
		piecesToGame.add(new Rook());
		Board board = new Board(3, 3, piecesToGame);
		
		Set<List<GenericPiece>> splitedSequence = new PieceHelper().getAllPiecesSequence(board.piecesInGame);
		Iterator<List<GenericPiece>> itr = splitedSequence.iterator();
		
		List<GenericPiece> innerList= itr.next();				
		assertEquals(innerList.toString(),"[K, K, R]");
		
		innerList= itr.next();			
		assertEquals(innerList.toString(),"[R, K, K]");
		
		innerList= itr.next();	
		assertEquals(innerList.toString(),"[K, R, K]");
	}
}
