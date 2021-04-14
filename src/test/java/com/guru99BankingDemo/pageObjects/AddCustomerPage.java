package com.guru99BankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='New Customer']")
	WebElement lnkAddNewCustomer;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement CName;
	
	@FindBy(xpath="//input[@value='m']")
	WebElement gender;
	
	@FindBy(xpath="//input[@id='dob']")
	WebElement dateOfBirth;
	
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
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@name='res']")
	WebElement resetBtn;
	
	
	
	public void lnkAddNewCustomer() {
		lnkAddNewCustomer.click();
	}

	public void CName(String name) {
		CName.sendKeys(name);
	}

	public void gender() {
		gender.click();
	}

	public void dateOfBirth(String mm,String dd,String yy) {
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(yy);
	}
	public void address(String add) {
		address.sendKeys(add);
	}
	
	public void city(String cty) {
		city.sendKeys(cty);
	}
	public void state(String sta) {
		state.sendKeys(sta);
	}
	public void pin(String pn) {
		pin.sendKeys(pn);
	}
	public void mobileNo(String number) {
		mobileNo.sendKeys(number);
	}
	
	public void email(String mail) {
		email.sendKeys(mail);
	}
	public void password(String pass) {
		password.sendKeys(pass);
	}
	public void submitBtn() {
		submitBtn.click();
	}
	public void resetBtn() {
		resetBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
