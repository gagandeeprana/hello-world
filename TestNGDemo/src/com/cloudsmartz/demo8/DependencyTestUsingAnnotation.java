package com.cloudsmartz.demo8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTestUsingAnnotation {

	String message = "Gagandeep";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		message = "Gagandeep";
		Assert.assertEquals(message, messageUtil.printMessage());
	}

	@Test(dependsOnMethods = { "initEnvironmentTest" })
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!" + "Gagandeep";
		Assert.assertEquals(message, messageUtil.salutationMessage());
	}

	@Test
	public void initEnvironmentTest() {
		System.out.println("This is initEnvironmentTest");
	}
}