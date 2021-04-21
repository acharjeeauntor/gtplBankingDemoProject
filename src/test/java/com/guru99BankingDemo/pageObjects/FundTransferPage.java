package com.guru99BankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99BankingDemo.testCases.BaseClass;

public class FundTransferPage extends BaseClass {
	AccountOptionsPage objAccountOptions;

	WebDriver ldriver;

	public FundTransferPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "payersaccount")
	WebElement payersaccountElement;
	@FindBy(name = "payeeaccount")
	WebElement payeeaccountElement;
	@FindBy(name = "ammount")
	WebElement ammountElement;
	@FindBy(name = "desc")
	WebElement descriptionElement;
	@FindBy(name = "AccSubmit")
	WebElement submitBtnElement;
	@FindBy(name = "res")
	WebElement resetBtnElement;

	public void submitFundTransfer(String payersaccount,String payeeaccount,String ammount,String description) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.fundTransferOption();

		if (payersaccount.isEmpty()&&payeeaccount.isEmpty()&&ammount.isEmpty()) {
			submitBtnElement.click();
		} else {
			payersaccountElement.sendKeys(payersaccount);
			payeeaccountElement.sendKeys(payeeaccount);
			ammountElement.sendKeys(ammount);
			descriptionElement.sendKeys(description);
			submitBtnElement.click();
		}

	}

	public void resetFundTransferForm(String payersaccount,String payeeaccount,String ammount,String description) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.fundTransferOption();

		payersaccountElement.sendKeys(payersaccount);
		payeeaccountElement.sendKeys(payeeaccount);
		ammountElement.sendKeys(ammount);
		descriptionElement.sendKeys(description);
		resetBtnElement.click();

	}
	
	public boolean isAccountNoEmpty() {
		return ammountElement.getText().isEmpty();
	}

}
