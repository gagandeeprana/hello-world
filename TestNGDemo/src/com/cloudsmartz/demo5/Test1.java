package com.cloudsmartz.demo5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	String message = "Manisha";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test
	public void PrintMessage() {
		System.out.println("Inside testPrintMessage()");
		Assert.assertEquals(message, messageUtil.printMessage());
	}
}