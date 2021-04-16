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
	
	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logoutBtnElement;


	public void newCustomerOption() {
		newCustomerBtnElement.click();
	}

	public void ManagerLogoutOption() {
		logoutBtnElement.click();
	}

}
