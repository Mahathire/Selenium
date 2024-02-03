package org.par;

import org.testng.annotations.Test;

public class Sample {
	
	@Test(priority = 7)
	private void tc7() {
		System.out.println("Test Case 7");
	}
	@Test
	private void tcgamil() {
		System.out.println("Test Case gmail");
	}
	@Test(priority = -15)
	private void tc4() {
		System.out.println("Test Case 4");
	}
	@Test(priority = -3)
	private void tc6() {
		System.out.println("Test Case 6");
	}
	@Test(priority = 26)
	private void tc5() {
		System.out.println("Test Case 5");
	}
	@Test(priority = -3)
	private void tc1() {
		System.out.println("Test Case 1");
	}
	@Test(priority = 4)
	private void tc3() {
		System.out.println("Test Case 3");
	}


}
