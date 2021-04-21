package com.guru99BankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.guru99BankingDemo.testCases.BaseClass;
import com.guru99BankingDemo.utilities.Config;

public class EditAccountPage extends BaseClass {
	AccountOptionsPage objAccountOptions;
	Config config = new Config();

	WebDriver ldriver;

	public EditAccountPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountno")
	WebElement accountNoElement;
	@FindBy(name = "a_type")
	WebElement accountTypeElement;
	@FindBy(xpath = "//option[@value='Current']")
	WebElement currentOptionElement;
	@FindBy(name = "txtcid")
	WebElement customerIdElement;
	@FindBy(name = "txtinitdep")
	WebElement balanceElement;
	@FindBy(name = "AccSubmit")
	WebElement submitBtnElement;
	@FindBy(name = "res")
	WebElement resetBtnElement;
	@FindBy(name = "AccReset")
	WebElement resetBtnEntryFormElement;

	public void editAccountIdForm(String accountNo) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.editAccountOption();

		if (accountNo.isEmpty()) {
			submitBtnElement.click();
		} else {
			accountNoElement.sendKeys(accountNo);
			submitBtnElement.click();
		}

	}

	public void editAccountEntryForm(String accountNo) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.editAccountOption();
		accountNoElement.sendKeys(accountNo);
		submitBtnElement.click();

		Select accType = new Select(accountTypeElement);
		if (currentOptionElement.isSelected()) {
			accType.selectByValue("Savings");
		} else {
			accType.selectByValue("Current");
		}
		submitBtnElement.click();

	}

	public void resetAccountEntryForm(String accountNo) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.editAccountOption();
		accountNoElement.sendKeys(accountNo);
		submitBtnElement.click();

		Select accType = new Select(accountTypeElement);
		if (currentOptionElement.isSelected()) {
			accType.selectByValue("Savings");
		} else {
			accType.selectByValue("Current");
		}
		resetBtnEntryFormElement.click();

	}

	public void resetAccountIdForm(String accountNo) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.editAccountOption();

		accountNoElement.sendKeys(accountNo);
		resetBtnElement.click();

	}

	public boolean isAccountNoEmpty() {
		return accountNoElement.getText().isEmpty();
	}

	public boolean isCustomerIdBalanceEditable() throws InterruptedException {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.editAccountOption();

		accountNoElement.sendKeys(accountId);
		submitBtnElement.click();
		Thread.sleep(2000);
		if (customerIdElement.isEnabled() && balanceElement.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

}
