package com.guru99BankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.guru99BankingDemo.testCases.BaseClass;


public class BalanceEnquiryPage extends BaseClass {
	AccountOptionsPage objAccountOptions;

	WebDriver ldriver;

	public BalanceEnquiryPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountno")
	WebElement accountNoElement;
	@FindBy(name = "AccSubmit")
	WebElement submitBtnElement;
	@FindBy(name = "res")
	WebElement resetBtnElement;

	public void submitBalanceEnquiryForm(String accountNo) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.balanceEnquiryOption();

		if (accountNo.isEmpty()) {
			submitBtnElement.click();
		} else {
			accountNoElement.sendKeys(accountNo);
			submitBtnElement.click();
		}

	}

	public void resetBalanceEnquiryForm(String accountNo) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.balanceEnquiryOption();
		
		accountNoElement.sendKeys(accountNo);
		resetBtnElement.click();

	}
	
	public boolean isAccountNoEmpty() {
		return accountNoElement.getText().isEmpty();
	}

}
