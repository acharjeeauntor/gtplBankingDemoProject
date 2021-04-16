package com.guru99BankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.guru99BankingDemo.pageObjects.NewCustomerPage;
import com.guru99BankingDemo.utilities.XLUtils;

public class CustomerModuleTest extends BaseClass {

	String AddCustomerSuccessMessage = "Customer Registered Successfully!!!";

	NewCustomerPage objNewCustomer;

	@Test(priority = 1,dataProvider = "AddNewCustomerData", description = "Add new Customer using valid and invalid data")
	public void addNewCustomer(String name, String gender, String month, String day, String year, String address,
			String city, String state, String pin, String mobile, String email, String password)
			throws InterruptedException, IOException {
		
		objNewCustomer = new NewCustomerPage(driver);
		
		driver.get(baseUrl);
		loginToTheApplication();
		objNewCustomer.submitNewCustomerData(name, gender, month, day, year, address, city, state, pin, mobile, email,
				password);
		Thread.sleep(2000);
		if (driver.getPageSource().contains(AddCustomerSuccessMessage)) {
			System.out.println("Pass");
			Assert.assertTrue(true);
			
		} else{
			System.out.println("Fail");
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			captureScreen(driver, "addNewCustomer");
			Assert.fail();
		}

	}

	
	@Test(priority = 2, enabled=false,dataProvider = "AddNewCustomerData", description = "Reset Customer Form")
	public void resetCustomerForm(String name, String gender, String month, String day, String year, String address,
			String city, String state, String pin, String mobile, String email, String password)
			throws InterruptedException, IOException {
		objNewCustomer = new NewCustomerPage(driver);
		loginToTheApplication();
		objNewCustomer.resetNewCustomerData(name, gender, month, day, year, address, city, state, pin, mobile, email,
				password);
		Thread.sleep(2000);
		if (objNewCustomer.isCustomerNameEmpty()) {
			System.out.println("Pass");
			Assert.assertTrue(true);
		} else {
			System.out.println("Fail");
			captureScreen(driver, "resetCustomerForm");
			Assert.fail();
		}

	}
	
	
	@DataProvider(name = "AddNewCustomerData")
	String[][] getNewCustomerData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/guru99BankingDemo/testData/Data.xlsx";

		int rowNum = XLUtils.getRowCount(path, "newData");
		int colCount = XLUtils.getCellCount(path, "newData", 1);
		String customerData[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				customerData[i - 1][j] = XLUtils.getCellData(path, "newData", i, j);
			}

		}
		return customerData;
	}

}
