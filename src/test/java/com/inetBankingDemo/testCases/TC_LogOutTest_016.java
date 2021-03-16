package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.LogoutButton;

public class TC_LogOutTest_016 extends BaseClass{
	@Test(priority=1)
	public void logOut() throws InterruptedException, IOException {
		LogoutButton logout = new LogoutButton(driver);
		loginToTheApplication();
		logout.lnkLogOut();
		logger.info("validation Start....");
		if(driver.switchTo().alert().getText().contains("You Have Succesfully Logged Out!!")) {
			logger.info("logOut Test Passed.");
			Assert.assertTrue(true);
			driver.switchTo().alert().accept();
		}else {
			logger.warn("logOut Test failed.");
			Assert.fail();
		}
		
	}
}
