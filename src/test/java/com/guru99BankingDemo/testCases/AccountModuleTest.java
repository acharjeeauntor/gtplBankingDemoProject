package com.guru99BankingDemo.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99BankingDemo.pageObjects.AccountOptionsPage;
import com.guru99BankingDemo.pageObjects.DeleteAccountPage;
import com.guru99BankingDemo.pageObjects.EditAccountPage;
import com.guru99BankingDemo.pageObjects.NewAccountPage;
import com.guru99BankingDemo.utilities.Config;
import com.guru99BankingDemo.utilities.XLUtils;

public class AccountModuleTest extends BaseClass {

	String accType = "Current";
	String initialDeposit = "5000";

	NewAccountPage objNewAccount;
	EditAccountPage objEditAccount;
	DeleteAccountPage objDeleteAccount;
	AccountOptionsPage objAccountOptions;

//	@Test(priority = 1,description = "Manager can add new Account using valid data")
//	public void addNewAccountUsingValidData() throws InterruptedException, IOException {
//
//		objNewAccount= new NewAccountPage(driver);
//		config = new Config();
//
//		loginToTheApplication();
//		objNewAccount.addNewAccount(customerId, accType, initialDeposit);
//		Thread.sleep(2000);
//		if (driver.getPageSource().contains("Account Generated Successfully!!!")) {
//			logger.info("Test Passed");
//			config.setAccountId(driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText());
//			Assert.assertTrue(true);
//		} else {
//			logger.warn("Test Failed");
//			driver.switchTo().alert().accept();
//			driver.switchTo().defaultContent();
//			captureScreen(driver, "addNewAccountUsingValidData");
//			Assert.assertTrue(false);
//		}
//
//	}
//	
//	
//	@Test(priority = 2,description = "Manager can reset new Account Form")
//	public void resetAddNewAccountForm() throws InterruptedException, IOException {
//
//		objNewAccount= new NewAccountPage(driver);
//		config = new Config();
//
//		loginToTheApplication();
//		objNewAccount.resetNewAccountForm(customerId, accType, initialDeposit);
//		Thread.sleep(2000);
//		if (objNewAccount.isCustomerIdEmpty()==true) {
//			logger.info("Test Passed");
//			Assert.assertTrue(true);
//		} else {
//			logger.warn("Test Failed");
//			captureScreen(driver, "resetAddNewAccountForm");
//			Assert.assertTrue(false);
//		}
//
//	}
//	
//	@Test(priority = 3,description = "Manager should view account type Savings by default")
//	public void checkSavingsSelected() throws InterruptedException, IOException {
//
//		objNewAccount= new NewAccountPage(driver);
//		objAccountOptions = new AccountOptionsPage(driver);
//		
//		loginToTheApplication();
//		
//		objAccountOptions.newAccountOption();
//		if (objNewAccount.isSavingsSelect()==true) {
//			logger.info("Test Passed");
//			Assert.assertTrue(true);
//		} else {
//			logger.warn("Test Failed");
//			captureScreen(driver, "checkSavingsSelected");
//			Assert.assertTrue(false);
//		}
//
//	}

//	@Test(priority = 4,dataProvider="AddAccountDataProvider",description = "Manager can't add new Account using invalid data")
//	public void addNewAccountUsingInvalidData(String customerId,String accType,String initDiposite) throws InterruptedException, IOException {
//
//		objNewAccount= new NewAccountPage(driver);
//		loginToTheApplication();
//		objNewAccount.addNewAccount(customerId, accType, initDiposite);
//		Thread.sleep(2000);
//		
//		 if (isAlertPresent()==true) {
//			logger.info("Test Passed");
//			driver.switchTo().alert().accept();
//			Assert.assertTrue(true);
//		} else if(driver.getPageSource().contains("Account Generated Successfully!!!")){
//			logger.warn("Test Failed");
//			captureScreen(driver, "addNewAccountUsingInvalidData");
//			Assert.assertTrue(false);
//		}
//
//	}

//	@Test(priority = 5,description = "Manager can edit Account using valid account no")
//	public void editAccountUsingValidAccountNo() throws InterruptedException, IOException {
//
//		objEditAccount= new EditAccountPage(driver);
//		loginToTheApplication();
//		objEditAccount.editAccountIdForm(accountId);
//		Thread.sleep(2000);
//		
//		 if (driver.getPageSource().contains("Edit Account Entry Form")) {
//			logger.info("Test Passed");
//			Assert.assertTrue(true);
//		} else{
//			logger.warn("Test Failed");
//			driver.switchTo().alert().accept();
//			captureScreen(driver, "editAccountUsingValidAccountNo");
//			Assert.assertTrue(false);
//		}
//
//	}
//	
//	@Test(priority = 6,description = "Manager can reset Account using valid account no")
//	public void resetAccountUsingValidAccountNo() throws InterruptedException, IOException {
//
//		objEditAccount= new EditAccountPage(driver);
//		loginToTheApplication();
//		objEditAccount.resetAccountIdForm(accountId);
//		Thread.sleep(2000);
//		
//		 if (objEditAccount.isAccountNoEmpty()) {
//			logger.info("Test Passed");
//			Assert.assertTrue(true);
//		} else{
//			logger.warn("Test Failed");
//			captureScreen(driver, "resetAccountUsingValidAccountNo");
//			Assert.assertTrue(false);
//		}
//
//	}
//	
//	
//	
//	@Test(priority = 7,description = "Manager can edit Account Entry Form using valid account no")
//	public void editAccountEntryForm() throws InterruptedException, IOException {
//
//		objEditAccount= new EditAccountPage(driver);
//		loginToTheApplication();
//		objEditAccount.editAccountEntryForm(accountId);
//		Thread.sleep(2000);
//		
//		 if (driver.getPageSource().contains("Account details updated Successfully!!!")) {
//			logger.info("Test Passed");
//			Assert.assertTrue(true);
//		} else{
//			logger.warn("Test Failed");
//			driver.switchTo().alert().accept();
//			captureScreen(driver, "editAccountEntryForm");
//			Assert.assertTrue(false);
//		}
//
//	}
//	
//	
//	@Test(priority = 8,description = "Manager can reset Account Entry Form using valid account no")
//	public void resetAccountEntryForm() throws InterruptedException, IOException {
//
//		objEditAccount= new EditAccountPage(driver);
//		loginToTheApplication();
//		objEditAccount.resetAccountEntryForm(accountId);
//		Thread.sleep(2000);
//		
//		 if (driver.getPageSource().contains("Edit Account Entry Form")) {
//			logger.info("Test Passed");
//			Assert.assertTrue(true);
//		} else{
//			logger.warn("Test Failed");
//			captureScreen(driver, "resetAccountEntryForm");
//			Assert.assertTrue(false);
//		}
//	}

//	@Test(priority = 9,dataProvider="EditAccountNoDataProvider",description = "Manager can't edit Account using Invalid account no")
//	public void editAccountUsingInvalidAccountNo(String accountId) throws InterruptedException, IOException {
//
//		objEditAccount= new EditAccountPage(driver);
//		loginToTheApplication();
//		objEditAccount.editAccountIdForm(accountId);
//		Thread.sleep(2000);
//		
//		 if (isAlertPresent()) {
//			logger.info("Test Passed");
//			driver.switchTo().alert().accept();
//			Assert.assertTrue(true);
//		} else{
//			logger.warn("Test Failed");
//			captureScreen(driver, "editAccountUsingInvalidAccountNo");
//			Assert.assertTrue(false);
//		}
//
//	}

//	@Test(priority = 10, description = "Manager can't edit Customer Id and Balance")
//	public void verifyCustomerIdBalanceEnabled() throws InterruptedException, IOException {
//
//		objEditAccount = new EditAccountPage(driver);
//		loginToTheApplication();
//
//		if (objEditAccount.isCustomerIdBalanceEditable()) {
//			logger.warn("Test Failed");
//			captureScreen(driver, "verifyCustomerIdBalanceEnabled");
//			Assert.assertTrue(false);
//
//		} else {
//			logger.info("Test Passed");
//			Assert.assertTrue(true);
//		}

