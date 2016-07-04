package com.cloudsmartz.grouptestingdemo.demo13;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestGroup {

	@BeforeGroups("database")
	public void setupDB() {
		System.out.println("setupDB()");
	}

	@BeforeGroups("selenium-test")
	public void setupSelenium() {
		System.out.println("setupSelenium()");
	}

	@AfterGroups("selenium-test")
	public void seleniumFinish() {
		System.out.println("seleniumFinish()");
	}

	@Test(dependsOnGroups = "selenium-test")
	public void checkDependsOnGroups() {
		System.out.println("Depends On Groups....");
	}

	@AfterGroups("database")
	public void cleanDB() {
		System.out.println("cleanDB()");
	}

	@Test(groups = "selenium-test")
	public void runSelenium() {
		System.out.println("runSelenium()");
	}

	@Test(groups = "selenium-test")
	public void runSelenium1() {
		System.out.println("runSelenium()1");
	}

	@Test(groups = "database")
	public void testConnectOracle() {
		System.out.println("testConnectOracle()");
	}

	@Test(groups = "database")
	public void testConnectMsSQL() {
		System.out.println("testConnectMsSQL");
	}

	@Test(dependsOnGroups = { "database", "selenium-test" })
	public void runFinal() {
		System.out.println("runFinal");
	}

}