package tests.piece;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import resources.piece.Knight;

public class KnightTest {

	@Test
	public void testGetKnightAbbreviation(){
		char abbreviation = new Knight().getAbbreviation();			
		assertEquals(abbreviation, 'N');
	}
	
	@Test
	public void testGetKnightPossibleAttackAreas(){
		Knight knight = new Knight();
		knight.setRow(2);
		knight.setColumn(2);
		
		//Positive Positions
		//TopLeft
		assertEquals(knight.isInAttackArea(0, 1), true);
		//TopRight
		assertEquals(knight.isInAttackArea(0, 3), true);		
		//DownLeft
		assertEquals(knight.isInAttackArea(4, 1), true);
		//DownRight
		assertEquals(knight.isInAttackArea(4, 3), true);
		//RightTop
		assertEquals(knight.isInAttackArea(1, 4), true);
		//RightDown
		assertEquals(knight.isInAttackArea(3, 4), true);
		//LeftTop
		assertEquals(knight.isInAttackArea(1, 0), true);
		//LeftDown
		assertEquals(knight.isInAttackArea(3, 0), true);

	}
	
	@Test
	public void testGetKnightImpossibleAttackAreas(){
		Knight knight = new Knight();
		knight.setRow(2);
		knight.setColumn(2);
		
		//Negative Positions
		//NW
		assertEquals(knight.isInAttackArea(1, 1), false);
		//NE
		assertEquals(knight.isInAttackArea(1, 3), false);		
		//SW
		assertEquals(knight.isInAttackArea(3, 1), false);
		//SE
		assertEquals(knight.isInAttackArea(3, 3), false);
		//North
		assertEquals(knight.isInAttackArea(1, 2), false);
		//South
		assertEquals(knight.isInAttackArea(3, 2), false);
		//West
		assertEquals(knight.isInAttackArea(2, 1), false);
		//East
		assertEquals(knight.isInAttackArea(2, 3), false);

	}
}
