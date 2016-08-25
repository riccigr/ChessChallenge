package tests.piece;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import resources.piece.Rook;


public class RookTest {
	
	@Test
	public void testGetRookAbbreviation(){
		char abbreviation = new Rook().getAbbreviation();			
		assertEquals(abbreviation, 'R');
	}
	
	@Test
	public void testGetRookAttackPossibleAreas(){
		Rook rook = new Rook();
		rook.setRow(1);
		rook.setColumn(1);
		
		//Positive Positions
		//North
		assertEquals(rook.isInAttackArea(0, 1), true);
		//South
		assertEquals(rook.isInAttackArea(2, 1), true);
		//West
		assertEquals(rook.isInAttackArea(1, 0), true);
		//East
		assertEquals(rook.isInAttackArea(1, 2), true);
		//Horizontal
		assertEquals(rook.isInAttackArea(1, 4), true);
		//Vertical
		assertEquals(rook.isInAttackArea(4, 1), true);
	}
	
	
	@Test
	public void testGetRookAttackImpossibleAreas(){
		Rook rook = new Rook();
		rook.setRow(1);
		rook.setColumn(1);
		
		//Negative Positions
		//NW
		assertEquals(rook.isInAttackArea(0, 0), false);
		//NE
		assertEquals(rook.isInAttackArea(0, 2), false);		
		//SW
		assertEquals(rook.isInAttackArea(2, 0), false);
		//SE
		assertEquals(rook.isInAttackArea(2, 2), false);

	}

}
