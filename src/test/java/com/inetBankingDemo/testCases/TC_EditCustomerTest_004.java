package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.EditCustomerPage;
import com.inetBankingDemo.pageObjects.LoginPage;

public class TC_EditCustomerTest_004 extends BaseClass {
	

	@Test(priority = 1)
	public void loginToTheApplication() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserId(userId);
		logger.info("Entered UserId");
		lp.setUserPassword(password);
		logger.info("Entered Password");
		lp.clickLogin();
		logger.info("Clicked on Login Button");

		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void customerIdVerification() throws IOException, InterruptedException {
		EditCustomerPage ecp = new EditCustomerPage(driver);
		ecp.lnkEditCustomer();
		Thread.sleep(2000);
		ecp.cId(customerId);
		ecp.submitBtn();
		
		logger.info("Customer Id Verification Start....");
		
		if (isAlertPresent() == true) {
			captureScreen(driver, "customerIdVerification");
			logger.warn("Customer Id Validation failed...");
			driver.switchTo().alert().accept();
			Assert.fail();
		}else {
			Assert.assertTrue(true);
			logger.info("Customer Id verification Success ............");
			Thread.sleep(3000);
		}

	}
	
	
	@Test(priority=3)
	public void editCustomerInputFields() throws InterruptedException, IOException {
		EditCustomerPage ecp = new EditCustomerPage(driver);
		
		
		ecp.address("Pathrail saha para");
		ecp.city("Tangail-2");
		ecp.state("Dhaka-2");
		ecp.pin("191219");
		ecp.mobileNo("0123456789");
		String email = randomestring()+"@gmail.com";
		ecp.email(email);
		ecp.editSubmitBtn();
		
		
		Thread.sleep(3000);
		logger.info("Edit Customer Form submition done...Now start validation.......");
		boolean res = driver.getPageSource().contains("Customer details updated Successfully!!!");
		if(res==true) {
			logger.info("Test passed");
			Assert.assertTrue(true);
		}else {
			logger.info("Test Failed");
			captureScreen(driver,"editCustomerInputFields");
			Assert.fail();
			
		}
	
	}


}
