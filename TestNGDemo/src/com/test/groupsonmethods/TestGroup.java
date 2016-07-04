package com.test.groupsonmethods;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestGroup {

	@BeforeGroups("database1")
	public void setupDB() {
		System.out.println("setupDB()");
	}

	@AfterGroups("database1")
	public void cleanDB() {
		System.out.println("cleanDB()");
	}

	@Test(groups = "selenium-test1")
	public void runSelenium() {
		System.out.println("runSelenium()");
	}

	@Test(groups = "selenium-test1")
	public void runSelenium1() {
		System.out.println("runSelenium()1");
	}

	@Test(groups = "database1")
	public void testConnectOracle() {
		System.out.println("testConnectOracle()");
	}

	@Test(groups = "database1")
	public void testConnectMsSQL() {
		System.out.println("testConnectMsSQL");
	}

	@Test(dependsOnGroups = { "database1", "selenium-test1" })
	public void runFinal() {
		System.out.println("runFinal");
	}

}