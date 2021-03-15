package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.AddCustomerPage;
import com.inetBankingDemo.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	///////////////////////////////// First Way Combine
	
//	@Test
//	public void addNewcustomer() throws InterruptedException, IOException {
//		LoginPage lp = new LoginPage(driver);
//		lp.setUserId(userId);
//		logger.info("Entered UserId");
//		lp.setUserPassword(password);
//		logger.info("Entered Password");
//		lp.clickLogin();
//		logger.info("Clicked on Login Button");
//		
//		Thread.sleep(3000);
//		
//		AddCustomerPage addCustomer = new AddCustomerPage(driver);
//		addCustomer.lnkAddNewCustomer();
//		logger.info("Providing Customer Details.....");
//		addCustomer.CName("Auntor");
//		addCustomer.gender();
//		addCustomer.dateOfBirth("11", "22", "1998");
//		Thread.sleep(2000);
//		addCustomer.address("Pathrail");
//		addCustomer.city("Tangail");
//		addCustomer.state("Dhaka");
//		addCustomer.pin("191219");
//		addCustomer.mobileNo("011256129565");
//		String email = randomestring()+"@gmail.com";
//		addCustomer.email(email);
//		addCustomer.password("12345");
//		addCustomer.submitBtn();
//		
//		Thread.sleep(3000);
//		
//		logger.info("Customer information submitted and Validation Started....");
//		
//		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
//		
//		if(res==true) {
//			Assert.assertTrue(true);
//			logger.info("Test Case Pass");
//		}else {
//			logger.info("Test Case failed");
//			captureScreen(driver,"addNewcustomer");
//			Assert.fail();
//		}
//		
//	}
	
	
	
	///////////////////////////////// Second Way

	
	
	
	@Test(priority=1)
	public void addNewCustomer() throws InterruptedException, IOException{
		loginToTheApplication();
		AddCustomerPage addCustomer = new AddCustomerPage(driver);
		addCustomer.lnkAddNewCustomer();
		logger.info("Providing Customer Details.....");
		addCustomer.CName("Auntor");
		addCustomer.gender();
		addCustomer.dateOfBirth("11", "22", "1998");
		Thread.sleep(2000);
		addCustomer.address("Pathrail");
		addCustomer.city("Tangail");
		addCustomer.state("Dhaka");
		addCustomer.pin("191219");
		addCustomer.mobileNo("011256129565");
		String email = randomestring()+"@gmail.com";
		addCustomer.email(email);
		addCustomer.password("12345");
		addCustomer.submitBtn();
		
		Thread.sleep(3000);
		
		logger.info("Customer information submitted and Validation Started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("Test Case Pass");
		}else {
			logger.info("Test Case failed");
			captureScreen(driver,"addNewcustomer");
			Assert.fail();
		}
		
	}
	
	
	
	
	
}
