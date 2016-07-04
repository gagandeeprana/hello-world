package com.test.prioritytest;

import org.testng.annotations.Test;

public class TestPriority {

	@Test(priority = 0)
	public void go() {
		System.out.println("go()");
	}

	@Test(priority = 1)
	public void ready() {
		System.out.println("ready()");
	}
}
