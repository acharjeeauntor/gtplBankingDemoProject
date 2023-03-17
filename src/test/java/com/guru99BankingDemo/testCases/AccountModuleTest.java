package com.guru99BankingDemo.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99BankingDemo.pageObjects.AccountOptionsPage;
import com.guru99BankingDemo.pageObjects.BalanceEnquiryPage;
import com.guru99BankingDemo.pageObjects.ChangePasswordPage;
import com.guru99BankingDemo.pageObjects.CustomisedStatementPage;
import com.guru99BankingDemo.pageObjects.DeleteAccountPage;
import com.guru99BankingDemo.pageObjects.DepositPage;
import com.guru99BankingDemo.pageObjects.EditAccountPage;
import com.guru99BankingDemo.pageObjects.FundTransferPage;
import com.guru99BankingDemo.pageObjects.MiniStatementPage;
import com.guru99BankingDemo.pageObjects.NewAccountPage;
import com.guru99BankingDemo.pageObjects.WithdrawalPage;
import com.guru99BankingDemo.utilities.Config;
import com.guru99BankingDemo.utilities.XLUtils;

public class AccountModuleTest extends BaseClass {

	String accType = "Current";
	String initialDeposit = "5000";
	String amount = "100";
	String description = "first Deposit";
	String payeeaccount = "91680";
	String newPass = randomeNum() + "!@";

	NewAccountPage objNewAccount;
	EditAccountPage objEditAccount;
	DeleteAccountPage objDeleteAccount;
	DepositPage objDeposit;
	WithdrawalPage objWithdrawal;
	FundTransferPage objFundTransfer;
	ChangePasswordPage objChangePassword;
	BalanceEnquiryPage objBalanceEnquiry;
	MiniStatementPage objMiniStatement;
	CustomisedStatementPage objCustomisedStatement;
	AccountOptionsPage objAccountOptions;
	XLUtils xlutils;
	Config config;

