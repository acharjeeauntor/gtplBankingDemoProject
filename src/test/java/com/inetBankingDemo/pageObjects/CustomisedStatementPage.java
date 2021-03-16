package com.inetBankingDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomisedStatementPage {
	
		WebDriver ldriver;
			
			public CustomisedStatementPage(WebDriver rdriver) {
				ldriver=rdriver;
				PageFactory.initElements(rdriver, this);
			}
			
			
			@FindBy(xpath="//a[normalize-space()='Customised Statement']")
			WebElement lnkCustomizedStatement;
			
			@FindBy(xpath="//input[@name='accountno']")
			WebElement accountNo;
			
			@FindBy(xpath="//input[@name='amountlowerlimit']")
			WebElement minimumValue;
			
			@FindBy(xpath="//input[@name='numtransaction']")
			WebElement noOfTransaction;
			
			
			@FindBy(xpath="//input[@name='fdate']")
			WebElement fromDate;
			
			@FindBy(xpath="//input[@name='tdate']")
			WebElement toDate;
			
			
			
			@FindBy(xpath="//input[@name='AccSubmit']")
			WebElement submitBtn;
			
			@FindBy(xpath="//input[@name='res']")
			WebElement resetBtn;
			
			public void lnkCustomizedStatement() {
				lnkCustomizedStatement.click();
			}

			public void minimumValue(String val) {
				minimumValue.sendKeys(val);
			}
			
			public void accountNo(String no) {
				accountNo.sendKeys(no);
			}
			public void noOfTransaction(String val) {
				noOfTransaction.sendKeys(val);
			}
			
			public void fromDate(String mm,String dd,String yy) {
				fromDate.sendKeys(mm);
				fromDate.sendKeys(dd);
				fromDate.sendKeys(yy);
			}
			
			public void toDate(String mm,String dd,String yy) {
				toDate.sendKeys(mm);
				toDate.sendKeys(dd);
				toDate.sendKeys(yy);
			}
			
			public void submitBtn() {
				submitBtn.click();
			}
			
			public void resetBtn() {
				resetBtn.click();
			}
}
