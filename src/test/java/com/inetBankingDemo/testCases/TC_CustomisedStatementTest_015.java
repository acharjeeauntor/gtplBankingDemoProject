package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.CustomisedStatementPage;

public class TC_CustomisedStatementTest_015 extends BaseClass{
	@Test(priority=1)
	public void customisedStatement() throws InterruptedException, IOException {
		CustomisedStatementPage cs = new CustomisedStatementPage(driver);
		loginToTheApplication();
		cs.lnkCustomizedStatement();
		Thread.sleep(2000);
		
		logger.info("Customized Statement Form......");
		cs.accountNo(accountId);
		cs.fromDate("03", "10", "2021");
		cs.toDate("03", "15", "2021");
		cs.minimumValue("500");
		cs.noOfTransaction("2");
		cs.submitBtn();
		
		logger.info("validation Start....");
		if(driver.getPageSource().contains("Transaction Details for Account No: "+accountId+" from Date: 2021-03-10 to: 2021-03-15")) {
			logger.info("Customised Statement Test Passed.");
			Assert.assertTrue(true);
		}else {
			logger.warn("Customised Statement Test failed.");
			captureScreen(driver,"customisedStatement");
			Assert.fail();
		}
		
	}
}
