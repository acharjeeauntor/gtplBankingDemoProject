package com.guru99BankingDemo.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99BankingDemo.utilities.ReadConfig;

public class ManagerRegistrationPage {
WebDriver ldriver;
	
	public ManagerRegistrationPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(linkText="here")
	WebElement here;
	
	@FindBy(name="emailid")
	WebElement email;
	
	@FindBy(name="btnLogin")
	WebElement submitBtn;
	
	@FindBy(xpath="//tbody/tr[4]/td[2]")
	WebElement userId;
	
	@FindBy(xpath="//tbody/tr[5]/td[2]")
	WebElement pass;
	
	
	public void ManagerRegistration(String e) {
		here.click();
		email.sendKeys(e);
		submitBtn.submit();
	}
	
	
	public void setManagerInfo() throws IOException {
		ReadConfig rc = new ReadConfig();
		rc.writeManagerInfo(userId.getText(), pass.getText());
	}
	
	
}
