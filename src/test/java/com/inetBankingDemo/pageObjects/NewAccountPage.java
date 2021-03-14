package com.inetBankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
	WebDriver ldriver;

	public NewAccountPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='New Account']")
	WebElement lnkNewAccount;

	@FindBy(xpath = "//input[@name='cusid']")
	WebElement customerId;

	@FindBy(xpath = "//select[@name='selaccount']")
	WebElement accountType;

	@FindBy(xpath = "//input[@name='inideposit']")
	WebElement InitDeposit;

	@FindBy(xpath = "//input[@name='button2']")
	WebElement submitBtn;

	@FindBy(xpath = "//input[@name='reset']")
	WebElement resetBtn;

	public void lnkNewAccount() {
		lnkNewAccount.click();
	}

	public void cId(String id) {
		customerId.sendKeys(id);
	}

	public void accountType(String accType) {
		Select se = new Select(accountType);
		se.selectByValue(accType);
	}

	public void InitDeposit(String amount) {
		InitDeposit.sendKeys(amount);
	}

	public void submitBtn() {
		submitBtn.click();
	}

	public void resetBtn() {
		resetBtn.click();
	}
}
