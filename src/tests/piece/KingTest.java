package tests.piece;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import resources.piece.King;

public class KingTest {
	
	@Test
	public void testGetKingAbbreviation(){
		char abbreviation = new King().getAbbreviation();			
		assertEquals(abbreviation, 'K');
	}
	
	@Test
	public void testGetKingPossibleAttackAreas(){
		King king = new King();
		king.setRow(1);
		king.setColumn(1);
		
		//Positive Positions
		//NW
		assertEquals(king.isInAttackArea(0, 0), true);
		//NE
		assertEquals(king.isInAttackArea(0, 2), true);		
		//SW
		assertEquals(king.isInAttackArea(2, 0), true);
		//SE
		assertEquals(king.isInAttackArea(2, 2), true);
		//North
		assertEquals(king.isInAttackArea(0, 1), true);
		//South
		assertEquals(king.isInAttackArea(2, 1), true);
		//West
		assertEquals(king.isInAttackArea(1, 0), true);
		//East
		assertEquals(king.isInAttackArea(1, 2), true);
		
	}
	
	@Test
	public void testGetKingImpossibleAttackAreas(){
		King king = new King();
		king.setRow(1);
		king.setColumn(1);
		
		//Horizontal
		assertEquals(king.isInAttackArea(1, 4), false);
		//Vertical
		assertEquals(king.isInAttackArea(4, 1), false);
		//Diagonal
		assertEquals(king.isInAttackArea(3, 3), false);
		assertEquals(king.isInAttackArea(4, 4), false);
		
	}

}
