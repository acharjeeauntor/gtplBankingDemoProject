package com.guru99BankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99BankingDemo.pageObjects.ManagerRegistrationPage;

public class ManagerModuleTest extends BaseClass {
	
	ManagerRegistrationPage objManagerRegistration;

	@Test(priority = 0)
	public void doManagerRegistration() throws IOException {
		objManagerRegistration = new ManagerRegistrationPage(driver);
		objManagerRegistration.ManagerRegistration("78@gmail.com");
		if(driver.getPageSource().contains("Access details to demo site.")) {
			objManagerRegistration.setManagerInfo();
			Assert.assertTrue(true);
			System.out.println("pass");
		}else {
			System.out.println("fail");
			captureScreen(driver,"doManagerRegistration");
			Assert.fail();
		}
	}

}
