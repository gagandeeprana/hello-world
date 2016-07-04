package com.cloudsmartz.test.pen;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTest {

	private com.cloudsmartz.test.pen.Test test = null;

	@BeforeTest
	public void init() {
		test = new com.cloudsmartz.test.pen.Test();
	}

	@Test
	public void checkPostTokenRequest() {
		String url = "http://192.168.80.45:8280/auth/1.0.0/token";
		String username = "anurag.sachan";
		String password = "anurag@123";
		String grantType = "password";
		Assert.assertEquals(true,
				test.postRequestForToken(url, username, password, grantType)
						.contains("access_token"));
	}
}
