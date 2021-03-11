package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass{

	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		
		
		LoginPage lp = new LoginPage(driver);
	
		lp.setUserId(userId);
		logger.info("Entered UserId");
		
		lp.setUserPassword(password);
		logger.info("Entered Password");
		
		lp.clickLogin();
		logger.info("Clicked on Login Button");
		
		
		
		
		if(driver.getTitle().equals(homePageTitle)) {
			Assert.assertTrue(true);
			logger.info("Login test Passed");
		}else {
			captureScreen(driver,"loginTest");
			Assert.fail();
			logger.info("Login test Failed");
		}
		
		
		
		
	}	
	
	
	
}