	// }

//	@Test(priority = 11, description = "Manager can delete account using valid Account No")
//	public void deleteAccountUsingValidAccountNo() throws InterruptedException, IOException {
//
//		objDeleteAccount = new DeleteAccountPage(driver);
//		loginToTheApplication();
//		objDeleteAccount.AddDeleteAccountNoForm(accountId);
//		driver.switchTo().alert().accept();
//
//		if (driver.switchTo().alert().getText().contains("Account Deleted Sucessfully")) {
//			logger.info("Test Passed");
//			driver.switchTo().alert().accept();
//			Assert.assertTrue(true);
//
//		} else {
//			logger.warn("Test Failed");
//			driver.switchTo().alert().accept();
//			driver.switchTo().defaultContent();
//			captureScreen(driver, "deleteAccountUsingValidAccountNo");
//			Assert.assertTrue(false);
//		}
//	}
//	
//	
//	@Test(priority = 12, description = "Manager can reset delete account form")
//	public void resetDeleteAccountForm() throws InterruptedException, IOException {
//
//		objDeleteAccount = new DeleteAccountPage(driver);
//		loginToTheApplication();
//		objDeleteAccount.resetDeleteAccountNoForm(accountId);
//		if (objDeleteAccount.isAccountNoEmpty()) {
//			logger.info("Test Passed");
//			Assert.assertTrue(true);
//
//		} else {
//			logger.warn("Test Failed");
//			captureScreen(driver, "resetDeleteAccountForm");
//			Assert.assertTrue(false);
//		}
//	}
	
	
	
