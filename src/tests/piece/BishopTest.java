package tests.piece;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import resources.piece.Bishop;

public class BishopTest {
	
	@Test
	public void testGetBishopAbbreviation(){
		char abbreviation = new Bishop().getAbbreviation();			
		assertEquals(abbreviation, 'B');
	}
	
	@Test
	public void testGetBishopPossibleAttackArea(){
		Bishop bishop = new Bishop();
		bishop.setRow(1);
		bishop.setColumn(1);
		
		//Positive Positions
		//NW
		assertEquals(bishop.isInAttackArea(0, 0), true);
		//NE
		assertEquals(bishop.isInAttackArea(0, 2), true);		
		//SW
		assertEquals(bishop.isInAttackArea(2, 0), true);
		//SE
		assertEquals(bishop.isInAttackArea(2, 2), true);
		//Diagonal
		assertEquals(bishop.isInAttackArea(3, 3), true);
		assertEquals(bishop.isInAttackArea(4, 4), true);

	}
	
	@Test
	public void testGetBishopImpossibleAttackArea(){
		Bishop bishop = new Bishop();
		bishop.setRow(1);
		bishop.setColumn(1);
				
		//Negative Positions
		//North
		assertEquals(bishop.isInAttackArea(0, 1), false);
		//South
		assertEquals(bishop.isInAttackArea(2, 1), false);
		//West
		assertEquals(bishop.isInAttackArea(1, 0), false);
		//East
		assertEquals(bishop.isInAttackArea(1, 2), false);
		//Horizontal
		assertEquals(bishop.isInAttackArea(1, 4), false);
		//Vertical
		assertEquals(bishop.isInAttackArea(4, 1), false);

	}
	
}
