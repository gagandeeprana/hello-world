package com.cloudsmartz.demo8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTestOnGroups {

	String message = "Gagandeep";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test(groups = { "init" })
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		message = "Gagandeep";
		Assert.assertEquals(message, messageUtil.printMessage());
	}

	@Test(dependsOnGroups = { "deno.*" })
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!" + "Gagandeep";
		Assert.assertEquals(message, messageUtil.salutationMessage());
	}

	@Test(dependsOnGroups = { "deno" })
	public void initEnvironmentTest() {
		System.out.println("This is initEnvironmentTest");
	}

	@Test(groups = { "deno" })
	public void checkTest() {
		System.out.println("This is checkTest");
	}
}
