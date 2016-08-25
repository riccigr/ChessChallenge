package tests.helper;

import static org.junit.Assert.*;

import org.junit.Test;

import resources.helper.ArgsHelper;

public class ArgsHelperTest {
	
	@Test
	public void shouldHaveSevenParams(){
		String[] params = new String[] {"1","2","3","4","5","6","7"};
		ArgsHelper arg = new ArgsHelper(params);
		
		assertEquals(arg.hasEnoughParams(), true);
	}
	
	@Test
	public void testGetIntValueFromIndex(){
		String[] params = new String[] {"1","2","3","4","5","6","7"};
		ArgsHelper arg = new ArgsHelper(params);
		
		assertEquals(arg.getIntValueFromIndex(0), 1);
	}
	
	@Test(expected=NumberFormatException.class)
	public void testNotNumericParams(){
		String[] params = new String[] {"1","2","3","abc","5","6","7"};
		ArgsHelper arg = new ArgsHelper(params);
		
		assertEquals(arg.getIntValueFromIndex(3), 0);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testNotEnoughParams(){
		String[] params = new String[] {"1","2","3","4","5","6","7"};
		ArgsHelper arg = new ArgsHelper(params);
		
		assertEquals(arg.getIntValueFromIndex(10), 0);
	}

}
