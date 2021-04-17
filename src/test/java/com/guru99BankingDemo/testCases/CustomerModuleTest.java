package com.guru99BankingDemo.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99BankingDemo.pageObjects.DeleteCustomerPage;
import com.guru99BankingDemo.pageObjects.NewCustomerPage;
import com.guru99BankingDemo.utilities.Config;
import com.guru99BankingDemo.utilities.XLUtils;

public class CustomerModuleTest extends BaseClass {

	String AddCustomerSuccessMessage = "Customer Registered Successfully!!!";

	NewCustomerPage objNewCustomer;
	DeleteCustomerPage objDeleteCustomer;
	Config config;

	@Test(priority = 1,enabled = false, description = "Manager can add new Customer using valid data")
	public void addCustomerUsingValidData() throws InterruptedException, IOException {
		String name = randomestring();
		String gender = "male";
		String day = "22";
		String month = "11";
		String year = "1998";
		String address = randomestring();
		String city = randomestring();
		String state = randomestring();
		String pin = "199124";
		String mobile = randomeNum();
		String email = randomestring() + "@gmail.com";
		String password = "12345";

		objNewCustomer = new NewCustomerPage(driver);
		config = new Config();
		
		
		loginToTheApplication();
		objNewCustomer.submitNewCustomerData(name, gender, month, day, year, address, city, state, pin, mobile, email,
				password);
		Thread.sleep(2000);
		if (driver.getPageSource().contains(AddCustomerSuccessMessage)) {
			logger.info("Test Passed");
			config.setCustomerId(driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText());
			Assert.assertTrue(true);
		} else {
			logger.warn("Test Failed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver, "addCustomerUsingValidData");
			Assert.assertTrue(false);
		}

	}
	
	@Test(priority = 2, enabled = false, dataProvider = "AddNewCustomerData", description = "Manager can Reset Customer Form")
	public void resetCustomerForm(String name, String gender, String month, String day, String year, String address,
			String city, String state, String pin, String mobile, String email, String password)
			throws InterruptedException, IOException {
		objNewCustomer = new NewCustomerPage(driver);
		loginToTheApplication();
		objNewCustomer.resetNewCustomerData(name, gender, month, day, year, address, city, state, pin, mobile, email,
				password);
		Thread.sleep(2000);
		if (objNewCustomer.isCustomerNameEmpty()) {
			logger.info("Test passed");
			Assert.assertTrue(true);
		} else {
			logger.warn("Test Failed");
			captureScreen(driver, "resetCustomerForm");
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 3,enabled = false,dataProvider = "AddNewCustomerData", description = "Manager can't add new Customer using valid data")
	public void addCustomerUsingInvalidData(String name, String gender, String month, String day, String year,
			String address, String city, String state, String pin, String mobile, String email, String password)
			throws InterruptedException, IOException {

		objNewCustomer = new NewCustomerPage(driver);
		loginToTheApplication();
		objNewCustomer.submitNewCustomerData(name, gender, month, day, year, address, city, state, pin, mobile, email,
				password);
		Thread.sleep(2000);
		if (isAlertPresent() == true) {
			logger.info("Test Passed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			
			
		} else {
			logger.warn("Test Failed");
			captureScreen(driver, "addCustomerUsingInvalidData");
			Assert.assertTrue(false);
		}

	}

	

	@Test(priority = 4, enabled = false,description = "Manager can delete Customer info using valid Customer Id")
	public void deleteCustomerUsingValidId()throws InterruptedException, IOException {
		
		objDeleteCustomer = new DeleteCustomerPage(driver);
		loginToTheApplication();
		objDeleteCustomer.deleteCustomer(customerId);
		driver.switchTo().alert().accept();
		if(driver.switchTo().alert().getText().contains("Customer deleted Successfully")) {
			logger.info("Test passed");
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
		}else {
			logger.warn("Test Failed");
			captureScreen(driver, "deleteCustomerUsingValidId");
			Assert.assertTrue(false);
		}
		
		

	}
	
	
	@Test(priority = 5, description = "Manager can reset Delete Customer Form")
	public void resetDeleteCustomerForm()throws InterruptedException, IOException {
		
		objDeleteCustomer = new DeleteCustomerPage(driver);
		loginToTheApplication();
		objDeleteCustomer.resetCustomer(customerId);
		if(objDeleteCustomer.isCustomerIdFieldEmpty()==true) {
			logger.info("Test passed");
			Assert.assertTrue(true);
		}else {
			logger.warn("Test Failed");
			captureScreen(driver, "resetDeleteCustomerForm");
			Assert.assertTrue(false);
		}
		
		

	}
	
	

	@DataProvider(name = "AddNewCustomerData")
	String[][] getNewCustomerData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/guru99BankingDemo/testData/CustomerModuleData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "nnn");
		int colCount = XLUtils.getCellCount(path, "nnn", 1);
		String customerData[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				customerData[i - 1][j] = XLUtils.getCellData(path, "nnn", i, j);
			}

		}
		return customerData;
	}

}
