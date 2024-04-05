package coreJava1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// call PS parent class and PS1 is child class
public class PS1 extends PS{

	@Test
	public void testRun()
	{
		int a=3;
		PS2 ps2 = new PS2(a); // parameterize constructor;
		
		// call parent class
		doThis();
		System.out.println(ps2.increament());
		System.out.println(ps2.decreament());
		System.out.println(ps2.twoMulitplication());
		System.out.println(ps2.threeMulitplication());
	}
	
	
}
