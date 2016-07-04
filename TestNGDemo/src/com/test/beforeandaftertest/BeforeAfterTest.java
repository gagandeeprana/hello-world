package com.test.beforeandaftertest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAfterTest {

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@Test
	public void loadTest() {
		System.out.println("loadTest");
	}

	@Test
	public void loadTest1() {
		System.out.println("loadTest1");
	}

	@Test
	public void loadTest2() {
		System.out.println("loadTest2");
	}

	@Test
	public void loadTest3() {
		System.out.println("loadTest3");
	}

	@Test
	public void loadTest4() {
		System.out.println("loadTest4");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
}
