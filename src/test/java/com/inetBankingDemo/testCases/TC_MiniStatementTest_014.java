package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.MiniStatementPage;
import com.inetBankingDemo.utilities.XLUtils;

public class TC_MiniStatementTest_014 extends BaseClass{
	@Test(priority=1)
	public void miniStatement() throws InterruptedException, IOException {
		String accountId = XLUtils.getCellData(excelPath, "sheet1", 10, 0);
		MiniStatementPage ms = new MiniStatementPage(driver);
		loginToTheApplication();
		ms.lnkMiniStatement();
		Thread.sleep(2000);
		
		logger.info("Account no. verification start......");
		
		ms.accountNo(accountId);
		ms.submitBtn();
		logger.info("validation Start....");
		if(driver.getPageSource().contains("Last Five Transaction Details for Account No: "+accountId)) {
			logger.info("Mini Statement Test Passed.");
			Assert.assertTrue(true);
		}else {
			logger.warn("Mini Statement Test failed.");
			Assert.fail();
		}
		
	}
}
