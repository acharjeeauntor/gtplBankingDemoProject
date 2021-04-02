package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.ChangePasswordPage;
import com.inetBankingDemo.pageObjects.FundTransferPage;
import com.inetBankingDemo.pageObjects.LoginPage;
import com.inetBankingDemo.utilities.XLUtils;

public class TC_ChangePasswordTest_012 extends BaseClass{
	
	
	@Test(priority=1)
	public void ChangePasswordForm() throws InterruptedException, IOException {
		String password = XLUtils.getCellData(excelPath, "sheet1", 1, 1);
		loginToTheApplication();
		ChangePasswordPage CP = new ChangePasswordPage(driver);
		CP.lnkChangePassword();
		Thread.sleep(2000);
		logger.info("Change Password Form Fillup Start....");
		CP.setOldPass(password);
		CP.setNewPass("12@12");
		CP.setConfirmPass("12@12");
		CP.submitBtn();
		logger.info("Change Password Form validation Start....");
		
		if(driver.switchTo().alert().getText().equals("Password is Changed")) {
			logger.info("Change Password Page Test Passed.");
			Assert.assertTrue(true);
			driver.switchTo().alert().accept();
		}else {
			logger.warn("Change Password Page Test failed.");
			Assert.fail();
		}
	}
}
