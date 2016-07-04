package com.test.beforeandaftermethod;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMethods {

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}

	@AfterTest
	public void afterTest1() {
		System.out.println("After Test1");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@Test
	public void test() {
		System.out.println("Test");
	}

	@Test
	public void test1() {
		System.out.println("Test1");
	}
}
