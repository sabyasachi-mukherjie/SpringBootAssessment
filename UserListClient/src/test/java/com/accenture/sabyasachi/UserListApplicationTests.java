package com.accenture.sabyasachi;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.accenture.sabyasachi")
@IncludePackages("com.accenture.sabyasachi.service")
class UserListApplicationTests {

	@Test
	public void contextLoads() {
	}

}