	@Test(priority = 1, description = "Manager can add new Account using valid data",groups= {"Sanity"})
	public void addNewAccountUsingValidData() throws InterruptedException, IOException {

		objNewAccount = new NewAccountPage(driver);
		config = new Config();

		loginToTheApplication();
		objNewAccount.addNewAccount(customerId, accType, initialDeposit);
		Thread.sleep(2000);
		if (driver.getPageSource().contains("Account Generated Successfully!!!")) {
			
			config.setAccountId(driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText());
			AssertJUnit.assertTrue(true);
		} else {
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver, "addNewAccountUsingValidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 2, description = "Manager can reset new Account Form")
	public void resetAddNewAccountForm() throws InterruptedException, IOException {

		objNewAccount = new NewAccountPage(driver);
		config = new Config();

		loginToTheApplication();
		objNewAccount.resetNewAccountForm(customerId, accType, initialDeposit);
		Thread.sleep(2000);
		if (objNewAccount.isCustomerIdEmpty()) {
			
			AssertJUnit.assertTrue(true);
		} else {
			
			captureScreen(driver, "resetAddNewAccountForm");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 3, description = "Manager should view account type Savings by default")
	public void checkSavingsSelected() throws InterruptedException, IOException {

		objNewAccount = new NewAccountPage(driver);
		objAccountOptions = new AccountOptionsPage(driver);

		loginToTheApplication();

		objAccountOptions.newAccountOption();
		if (objNewAccount.isSavingsSelect()) {
			
			AssertJUnit.assertTrue(true);
		} else {
		
			captureScreen(driver, "checkSavingsSelected");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 4, dataProvider = "AddAccountDataProvider", description = "Manager can't add new Account using invalid data")
	public void addNewAccountUsingInvalidData(String customerId, String accType, String initDiposite)
			throws InterruptedException, IOException {

		objNewAccount = new NewAccountPage(driver);
		loginToTheApplication();
		objNewAccount.addNewAccount(customerId, accType, initDiposite);
		Thread.sleep(2000);

		if (isAlertPresent()) {
			
			driver.switchTo().alert().accept();
			AssertJUnit.assertTrue(true);
		} else if (driver.getPageSource().contains("Account Generated Successfully!!!")) {
			
			captureScreen(driver, "addNewAccountUsingInvalidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 5, description = "Manager can edit Account using valid account no")
	public void editAccountUsingValidAccountNo() throws InterruptedException, IOException {

		objEditAccount = new EditAccountPage(driver);
		loginToTheApplication();
		objEditAccount.editAccountIdForm(accountId);
		Thread.sleep(2000);

		if (driver.getPageSource().contains("Edit Account Entry Form")) {
			
			AssertJUnit.assertTrue(true);
		} else {
			
			driver.switchTo().alert().accept();
			captureScreen(driver, "editAccountUsingValidAccountNo");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 6, description = "Manager can reset Account using valid account no")
	public void resetAccountUsingValidAccountNo() throws InterruptedException, IOException {

		objEditAccount = new EditAccountPage(driver);
		loginToTheApplication();
		objEditAccount.resetAccountIdForm(accountId);
		Thread.sleep(2000);

		if (objEditAccount.isAccountNoEmpty()) {
			
			AssertJUnit.assertTrue(true);
		} else {
		
			captureScreen(driver, "resetAccountUsingValidAccountNo");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 7, description = "Manager can edit Account Entry Form using valid account no")
	public void editAccountEntryForm() throws InterruptedException, IOException {

		objEditAccount = new EditAccountPage(driver);
		loginToTheApplication();
		objEditAccount.editAccountEntryForm(accountId);
		Thread.sleep(2000);

		if (driver.getPageSource().contains("Account details updated Successfully!!!")) {
			
			AssertJUnit.assertTrue(true);
		} else {
		
			driver.switchTo().alert().accept();
			captureScreen(driver, "editAccountEntryForm");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 8, description = "Manager can reset Account Entry Form using valid account no")
	public void resetAccountEntryForm() throws InterruptedException, IOException {

		objEditAccount = new EditAccountPage(driver);
		loginToTheApplication();
		objEditAccount.resetAccountEntryForm(accountId);
		Thread.sleep(2000);

		if (driver.getPageSource().contains("Edit Account Entry Form")) {
			
			AssertJUnit.assertTrue(true);
		} else {
			
			captureScreen(driver, "resetAccountEntryForm");
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(priority = 9, dataProvider = "EditDeleteEnquiryAccountNoDataProvider", description = "Manager can't edit Account using Invalid account no")
	public void editAccountUsingInvalidAccountNo(String accountId) throws InterruptedException, IOException {

		objEditAccount = new EditAccountPage(driver);
		loginToTheApplication();
		objEditAccount.editAccountIdForm(accountId);
		Thread.sleep(2000);

		if (isAlertPresent()) {
			
			driver.switchTo().alert().accept();
			AssertJUnit.assertTrue(true);
		} else {
		
			captureScreen(driver, "editAccountUsingInvalidAccountNo");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 10, description = "Manager can't edit Customer Id and Balance")
	public void verifyCustomerIdBalanceEnabled() throws InterruptedException, IOException {

		objEditAccount = new EditAccountPage(driver);
		loginToTheApplication();

		if (objEditAccount.isCustomerIdBalanceEditable()) {
			
			captureScreen(driver, "verifyCustomerIdBalanceEnabled");
			AssertJUnit.assertTrue(false);

		} else {
		
			AssertJUnit.assertTrue(true);
		}

	}

	@Test(priority = 11, description = "Manager can delete account using valid Account No")
	public void deleteAccountUsingValidAccountNo() throws InterruptedException, IOException {

		objDeleteAccount = new DeleteAccountPage(driver);
		loginToTheApplication();
		objDeleteAccount.AddDeleteAccountNoForm(accountId);
		driver.switchTo().alert().accept();

		if (driver.switchTo().alert().getText().contains("Account Deleted Sucessfully")) {
			
			driver.switchTo().alert().accept();
			AssertJUnit.assertTrue(true);

		} else {
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver, "deleteAccountUsingValidAccountNo");
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(priority = 12, description = "Manager can reset delete account form")
	public void resetDeleteAccountForm() throws InterruptedException, IOException {

		objDeleteAccount = new DeleteAccountPage(driver);
		loginToTheApplication();
		objDeleteAccount.resetDeleteAccountNoForm(accountId);
		if (objDeleteAccount.isAccountNoEmpty()) {
			
			AssertJUnit.assertTrue(true);

		} else {
		
			captureScreen(driver, "resetDeleteAccountForm");
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(priority = 13, dataProvider = "EditDeleteEnquiryStatementDataProvider", description = "Manager can't delete account using Invalid Account No")
	public void deleteAccountUsingInvalidAccountNo(String accountId) throws InterruptedException, IOException {

		objDeleteAccount = new DeleteAccountPage(driver);
		loginToTheApplication();
		objDeleteAccount.AddDeleteAccountNoForm(accountId);

		if (driver.switchTo().alert().getText().contains("Please fill all fields")) {
			
			driver.switchTo().alert().accept();
			AssertJUnit.assertTrue(true);

		} else if (driver.switchTo().alert().getText().contains("Do you really want to delete this Account?")) {
			driver.switchTo().alert().accept();
			if (driver.switchTo().alert().getText().contains("Account Deleted Sucessfully")) {
	
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				captureScreen(driver, "deleteAccountUsingInvalidAccountNo");
				AssertJUnit.assertTrue(false);
			} else {
				
				driver.switchTo().alert().accept();
				AssertJUnit.assertTrue(true);
			}
		}
	}

	@Test(priority = 14, description = "Manager can deposit using valid data")
	public void depositUsingValidData() throws InterruptedException, IOException {

		objDeposit = new DepositPage(driver);
		loginToTheApplication();
		objDeposit.submitDeposit(accountId, amount, description);

		if (driver.getPageSource().contains("Transaction details of Deposit for Account " + accountId)) {
			
			AssertJUnit.assertTrue(true);

		} else {
			
			captureScreen(driver, "depositUsingValidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 15, description = "Manager can reset deposit form")
	public void resetDepositForm() throws InterruptedException, IOException {

		objDeposit = new DepositPage(driver);
		loginToTheApplication();
		objDeposit.resetDeposit(accountId, amount, description);

		if (objDeposit.isAccountNoEmpty()) {
			
			AssertJUnit.assertTrue(true);

		} else {
		
			captureScreen(driver, "resetDepositForm");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 16, dataProvider = "DepositDataProvider", description = "Manager can't deposit using Invalid data")
	public void depositUsingInvalidData(String accountId, String amount, String description)
			throws InterruptedException, IOException {

		objDeposit = new DepositPage(driver);
		loginToTheApplication();
		objDeposit.submitDeposit(accountId, amount, description);

		if (isAlertPresent()) {
			
			driver.switchTo().alert().accept();
			AssertJUnit.assertTrue(true);

		} else if (driver.getPageSource().contains("Transaction details of Deposit for Account " + accountId)) {
			
			captureScreen(driver, "depositUsingInvalidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 17, description = "Manager can withdrawal using valid data")
	public void withdrawalUsingValidData() throws InterruptedException, IOException {

		objWithdrawal = new WithdrawalPage(driver);
		loginToTheApplication();
		objWithdrawal.submitWithdrawal(accountId, amount, description);

		if (driver.getPageSource().contains("Transaction details of Withdrawal for Account " + accountId)) {
			
			AssertJUnit.assertTrue(true);

		} else {
		
			captureScreen(driver, "withdrawalUsingValidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 18, description = "Manager can reset withdrawal form")
	public void resetWithdrawalForm() throws InterruptedException, IOException {

		objWithdrawal = new WithdrawalPage(driver);
		loginToTheApplication();
		objWithdrawal.resetWithdrawal(accountId, amount, description);

		if (objWithdrawal.isAccountNoEmpty()) {
			
			AssertJUnit.assertTrue(true);

		} else {
	
			captureScreen(driver, "resetWithdrawalForm");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 19, dataProvider = "WithdrawalDataProvider", description = "Manager can't Withdrawal using Invalid data")
	public void withdrawalUsingInvalidData(String accountId, String amount, String description)
			throws InterruptedException, IOException {

		objWithdrawal = new WithdrawalPage(driver);
		loginToTheApplication();
		objWithdrawal.submitWithdrawal(accountId, amount, description);

		if (isAlertPresent()) {
			
			driver.switchTo().alert().accept();
			AssertJUnit.assertTrue(true);

		} else if (driver.getPageSource().contains("Transaction details of Withdrawal for Account " + accountId)) {
			
			captureScreen(driver, "withdrawalUsingInvalidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 20, description = "Manager can Transfer Fund using valid data")
	public void fundTransferUsingValidData() throws InterruptedException, IOException {

		objFundTransfer = new FundTransferPage(driver);
		loginToTheApplication();
		objFundTransfer.submitFundTransfer(accountId, payeeaccount, amount, description);
		Thread.sleep(2000);

		if (driver.getPageSource().contains("Fund Transfer Details")) {
			
			AssertJUnit.assertTrue(true);

		} else {
			
			captureScreen(driver, "fundTransferUsingValidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 21, description = "Manager can reset Transfer Fund")
	public void resetFundTransferForm() throws InterruptedException, IOException {

		objFundTransfer = new FundTransferPage(driver);
		loginToTheApplication();
		objFundTransfer.resetFundTransferForm(accountId, payeeaccount, amount, description);

		if (objFundTransfer.isAccountNoEmpty()) {
			
			AssertJUnit.assertTrue(true);

		} else {
			
			captureScreen(driver, "resetFundTransferForm");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 22, dataProvider = "FundTransferDataProvider", description = "Manager can't Transfer Fund using Invalid data")
	public void fundTransferUsingInvalidData(String accountId, String payeeaccount, String amount, String description)
			throws InterruptedException, IOException {

		objFundTransfer = new FundTransferPage(driver);
		loginToTheApplication();
		objFundTransfer.submitFundTransfer(accountId, payeeaccount, amount, description);

		if (isAlertPresent()) {
			
			driver.switchTo().alert().accept();
			AssertJUnit.assertTrue(true);

		} else if (driver.getPageSource().contains("Fund Transfer Details")) {
			
			captureScreen(driver, "fundTransferUsingInvalidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 23, description = "Manager can change password using valid data")
	public void changePasswordUsingValidData() throws InterruptedException, IOException {
		config = new Config();
		xlutils = new XLUtils();
		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/guru99BankingDemo/testData/AccountModuleData.xlsx";

		objChangePassword = new ChangePasswordPage(driver);
		loginToTheApplication();
		objChangePassword.submitChangePasswordForm(password, newPass, newPass);

		if (driver.switchTo().alert().getText().contains("Password is Changed")) {
			
			driver.switchTo().alert().accept();
			config.setNewManagerPass(newPass);
			XLUtils.setCellData(path, "ChangePasswordData", 3, 0, newPass);
			XLUtils.setCellData(path, "ChangePasswordData", 4, 0, newPass);
			AssertJUnit.assertTrue(true);
		} else {
			
			captureScreen(driver, "changePasswordUsingValidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 24, description = "Manager can reset change password form")
	public void resetChangePasswordForm() throws InterruptedException, IOException {
		objChangePassword = new ChangePasswordPage(driver);
		Thread.sleep(5000);
		loginToTheApplication();
		objChangePassword.resetChangePasswordForm(password, newPass, newPass);

		if (objChangePassword.isOldPasswordEmpty()) {
			
			AssertJUnit.assertTrue(true);

		} else {
	
			captureScreen(driver, "resetChangePasswordForm");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 25, dataProvider = "ChangePasswordDataProvider", description = "Manager can't change password using Invalid data")
	public void changePasswordUsingInvalidData(String password, String newPass, String confirmPass)
			throws InterruptedException, IOException {
		config = new Config();
		objChangePassword = new ChangePasswordPage(driver);
		loginToTheApplication();
		objChangePassword.submitChangePasswordForm(password, newPass, confirmPass);

		if (driver.switchTo().alert().getText().contains("Password is Changed")) {
			
			driver.switchTo().alert().accept();
			captureScreen(driver, "changePasswordUsingInvalidData");
			config.setNewManagerPass(newPass);
			AssertJUnit.assertTrue(false);

		} else {
	
			driver.switchTo().alert().accept();
			AssertJUnit.assertTrue(true);
		}

	}

	@Test(priority = 26, description = "Manager can balance enquiry using valid data")
	public void balanceEquiryUsingValidData() throws InterruptedException, IOException {
		objBalanceEnquiry = new BalanceEnquiryPage(driver);
		loginToTheApplication();
		objBalanceEnquiry.submitBalanceEnquiryForm(accountId);

		if (driver.getPageSource().contains("Balance Details for Account " + accountId)) {
			
			AssertJUnit.assertTrue(true);

		} else {
			
			driver.switchTo().alert().accept();
			captureScreen(driver, "balanceEquiryUsingValidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 27, description = "Manager can reset  balance enquiry form")
	public void resetBalanceEnquiryForm() throws InterruptedException, IOException {
		objBalanceEnquiry = new BalanceEnquiryPage(driver);
		loginToTheApplication();
		objBalanceEnquiry.resetBalanceEnquiryForm(accountId);

		if (objBalanceEnquiry.isAccountNoEmpty()) {
			
			AssertJUnit.assertTrue(true);

		} else {
			
			captureScreen(driver, "resetBalanceEnquiryForm");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 28, dataProvider = "EditDeleteEnquiryStatementDataProvider", description = "Manager can't balance enquiry using Invalid data")
	public void balanceEquiryUsingInvalidData(String accountId) throws InterruptedException, IOException {
		objBalanceEnquiry = new BalanceEnquiryPage(driver);
		loginToTheApplication();
		objBalanceEnquiry.submitBalanceEnquiryForm(accountId);

		if (isAlertPresent()) {
			
			driver.switchTo().alert().accept();
			AssertJUnit.assertTrue(true);

		} else {
			
			captureScreen(driver, "balanceEquiryUsingInvalidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 29, description = "Manager can view Mini Statement using valid data")
	public void miniStatementUsingValidData() throws InterruptedException, IOException {
		objMiniStatement = new MiniStatementPage(driver);
		loginToTheApplication();
		objMiniStatement.submitMiniStatementForm(accountId);

		if (driver.getPageSource().contains("Last Five Transaction Details for Account No: " + accountId)) {
			
			AssertJUnit.assertTrue(true);

		} else {
			
			driver.switchTo().alert().accept();
			captureScreen(driver, "miniStatementUsingValidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 30, description = "Manager can reset Mini Statement form")
	public void resetMiniStatementForm() throws InterruptedException, IOException {
		objMiniStatement = new MiniStatementPage(driver);
		loginToTheApplication();
		objMiniStatement.resetMiniStatementForm(accountId);

		if (objMiniStatement.isAccountNoEmpty()) {
			
			AssertJUnit.assertTrue(true);

		} else {
		
			captureScreen(driver, "resetMiniStatementForm");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 31, dataProvider = "EditDeleteEnquiryStatementDataProvider", description = "Manager can't view mini statement using Invalid data")
	public void miniStatementUsingInvalidData(String accountId) throws InterruptedException, IOException {
		objMiniStatement = new MiniStatementPage(driver);
		loginToTheApplication();
		objMiniStatement.submitMiniStatementForm(accountId);

		if (isAlertPresent()) {
			
			driver.switchTo().alert().accept();
			AssertJUnit.assertTrue(true);

		} else {
			
			captureScreen(driver, "miniStatementUsingInvalidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 32, description = "Manager can view Customised Statement using valid data")
	public void customisedStatementUsingValidData() throws InterruptedException, IOException {
		objCustomisedStatement = new CustomisedStatementPage(driver);
		loginToTheApplication();
		objCustomisedStatement.submitCustomizedStatementForm(accountId, "4", "20", "2021", "4", "21", "2021", "500",
				"1");

		if (driver.getPageSource().contains("Transaction Details for Account No: " + accountId)) {
			
			AssertJUnit.assertTrue(true);

		} else {
		
			driver.switchTo().alert().accept();
			captureScreen(driver, "customisedStatementUsingValidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 33, description = "Manager can reset Customised Statement form")
	public void resetCustomisedStatementForm() throws InterruptedException, IOException {
		objCustomisedStatement = new CustomisedStatementPage(driver);
		loginToTheApplication();
		objCustomisedStatement.resetCustomizedStatementForm(accountId, "4", "20", "2021", "4", "21", "2021", "500",
				"1");

		if (objCustomisedStatement.isAccountNoEmpty()) {
		
			AssertJUnit.assertTrue(true);

		} else {
	
			captureScreen(driver, "resetCustomisedStatementForm");
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(priority = 34, dataProvider = "CustomisedStatementDataProvider", description = "Manager can't view Customised Statement using Invalid data")
	public void customisedStatementUsingInvalidData(String accountNo, String fromDateMonth, String fromDateDay,
			String fromDateYear, String toDateMonth, String toDateDay, String toDateYear, String miniTrans,
			String noTrans) throws InterruptedException, IOException {
		objCustomisedStatement = new CustomisedStatementPage(driver);
		loginToTheApplication();
		objCustomisedStatement.submitCustomizedStatementForm(accountNo, fromDateMonth, fromDateDay, fromDateYear,
				toDateMonth, toDateDay, toDateYear, miniTrans, noTrans);
		Thread.sleep(2000);
		if (isAlertPresent()) {
			
			driver.switchTo().alert().accept();
			AssertJUnit.assertTrue(true);

		} else {
		
			captureScreen(driver, "customisedStatementUsingInvalidData");
			AssertJUnit.assertTrue(false);
		}

	}

	@DataProvider(name = "AddAccountDataProvider")
	Object[][] getAddAccountData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/guru99BankingDemo/testData/AccountModuleData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "AddAccountData");
		int colCount = XLUtils.getCellCount(path, "AddAccountData", 1);
		Object[][] customerData = new Object[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				customerData[i - 1][j] = XLUtils.getCellData(path, "AddAccountData", i, j);
			}

		}
		return customerData;
	}

	@DataProvider(name = "EditDeleteEnquiryStatementDataProvider")
	Object[][] getEditAccountNoData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/guru99BankingDemo/testData/AccountModuleData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "EditDeleteEnquiryStatementData");
		int colCount = XLUtils.getCellCount(path, "EditDeleteEnquiryStatementData", 1);
		Object[][] customerData = new Object[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				customerData[i - 1][j] = XLUtils.getCellData(path, "EditDeleteEnquiryStatementData", i, j);
			}

		}
		return customerData;
	}

	@DataProvider(name = "WithdrawalDataProvider")
	Object[][] getWithdrawalData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/guru99BankingDemo/testData/AccountModuleData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "WithdrawalData");
		int colCount = XLUtils.getCellCount(path, "WithdrawalData", 1);
		Object[][] customerData= new Object[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				customerData[i - 1][j] = XLUtils.getCellData(path, "WithdrawalData", i, j);
			}

		}
		return customerData;
	}

	@DataProvider(name = "DepositDataProvider")
	Object[][] getDepositData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/guru99BankingDemo/testData/AccountModuleData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "DepositData");
		int colCount = XLUtils.getCellCount(path, "DepositData", 1);
		Object[][] customerData = new Object[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				customerData[i - 1][j] = XLUtils.getCellData(path, "DepositData", i, j);
			}

		}
		return customerData;
	}

	@DataProvider(name = "FundTransferDataProvider")
	Object[][] getFundTransferData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/guru99BankingDemo/testData/AccountModuleData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "FundTransferData");
		int colCount = XLUtils.getCellCount(path, "FundTransferData", 1);
		Object[][] customerData= new Object[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				customerData[i - 1][j] = XLUtils.getCellData(path, "FundTransferData", i, j);
			}

		}
		return customerData;
	}

	@DataProvider(name = "ChangePasswordDataProvider")
	Object[][] getChangePasswordData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/guru99BankingDemo/testData/AccountModuleData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "ChangePasswordData");
		int colCount = XLUtils.getCellCount(path, "ChangePasswordData", 1);
		Object[][] customerData= new Object[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				customerData[i - 1][j] = XLUtils.getCellData(path, "ChangePasswordData", i, j);
			}

		}
		return customerData;
	}

	@DataProvider(name = "CustomisedStatementDataProvider")
	Object[][] getCustomisedStatementData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/guru99BankingDemo/testData/AccountModuleData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "CustomisedStatementData");
		int colCount = XLUtils.getCellCount(path, "CustomisedStatementData", 1);
		Object[][] customerData = new Object[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				customerData[i - 1][j] = XLUtils.getCellData(path, "CustomisedStatementData", i, j);
			}

		}
		return customerData;
	}

}
