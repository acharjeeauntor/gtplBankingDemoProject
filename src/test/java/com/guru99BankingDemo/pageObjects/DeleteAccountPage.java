package com.guru99BankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.guru99BankingDemo.testCases.BaseClass;
import com.guru99BankingDemo.utilities.Config;

public class DeleteAccountPage extends BaseClass {
	AccountOptionsPage objAccountOptions;

	WebDriver ldriver;

	public DeleteAccountPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountno")
	WebElement accountNoElement;
	@FindBy(name = "AccSubmit")
	WebElement submitBtnElement;
	@FindBy(name = "res")
	WebElement resetBtnElement;

	public void AddDeleteAccountNoForm(String accountNo) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.deleteAccountOption();

		if (accountNo.isEmpty()) {
			submitBtnElement.click();
		} else {
			accountNoElement.sendKeys(accountNo);
			submitBtnElement.click();
		}

	}

	public void resetDeleteAccountNoForm(String accountNo) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.deleteAccountOption();

		accountNoElement.sendKeys(accountNo);
		resetBtnElement.click();

	}
	
	public boolean isAccountNoEmpty() {
		return accountNoElement.getText().isEmpty();
	}

}
