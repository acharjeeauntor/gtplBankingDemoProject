package com.guru99BankingDemo.pageObjects;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99BankingDemo.utilities.Config;

public class NewCustomerPage {
	
	AccountOptionsPage objAccountOptions;
	Config config = new Config();
	
	WebDriver ldriver;
	

	public NewCustomerPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="name")
	WebElement customerNameElement;
	
	@FindBy(xpath="//input[@name='rad1'][@value='m']")
	WebElement genderMaleElement;
	
	@FindBy(xpath="//input[@name='rad1'][@value='f']")
	WebElement genderFemaleElement;
	
	@FindBy(id="dob")
	WebElement dateOfBirthElement;
	
	@FindBy(name="addr")
	WebElement addressElement;
	
	@FindBy(name="city")
	WebElement cityElement;
	
	@FindBy(name="state")
	WebElement stateElement;
	
	@FindBy(name="pinno")
	WebElement pinElement;
	
	@FindBy(name="telephoneno")
	WebElement mobileNumberElement;
	
	@FindBy(name="emailid")
	WebElement emailElement;
	
	@FindBy(name="password")
	WebElement passwordElement;
	
	@FindBy(name="sub")
	WebElement submitBtnElement;
	
	@FindBy(name="res")
	WebElement resetBtnElement;
	
	@FindBy(xpath="//tbody/tr[4]/td[2]")
	WebElement getCustomerIdElement;
	
	
	public void submitNewCustomerData(String name,String gender,String month,String day,String year,String address,
			String city,String state,String pin,String mobile,String email,String password) throws InterruptedException, IOException {
		
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.newCustomerOption();
		
		
		customerNameElement.sendKeys(name);
		if(gender.equals("male")) {
			genderMaleElement.click();
		}else {
			genderFemaleElement.click();
		}
		dateOfBirthElement.sendKeys(month);
		dateOfBirthElement.sendKeys(day);
		dateOfBirthElement.sendKeys(year);
		addressElement.sendKeys(address);
		cityElement.sendKeys(city);
		stateElement.sendKeys(state);
		pinElement.sendKeys(pin);
		mobileNumberElement.sendKeys(mobile);
		emailElement.sendKeys(email);
		passwordElement.sendKeys(password);
		submitBtnElement.click();
		Thread.sleep(2000);
	}
	
	public void resetNewCustomerData(String name,String gender,String month,String day,String year,String address,
			String city,String state,String pin,String mobile,String email,String password) {
		
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.newCustomerOption();
		
		customerNameElement.sendKeys(name);
		if(gender.equals("male")) {
			genderMaleElement.click();
		}else {
			genderFemaleElement.click();
		}
		dateOfBirthElement.sendKeys(month);
		dateOfBirthElement.sendKeys(day);
		dateOfBirthElement.sendKeys(year);
		addressElement.sendKeys(address);
		cityElement.sendKeys(city);
		stateElement.sendKeys(state);
		pinElement.sendKeys(pin);
		mobileNumberElement.sendKeys(mobile);
		emailElement.sendKeys(email);
		passwordElement.sendKeys(password);
		resetBtnElement.click();
	}
	
	
	public boolean isCustomerNameEmpty() {
		return customerNameElement.getText().isEmpty();
	}
	
	
	
	
	
	
	
	
	
	
}
