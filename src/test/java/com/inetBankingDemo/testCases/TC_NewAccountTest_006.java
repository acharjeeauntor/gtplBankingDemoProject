package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.LoginPage;
import com.inetBankingDemo.pageObjects.NewAccountPage;
import com.inetBankingDemo.utilities.XLUtils;

public class TC_NewAccountTest_006 extends BaseClass{


	
	@Test(priority=1)
	public void createNewAccount() throws InterruptedException, IOException {
		String customerId = XLUtils.getCellData(excelPath, "sheet1", 6, 0);
		loginToTheApplication();
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
