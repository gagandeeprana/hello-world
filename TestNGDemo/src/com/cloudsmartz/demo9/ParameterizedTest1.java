package com.cloudsmartz.demo9;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest1 {

	@Test
	@Parameters("myN")
	public void parameterTest(int val) {
		System.out.println("Parameterized value is : " + val);
	}
}
