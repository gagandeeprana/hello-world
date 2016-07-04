package com.test.grouptest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestGroups {

	@AfterGroups("grp1")
	public void afterGroup() {
		System.out.println("After Group():");
	}

	@BeforeGroups("grp1")
	public void beforeGroup() {
		System.out.println("Before Group():");
	}

	@Test(groups = "grp1", priority = 1)
	public void testGroup() {
		System.out.println("testGroup()");
	}

	@Test(groups = "grp1", priority = 2)
	public void testGroup1() {
		System.out.println("testGroup1()");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@Test
	public void simpleTest() {
		System.out.println("Simple Test");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@Test(dependsOnGroups = "grp1", priority = 0)
	public void dependingOnGroups() {
		System.out.println("Depending On Groups..");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}

	@Parameters("go")
	@Test
	public void go(String param) {
		System.out.println("Param in go is: " + param);
	}

}
