package com.guru99BankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ManagerLoginPage {
	WebDriver ldriver;

	public ManagerLoginPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	WebElement userIdElement;

	@FindBy(name = "password")
	WebElement passwordElement;

	@FindBy(name = "btnLogin")
	WebElement loginBtnElement;

	

	public void ManagerLogin(String uId,String password) {
		userIdElement.sendKeys(uId);
		passwordElement.sendKeys(password);
		loginBtnElement.submit();
	}

}
