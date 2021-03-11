package com.inetBankingDemo.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		// This initElements method will create all WebElements
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@name='uid']")
	WebElement txtUserId;

	@FindBy(name = "password")
	WebElement txtUserPassword;

	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement loginBtn;

	@FindBy(name = "btnReset")
	WebElement resetBtn;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement logoutBtn;

	public void setUserId(String uId) {
		txtUserId.sendKeys(uId);
	}

	public void setUserPassword(String pass) {
		txtUserPassword.sendKeys(pass);
	}

	public void clickLogin() {
		loginBtn.click();
	}

	public void clickReset() {
		resetBtn.click();
	}
	public void clickLogout() {
		logoutBtn.click();
	}

}
