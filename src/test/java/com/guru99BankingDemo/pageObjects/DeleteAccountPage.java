package com.guru99BankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage {
WebDriver ldriver;
	
	public DeleteAccountPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Delete Account']")
	WebElement lnkDeleteAccount;
	
	@FindBy(xpath="//input[@name='accountno']")
	WebElement accountNo;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@name='res']")
	WebElement resetBtn;
	
	public void lnkDeleteAccount() {
		lnkDeleteAccount.click();
	}

	public void accountNo(String no) {
		accountNo.sendKeys(no);
	}
	
	public void submitBtn() {
		submitBtn.click();
	}
	
	public void resetBtn() {
		resetBtn.click();
	}
}
