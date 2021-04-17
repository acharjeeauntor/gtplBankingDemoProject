package com.guru99BankingDemo.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99BankingDemo.utilities.Config;

public class ManagerRegistrationPage {
	WebDriver ldriver;

	public ManagerRegistrationPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "here")
	WebElement hereElement;

	@FindBy(name = "emailid")
	WebElement emailElement;

	@FindBy(name = "btnLogin")
	WebElement SubmitBtnElement;

	@FindBy(xpath = "//tbody/tr[4]/td[2]")
	WebElement userIdElement;

	@FindBy(xpath = "//tbody/tr[5]/td[2]")
	WebElement passwordElement;

	public void ManagerRegistration(String email) {
		hereElement.click();
		emailElement.sendKeys(email);
		SubmitBtnElement.submit();
	}

	public void setManagerInfo() throws IOException {
		Config config = new Config();
		config.setManagerInfo(userIdElement.getText(), passwordElement.getText());
	}

}
