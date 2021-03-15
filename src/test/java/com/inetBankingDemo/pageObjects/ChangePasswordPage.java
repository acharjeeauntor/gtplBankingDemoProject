package com.inetBankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	WebDriver ldriver;

	public ChangePasswordPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Change Password']")
	WebElement lnkChangePassword;

	@FindBy(xpath = "//input[@name='oldpassword']")
	WebElement oldPassword;
	
	@FindBy(xpath = "//input[@name='newpassword']")
	WebElement newPassword;

	@FindBy(xpath = "//input[@name='confirmpassword']")
	WebElement confirmPass;

	@FindBy(xpath = "//input[@name='sub']")
	WebElement submitBtn;

	@FindBy(xpath = "//input[@name='res']")
	WebElement resetBtn;

	public void lnkChangePassword() {
		lnkChangePassword.click();
	}

	public void setOldPass(String pass) {
		oldPassword.sendKeys(pass);
	}
	
	public void setNewPass(String pass) {
		newPassword.sendKeys(pass);
	}

	public void setConfirmPass(String pass) {
		confirmPass.sendKeys(pass);
	}

	public void submitBtn() {
		submitBtn.click();
	}

	public void resetBtn() {
		resetBtn.click();
	}
}
