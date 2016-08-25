package tests.piece;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import resources.piece.Queen;

public class QueenTest {
	@Test
	public void testGetQueenAbbreviation(){
		char abbreviation = new Queen().getAbbreviation();			
		assertEquals(abbreviation, 'Q');
	}
	
	@Test
	public void testGetQueenAttackPossibleAreas(){
		Queen queen = new Queen();
		queen.setRow(1);
		queen.setColumn(1);
		
		//Positive Positions
		//NW
		assertEquals(queen.isInAttackArea(0, 0), true);
		//NE
		assertEquals(queen.isInAttackArea(0, 2), true);		
		//SW
		assertEquals(queen.isInAttackArea(2, 0), true);
		//SE
		assertEquals(queen.isInAttackArea(2, 2), true);
		//North
		assertEquals(queen.isInAttackArea(0, 1), true);
		//South
		assertEquals(queen.isInAttackArea(2, 1), true);
		//West
		assertEquals(queen.isInAttackArea(1, 0), true);
		//East
		assertEquals(queen.isInAttackArea(1, 2), true);
		//Horizontal
		assertEquals(queen.isInAttackArea(1, 4), true);
		//Vertical
		assertEquals(queen.isInAttackArea(4, 1), true);
		//Diagonal
		assertEquals(queen.isInAttackArea(3, 3), true);
		assertEquals(queen.isInAttackArea(4, 4), true);


	}
	
	@Test
	public void testGetQueenAttackImpossibleAreas(){
		Queen queen = new Queen();
		queen.setRow(1);
		queen.setColumn(1);
		
		//Negative Positions
		assertEquals(queen.isInAttackArea(3, 0), false);
		assertEquals(queen.isInAttackArea(3, 2), false);		
		assertEquals(queen.isInAttackArea(3, 4), false);


	}
}
