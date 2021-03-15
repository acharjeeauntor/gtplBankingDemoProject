package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.FundTransferPage;
import com.inetBankingDemo.pageObjects.LoginPage;

public class TC_FundTransferTest_011 extends BaseClass{

	
	
	@Test(priority=1)
	public void FundTransferForm() throws InterruptedException, IOException {
		loginToTheApplication();
		FundTransferPage fT = new FundTransferPage(driver);
		fT.lnkFundTransfer();
		Thread.sleep(2000);
		logger.info("Fund Transfer Form Fillup Start....");
		fT.payersAccountNo(accountId);
		fT.payeesAccountNo("90547");
		fT.amount("500");
		fT.desc("Fund transfer");
		fT.submitBtn();
		logger.info("Fund Transfer Form validation Start....");
		if(driver.getPageSource().contains("Fund Transfer Details")) {
			logger.info("Fund Transfer Page Test Passed.");
			Assert.assertTrue(true);
		}else {
			logger.warn("Fund Transfer Page Test failed.");
			Assert.fail();
		}
	}
}
