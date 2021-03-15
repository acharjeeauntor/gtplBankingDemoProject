package com.inetBankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WithdrawalPage {
	WebDriver ldriver;

	public WithdrawalPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Withdrawal']")
	WebElement lnkWithdrawal;

	@FindBy(xpath = "//input[@name='accountno']")
	WebElement accountNo;

	@FindBy(xpath = "//input[@name='ammount']")
	WebElement amount;

	@FindBy(xpath = "//input[@name='desc']")
	WebElement description;

	@FindBy(xpath = "//input[@name='AccSubmit']")
	WebElement submitBtn;

	@FindBy(xpath = "//input[@name='res']")
	WebElement resetBtn;

	public void lnkWithdrawal() {
		lnkWithdrawal.click();
	}

	public void accountNo(String id) {
		accountNo.sendKeys(id);
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
