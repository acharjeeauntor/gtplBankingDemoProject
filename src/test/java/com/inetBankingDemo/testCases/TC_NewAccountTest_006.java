package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.LoginPage;
import com.inetBankingDemo.pageObjects.NewAccountPage;

public class TC_NewAccountTest_006 extends BaseClass{

	
	@Test(priority = 1)
	public void loginToTheApplication() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserId(userId);
		logger.info("Entered UserId");
		lp.setUserPassword(password);
		logger.info("Entered Password");
		lp.clickLogin();
		logger.info("Clicked on Login Button");

		Thread.sleep(3000);

	}
	
	@Test(priority=2)
	public void createNewAccount() {
		NewAccountPage newAcc = new NewAccountPage(driver);
		newAcc.lnkNewAccount();
		logger.info("New Account information adding......");
		newAcc.cId(customerId);
		newAcc.accountType("Current");
		newAcc.InitDeposit("5000");
		newAcc.submitBtn();
		logger.info("Account information submit done......");
		if(driver.getPageSource().contains("Account Generated Successfully!!!")) {
			logger.info("New Account Test Passed...");
			Assert.assertTrue(true);
		}else {
			logger.warn("New Account Test Failed...");
			Assert.fail();
		}
		
		
		
		
	}
	
}
