package com.guru99BankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.guru99BankingDemo.utilities.Config;

public class NewAccountPage {
	AccountOptionsPage objAccountOptions;
	Config config = new Config();

	WebDriver ldriver;

	public NewAccountPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "cusid")
	WebElement customerIdElement;
	@FindBy(name = "selaccount")
	WebElement accountTypeElement;
	@FindBy(xpath = "//option[@value='Savings']")
	WebElement savingsOptionElement;
	@FindBy(name = "inideposit")
	WebElement initialDepositElement;
	@FindBy(name = "button2")
	WebElement submitBtnElement;
	@FindBy(name = "reset")
	WebElement resetBtnElement;

	public void addNewAccount(String customerId, String AccountType, String initialDeposit) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.newAccountOption();
		
		if(customerId.isEmpty()&&initialDeposit.isEmpty()) {
			submitBtnElement.click();
		}else {
			Select accTypeSelect = new Select(accountTypeElement);
			customerIdElement.sendKeys(customerId);
			accTypeSelect.selectByValue(AccountType);
			initialDepositElement.sendKeys(initialDeposit);
			submitBtnElement.click();
		}
		
		
		
	}

	public void resetNewAccountForm(String customerId, String AccountType, String initialDeposit) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.newAccountOption();
		
		Select accTypeSelect = new Select(accountTypeElement);
		customerIdElement.sendKeys(customerId);
		accTypeSelect.selectByValue(AccountType);
		initialDepositElement.sendKeys(initialDeposit);
		resetBtnElement.click();
	}

	public boolean isSavingsSelect() {
		return savingsOptionElement.isSelected();
	}
	public boolean isCustomerIdEmpty() {
		return customerIdElement.getText().isEmpty();
	}

}
