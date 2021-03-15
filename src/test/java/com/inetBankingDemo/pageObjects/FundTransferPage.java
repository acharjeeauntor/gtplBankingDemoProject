package com.inetBankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage {
	WebDriver ldriver;

	public FundTransferPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Fund Transfer']")
	WebElement lnkFundTransfer;

	@FindBy(xpath = "//input[@name='payersaccount']")
	WebElement payersAccountNo;
	
	@FindBy(xpath = "//input[@name='payeeaccount']")
	WebElement payeesAccountNo;

	@FindBy(xpath = "//input[@name='ammount']")
	WebElement amount;

	@FindBy(xpath = "//input[@name='desc']")
	WebElement description;

	@FindBy(xpath = "//input[@name='AccSubmit']")
	WebElement submitBtn;

	@FindBy(xpath = "//input[@name='res']")
	WebElement resetBtn;

	public void lnkFundTransfer() {
		lnkFundTransfer.click();
	}

	public void payersAccountNo(String id) {
		payersAccountNo.sendKeys(id);
	}
	
	public void payeesAccountNo(String id) {
		payeesAccountNo.sendKeys(id);
	}

	public void amount(String id) {
		amount.sendKeys(id);
	}

	public void desc(String desc) {
		description.sendKeys(desc);
	}

	public void submitBtn() {
		submitBtn.click();
	}

	public void resetBtn() {
		resetBtn.click();
	}
}
