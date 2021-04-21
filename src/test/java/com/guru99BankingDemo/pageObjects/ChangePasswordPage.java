package com.guru99BankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99BankingDemo.testCases.BaseClass;

public class ChangePasswordPage extends BaseClass {
	AccountOptionsPage objAccountOptions;

	WebDriver ldriver;

	public ChangePasswordPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "oldpassword")
	WebElement oldPasswordElement;
	@FindBy(name = "newpassword")
	WebElement newPasswordElement;
	@FindBy(name = "confirmpassword")
	WebElement confirmPasswordElement;
	@FindBy(name = "sub")
	WebElement submitBtnElement;
	@FindBy(name = "res")
	WebElement resetBtnElement;

	public void submitChangePasswordForm(String oldPassword, String newPassword, String confirmPassword) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.changePasswordOption();

		if (oldPassword.isEmpty() && newPassword.isEmpty() && confirmPassword.isEmpty()) {
			submitBtnElement.click();
		} else {
			oldPasswordElement.sendKeys(oldPassword);
			newPasswordElement.sendKeys(newPassword);
			confirmPasswordElement.sendKeys(confirmPassword);
			submitBtnElement.click();
		}

	}

	public void resetChangePasswordForm(String oldPassword, String newPassword, String confirmPassword) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.changePasswordOption();

		oldPasswordElement.sendKeys(oldPassword);
		newPasswordElement.sendKeys(newPassword);
		confirmPasswordElement.sendKeys(confirmPassword);
		resetBtnElement.click();

	}

	public boolean isOldPasswordEmpty() {
		return oldPasswordElement.getText().isEmpty();
	}

}
