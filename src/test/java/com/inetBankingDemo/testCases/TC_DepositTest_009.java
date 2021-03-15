package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBankingDemo.pageObjects.DepositPage;
import com.inetBankingDemo.pageObjects.LoginPage;

public class TC_DepositTest_009 extends BaseClass{
	

	
	
	
	@Test(priority=1)
	public void depositForm() throws InterruptedException, IOException {
		loginToTheApplication();
		DepositPage dp = new DepositPage(driver);
		dp.lnkDeposit();
		Thread.sleep(2000);
		logger.info("Deposit Form Fillup Start....");
		dp.accountNo(accountId);
		dp.amount("1000");
		dp.desc("inter 1000 USD");
		dp.submitBtn();
		logger.info("Deposit Form validation Start....");
		if(driver.getPageSource().contains("Transaction details of Deposit for Account "+accountId)) {
			logger.info("Deposit Page Test Passed.");
			Assert.assertTrue(true);
		}else {
			logger.warn("Deposit Page Test failed.");
			Assert.fail();
		}
	}
	
	
	

}
