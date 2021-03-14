package com.inetBankingDemo.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditAccountPage {
	WebDriver ldriver;

	public EditAccountPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Edit Account']")
	WebElement lnkEditAccount;

	@FindBy(xpath = "//input[@name='accountno']")
	WebElement accountId;

	@FindBy(xpath = "//select[@name='a_type']")
	WebElement accountType;


	@FindBy(xpath = "//input[@name='AccSubmit']")
	WebElement submitBtn;

	@FindBy(xpath = "//input[@name='res']")
	WebElement resetBtn;
	
	@FindBy(xpath = "//input[@name='AccReset']")
	WebElement accResetBtn;
	
	

	public void lnkEditAccount() {
		lnkEditAccount.click();
	}

	public void accountId(String id) {
		accountId.sendKeys(id);
	}

	public void accountType(String accType) {
		Select se = new Select(accountType);
		se.selectByValue(accType);
	}
	
	public String presentAccountType() {
		Select se = new Select(accountType);
	WebElement option = (WebElement) se.getFirstSelectedOption();
	return option.getText();
	}
	
	public void submitBtn() {
		submitBtn.click();
	}

	public void resetBtn() {
		resetBtn.click();
	}
	
	public void accResetBtn() {
		accResetBtn.click();
	}
}
