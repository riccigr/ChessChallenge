package tests.helper;

import static org.junit.Assert.*;

import org.junit.Test;

import resources.helper.SquareHelper;

public class SquareHelperTest {
	
	@Test
	public void testCalculateOffset(){
		int offset = new SquareHelper().calculateOffset(2, 2, 3);
		assertEquals(offset, 5);
	}
	
	@Test
	public void testRowBasedInOffset(){
		int row = new SquareHelper().getRowBasedOnOffset(5, 3);
		assertEquals(row, 2);
	}
	
	@Test
	public void testColumnBasedInOffset(){
		int column = new SquareHelper().getColumnBasedOnOffset(5, 3, 3);
		assertEquals(column, 2);
	}
	

}
