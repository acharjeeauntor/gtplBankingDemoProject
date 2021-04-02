package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.LoginPage;
import com.inetBankingDemo.pageObjects.WithdrawalPage;
import com.inetBankingDemo.utilities.XLUtils;

public class TC_WithDrawalTest_010 extends BaseClass{

	@Test(priority=1)
	public void withDrawalForm() throws InterruptedException, IOException {
		String accountId = XLUtils.getCellData(excelPath, "sheet1", 10, 0);
		loginToTheApplication();
		WithdrawalPage withDraw = new WithdrawalPage(driver);
		withDraw.lnkWithdrawal();
		Thread.sleep(2000);
		logger.info("Withdrawal Form Fillup Start....");
		withDraw.accountNo(accountId);
		withDraw.amount("500");
		withDraw.desc("500 USD");
		withDraw.submitBtn();
		logger.info("Withdrawal Form validation Start....");
		if(driver.getPageSource().contains("Transaction details of Withdrawal for Account "+accountId)) {
			logger.info("Withdrawal Page Test Passed.");
			Assert.assertTrue(true);
		}else {
			logger.warn("Withdrawal Page Test failed.");
			Assert.fail();
		}
	}
	
}
