package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.BalanceEnquiryPage;
import com.inetBankingDemo.utilities.XLUtils;

public class TC_BalanceEnquiryTest_013 extends BaseClass{
	@Test(priority=1)
	public void balanceEnquiry() throws InterruptedException, IOException {
		String accountId = XLUtils.getCellData(excelPath, "sheet1", 10, 0);
		
		BalanceEnquiryPage be = new BalanceEnquiryPage(driver);
		loginToTheApplication();
		be.lnkBalanceEnquiry();
		Thread.sleep(2000);
		
		logger.info("Account no. verification start......");
		be.accountNo(accountId);
		be.submitBtn();
		logger.info("validation Start....");
		if(driver.getPageSource().contains("Balance Details for Account "+accountId)) {
			logger.info("Balance Enquiry Test Passed.");
			Assert.assertTrue(true);
		}else {
			logger.warn("Balance Enquiry Test failed.");
			Assert.fail();
		}
		
	}
}
