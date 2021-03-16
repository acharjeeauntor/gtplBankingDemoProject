package com.inetBankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutButton {
	WebDriver ldriver;
	
	public LogoutButton(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement lnkLogOut;
	
	public void lnkLogOut() {
		lnkLogOut.click();
	}
}
