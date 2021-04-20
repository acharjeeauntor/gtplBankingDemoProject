package com.guru99BankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountOptionsPage {
	WebDriver ldriver;

	public AccountOptionsPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement newCustomerBtnElement;
	
	@FindBy(xpath = "//a[text()='Edit Customer']")
	WebElement editCustomerBtnElement;
	
	@FindBy(xpath = "//a[text()='Delete Customer']")
	WebElement deleteCustomerBtnElement;
	
	@FindBy(xpath = "//a[text()='New Account']")
	WebElement newAccountBtnElement;
	
	@FindBy(xpath = "//a[text()='Edit Account']")
	WebElement editAccountBtnElement;
	
	@FindBy(xpath = "//a[text()='Delete Account']")
	WebElement deleteAccountBtnElement;
	
	@FindBy(xpath = "//a[text()='Deposit']")
	WebElement depositBtnElement;
	
	@FindBy(xpath = "//a[text()='Withdrawal']")
	WebElement withdrawalBtnElement;
	
	@FindBy(xpath = "//a[text()='Fund Transfer']")
	WebElement fundTransferBtnElement;
	
	@FindBy(xpath = "//a[text()='Change Password']")
	WebElement changePasswordBtnElement;
	
	@FindBy(xpath = "//a[text()='Balance Enquiry']")
	WebElement balanceEnquiryBtnElement;
	
	@FindBy(xpath = "//a[text()='Mini Statement']")
	WebElement miniStatementBtnElement;
	
	@FindBy(xpath = "//a[text()='Customised Statement']")
	WebElement customisedStatementBtnElement;
	
	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logoutBtnElement;


	public void newCustomerOption() {
		newCustomerBtnElement.click();
	}
	public void editCustomerOption() {
		editCustomerBtnElement.click();
	}

	public void deleteCustomerOption() {
		deleteCustomerBtnElement.click();
	}
	public void ManagerLogoutOption() {
		logoutBtnElement.click();
	}
	public void newAccountOption() {
		newAccountBtnElement.click();
	}
	public void editAccountOption() {
		editAccountBtnElement.click();
	}

	public void deleteAccountOption() {
		deleteAccountBtnElement.click();
	}
	public void depositOption() {
		depositBtnElement.click();
	}
	public void withdrawalOption() {
		withdrawalBtnElement.click();
	}
	public void fundTransferOption() {
		fundTransferBtnElement.click();
	}

	public void changePasswordOption() {
		changePasswordBtnElement.click();
	}
	public void balanceEnquiryOption() {
		balanceEnquiryBtnElement.click();
	}
	public void miniStatementOption() {
		miniStatementBtnElement.click();
	}
	public void customisedStatementOption() {
		customisedStatementBtnElement.click();
	}

}
