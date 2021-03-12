package com.inetBankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

WebDriver ldriver;
	
	public EditCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Edit Customer']")
	WebElement lnkEditCustomer;
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement customerId;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement pin;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement mobileNo;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement editSubmitBtn;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@name='res']")
	WebElement resetBtn;


	
	
	
	public void lnkEditCustomer() {
		lnkEditCustomer.click();
	}

	public void cId(String id) {
		customerId.sendKeys(id);
	}

	public void address(String add) {
		address.clear();
		address.sendKeys(add);
	}
	
	public void city(String cty) {
		city.clear();
		city.sendKeys(cty);
	}
	public void state(String sta) {
		state.clear();
		state.sendKeys(sta);
	}
	public void pin(String pn) {
		pin.clear();
		pin.sendKeys(pn);
	}
	public void mobileNo(String number) {
		mobileNo.clear();
		mobileNo.sendKeys(number);
	}
	
	public void email(String mail) {
		email.clear();
		email.sendKeys(mail);
	}

	public void submitBtn() {
		submitBtn.click();
	}
	
	public void editSubmitBtn() {
		editSubmitBtn.click();
	}
	
	public void resetBtn() {
		resetBtn.click();
	}
	
	
}
