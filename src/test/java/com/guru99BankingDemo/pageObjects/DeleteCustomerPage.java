package com.guru99BankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	AccountOptionsPage objAccountOptions;

	WebDriver ldriver;

	public DeleteCustomerPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "cusid")
	WebElement customerIdElement;

	@FindBy(name = "AccSubmit")
	WebElement submitBtnElement;

	@FindBy(name = "res")
	WebElement resetBtnElement;

	

	public void deleteCustomer(String uId) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.deleteCustomerOption();
		
		customerIdElement.sendKeys(uId);
		submitBtnElement.click();
	}
	
	public void resetCustomer(String uId) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.deleteCustomerOption();
		
		customerIdElement.sendKeys(uId);
		resetBtnElement.click();
	}
	
	public boolean isCustomerIdFieldEmpty() {
	return customerIdElement.getText().isEmpty();
	}
	
	
}
