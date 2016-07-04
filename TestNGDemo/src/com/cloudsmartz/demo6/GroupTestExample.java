package com.cloudsmartz.demo6;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupTestExample {

	String message = ".com";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test(groups = { "functest", "checkintest" })
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		message = ".com";
		AssertJUnit.assertEquals(message, messageUtil.printMessage());
	}

	@Test(groups = { "checkintest" })
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "tutorialspoint" + ".com";
		AssertJUnit.assertEquals(message, messageUtil.salutationMessage());
	}

	@Test(groups = { "functest" })
	public void testingExitMessage() {
		System.out.println("Inside testExitMessage()");
		message = "www." + "tutorialspoint" + ".com";
		AssertJUnit.assertEquals(message, messageUtil.exitMessage());
	}
}