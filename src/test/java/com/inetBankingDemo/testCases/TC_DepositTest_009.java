package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBankingDemo.pageObjects.DepositPage;
import com.inetBankingDemo.pageObjects.LoginPage;
import com.inetBankingDemo.utilities.XLUtils;

public class TC_DepositTest_009 extends BaseClass{
	

	
	
	
	@Test(priority=1)
	public void depositForm() throws InterruptedException, IOException {
		String accountId = XLUtils.getCellData(excelPath, "sheet1", 10, 0);
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
