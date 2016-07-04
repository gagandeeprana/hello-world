package com.cloudsmartz.demo7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpectedExceptionTest {

	String message = "Gagandeep";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test(expectedExceptions = {ArithmeticException.class,NullPointerException.class})
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		messageUtil.printMessage();
	}

	@Test
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!" + "Gagandeep";
		Assert.assertEquals(message, messageUtil.salutationMessage());
	}
}