	@Test(priority = 13,dataProvider="EditDeleteAccountNoDataProvider",description = "Manager can't delete account using Invalid Account No")
	public void deleteAccountUsingInvalidAccountNo(String accountId) throws InterruptedException, IOException {

		objDeleteAccount = new DeleteAccountPage(driver);
		loginToTheApplication();
		objDeleteAccount.AddDeleteAccountNoForm(accountId);

		if (driver.switchTo().alert().getText().contains("Please fill all fields")) {
			logger.info("Test Passed");
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);

		}else if(driver.switchTo().alert().getText().contains("Do you really want to delete this Account?")) {
			driver.switchTo().alert().accept();
			if(driver.switchTo().alert().getText().contains("Account Deleted Sucessfully")) {
				logger.warn("Test Failed");
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				captureScreen(driver, "deleteAccountUsingInvalidAccountNo");
				Assert.assertTrue(false);
			}else {
				logger.info("Test Passed");
				driver.switchTo().alert().accept();
				Assert.assertTrue(true);
			}
		}
	}
	
	
	
	
	
	
	
	
	

	@DataProvider(name = "AddAccountDataProvider")
	String[][] getAddAccountData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/guru99BankingDemo/testData/AccountModuleData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "AddAccountData");
		int colCount = XLUtils.getCellCount(path, "AddAccountData", 1);
		String customerData[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				customerData[i - 1][j] = XLUtils.getCellData(path, "AddAccountData", i, j);
			}

		}
		return customerData;
	}

	@DataProvider(name = "EditDeleteAccountNoDataProvider")
	String[][] getEditAccountNoData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/guru99BankingDemo/testData/AccountModuleData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "EditDeleteAccountNoData");
		int colCount = XLUtils.getCellCount(path, "EditDeleteAccountNoData", 1);
		String customerData[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				customerData[i - 1][j] = XLUtils.getCellData(path, "EditDeleteAccountNoData", i, j);
			}

		}
		return customerData;
	}

}
