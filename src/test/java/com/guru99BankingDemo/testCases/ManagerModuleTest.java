package com.guru99BankingDemo.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99BankingDemo.pageObjects.AccountOptionsPage;
import com.guru99BankingDemo.pageObjects.ManagerLoginPage;
import com.guru99BankingDemo.pageObjects.ManagerRegistrationPage;
import com.guru99BankingDemo.utilities.XLUtils;

public class ManagerModuleTest extends BaseClass {

	ManagerRegistrationPage objManagerRegistration;
	ManagerLoginPage objManagerLogin;
	AccountOptionsPage objAccountOptions;
	String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";

	@Test(priority = 1, description = "Manager can Registration using Valid Data",groups= {"Sanity"})
	public void registerUsingValidEmail() throws IOException {
	objManagerRegistration = new ManagerRegistrationPage(driver);
		driver.get(baseUrl);
		objManagerRegistration.ManagerRegistration(randomestring()+"@gmail.com");
		if (driver.getPageSource().contains("Access details to demo site.")) {
			objManagerRegistration.setManagerInfo();
			
			AssertJUnit.assertTrue(true);
		} else {
			captureScreen(driver, "registerUsingValidEmail");
			
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(priority = 2, dataProvider = "RegistrationManagerData", description = "Manager can't Registration using Invalid Data")
	public void registerUsingInvalidEmail(String email) throws IOException {
		objManagerRegistration = new ManagerRegistrationPage(driver);
		driver.get(baseUrl);
		objManagerRegistration.ManagerRegistration(email);
		if (driver.getPageSource().contains("Access details to demo site.")) {
			
			captureScreen(driver, "registerUsingInvalidEmail");
			AssertJUnit.assertTrue(false);
		} else {
			
			AssertJUnit.assertTrue(true);
		}
	}

	@Test(priority = 3, description = "Manager can Login Account using Valid UserId and Password",groups= {"Sanity"})
	public void loginUsingValidData() throws IOException, InterruptedException {
		objManagerLogin = new ManagerLoginPage(driver);
		driver.get(baseUrl);
		objManagerLogin.ManagerLogin(userId, password);
		Thread.sleep(2000);
		if (driver.getPageSource().contains(welcomeMessage)) {
			
			AssertJUnit.assertTrue(true);
		} else {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver, "loginUsingValidData");
			
			AssertJUnit.assertTrue(false);

		}

	}

	@Test(priority = 4, dataProvider = "LoginManagerData", description = "Manager can't Login Account using Invalid UserId and Password")
	public void loginUsingInvalidData(String uId, String pass) throws IOException, InterruptedException {
		objManagerLogin = new ManagerLoginPage(driver);
		driver.get(baseUrl);
		objManagerLogin.ManagerLogin(uId, pass);
		Thread.sleep(2000);
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			AssertJUnit.assertTrue(true);

		} else {
			
			captureScreen(driver, "loginUsingInvalidData");
			AssertJUnit.assertTrue(false);

		}

	}

	@Test(priority = 5, description = "Logout from Manager Account")
	public void managerAccountLogout() throws IOException, InterruptedException {
		objAccountOptions = new AccountOptionsPage(driver);
		loginToTheApplication();
		Thread.sleep(2000);
		objAccountOptions.ManagerLogoutOption();
		if (driver.switchTo().alert().getText().contains("You Have Succesfully Logged Out!!")) {
			AssertJUnit.assertTrue(true);
			
			driver.switchTo().alert().accept();
		} else {
			
			captureScreen(driver, "managerAccountLogout");
			AssertJUnit.assertTrue(false);
		}
	}

	@DataProvider(name = "RegistrationManagerData")
	Object[][] getRegistrationManagerData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/guru99BankingDemo/testData/ManagerModuleData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "ManagerRegistrationData");
		int colCount = XLUtils.getCellCount(path, "ManagerRegistrationData", 1);
		Object[][] registrationData = new Object[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				registrationData[i - 1][j] = XLUtils.getCellData(path, "ManagerRegistrationData", i, j);
			}

		}
		return registrationData;
	}

	@DataProvider(name = "LoginManagerData")
	Object[][] getLoginManagerData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/guru99BankingDemo/testData/ManagerModuleData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "ManagerLoginData");
		int colCount = XLUtils.getCellCount(path, "ManagerLoginData", 1);
		Object[][] loginData = new Object[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(path, "ManagerLoginData", i, j);
			}

		}
		return loginData;
	}

}
