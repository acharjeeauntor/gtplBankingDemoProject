package com.guru99BankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {

WebDriver ldriver;
	
	public DeleteCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Delete Customer']")
	WebElement lnkDeleteCustomer;
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement customerId;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@name='res']")
	WebElement resetBtn;
	
	public void lnkDeleteCustomer() {
		lnkDeleteCustomer.click();
	}

	public void cId(String id) {
		customerId.sendKeys(id);
	}
	
	public void submitBtn() {
		submitBtn.click();
	}
	
	public void resetBtn() {
		resetBtn.click();
	}

	
	
	
}
