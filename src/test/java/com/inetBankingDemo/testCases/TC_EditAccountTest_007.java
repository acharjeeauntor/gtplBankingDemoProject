package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.EditAccountPage;
import com.inetBankingDemo.pageObjects.EditCustomerPage;
import com.inetBankingDemo.pageObjects.LoginPage;

public class TC_EditAccountTest_007 extends BaseClass {
	

	@Test(priority = 1)
	public void accountIdVerification() throws IOException, InterruptedException {
		loginToTheApplication();
		EditAccountPage eap = new EditAccountPage(driver);
		
		eap.lnkEditAccount();
		Thread.sleep(2000);
		eap.accountId(accountId);
		eap.submitBtn();

		logger.info("Account Id Verification Start....");

		if (isAlertPresent() == true) {
			logger.warn("Account Id Validation failed...");
			driver.switchTo().alert().accept();
			Assert.fail();
		} else {
			Assert.assertTrue(true);
			logger.info("Account Id verification Success ............");
			Thread.sleep(2000);
		}

	}

	@Test(priority = 3)
	public void editAccountInputFields() throws InterruptedException, IOException {
		EditAccountPage eap = new EditAccountPage(driver);
		if(eap.presentAccountType().equals("Savings")) {
			eap.accountType("Current");
		}else {
			eap.accountType("Savings");
		}
		
		eap.submitBtn();
		Thread.sleep(2000);
		logger.info("Edit Account Form submition done...Now start validation.......");
		boolean res = driver.getPageSource().contains("Account details updated Successfully!!!");
		if (res == true) {
			logger.info("Edit Account Test passed");
			Assert.assertTrue(true);
		} else {
			logger.info("Edit Account Test Failed");
			Assert.fail();

		}

	}
}
