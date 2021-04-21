package com.guru99BankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99BankingDemo.testCases.BaseClass;

public class EditCustomerPage extends BaseClass {
	AccountOptionsPage objAccountOptions;

	WebDriver ldriver;

	public EditCustomerPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "cusid")
	WebElement customerIdElement;

	@FindBy(name = "AccSubmit")
	WebElement idFormSubmitBtnElement;

	@FindBy(name = "res")
	WebElement idFormResetBtnElement;

	@FindBy(name = "name")
	WebElement nameElement;

	@FindBy(name = "dob")
	WebElement dobElement;

	@FindBy(name = "gender")
	WebElement genderElement;

	@FindBy(name = "addr")
	WebElement addressElement;

	@FindBy(name = "city")
	WebElement cityElement;

	@FindBy(name = "state")
	WebElement stateElement;

	@FindBy(name = "pinno")
	WebElement pinElement;

	@FindBy(name = "telephoneno")
	WebElement mobileNumberElement;

	@FindBy(name = "emailid")
	WebElement emailElement;

	@FindBy(name = "sub")
	WebElement submitBtnElement;

	@FindBy(name = "res")
	WebElement resetBtnElement;

	public void editCustomer(String uId) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.editCustomerOption();

		if(uId.isEmpty()) {
			idFormSubmitBtnElement.click();
		}else {
			customerIdElement.sendKeys(uId);
			idFormSubmitBtnElement.click();
		}
		
	}

	public void resetCustomer(String uId) {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.editCustomerOption();

		customerIdElement.sendKeys(uId);
		idFormResetBtnElement.click();
	}

	public boolean isCustomerIdFieldEmpty() {
		return customerIdElement.getText().isEmpty();
	}

	public boolean isNameGenderBithDateEditable() throws InterruptedException {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.editCustomerOption();
		customerIdElement.sendKeys(customerId);
		idFormSubmitBtnElement.click();
		Thread.sleep(2000);

		if (nameElement.isEnabled() || genderElement.isEnabled() || dobElement.isEnabled()) {
			return true;
		} else {
			return false;
		}

	}

	public void editCustomerData(String address, String city, String state, String pin, String mobile, String email)
			throws InterruptedException {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.editCustomerOption();
		customerIdElement.sendKeys(customerId);
		idFormSubmitBtnElement.click();
		Thread.sleep(2000);

		if(address.isEmpty()&&city.isEmpty()&&state.isEmpty()&&pin.isEmpty()&&mobile.isEmpty()&&email.isEmpty()) {
			submitBtnElement.click();
		}else {
			addressElement.clear();
			addressElement.sendKeys(address);
			cityElement.clear();
			cityElement.sendKeys(city);
			stateElement.clear();
			stateElement.sendKeys(state);
			pinElement.clear();
			pinElement.sendKeys(pin);
			mobileNumberElement.clear();
			mobileNumberElement.sendKeys(mobile);
			emailElement.clear();
			emailElement.sendKeys(email);
			submitBtnElement.click();
		}

	}

	public void resetCustomerData(String address, String city, String state, String pin, String mobile, String email)
			throws InterruptedException {
		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.editCustomerOption();
		customerIdElement.sendKeys(customerId);
		idFormSubmitBtnElement.click();
		Thread.sleep(2000);

		addressElement.clear();
		addressElement.sendKeys(address);
		cityElement.clear();
		cityElement.sendKeys(city);
		stateElement.clear();
		stateElement.sendKeys(state);
		pinElement.clear();
		pinElement.sendKeys(pin);
		mobileNumberElement.clear();
		mobileNumberElement.sendKeys(mobile);
		emailElement.clear();
		emailElement.sendKeys(email);
		resetBtnElement.click();

	}

}
