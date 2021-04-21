package com.guru99BankingDemo.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99BankingDemo.utilities.Config;

public class CustomisedStatementPage {

	AccountOptionsPage objAccountOptions;
	Config config = new Config();

	WebDriver ldriver;

	public CustomisedStatementPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountno")
	WebElement accountnoElement;

	@FindBy(name = "fdate")
	WebElement fromDateElement;

	@FindBy(name = "tdate")
	WebElement toDateElement;

	@FindBy(name = "amountlowerlimit")
	WebElement minimumTransactionValueElement;

	@FindBy(name = "numtransaction")
	WebElement numberOfTransactionElement;

	@FindBy(name = "AccSubmit")
	WebElement submitBtnElement;

	@FindBy(name = "res")
	WebElement resetBtnElement;

	public void submitCustomizedStatementForm(String accountNo, String fromDateMonth,String fromDateDay, 
			String fromDateYear,String toDateMonth,String toDateDay,  String toDateYear, String miniTrans, String noTrans)
			throws InterruptedException, IOException {

		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.customisedStatementOption();

		if (accountNo.isEmpty() && miniTrans.isEmpty() && noTrans.isEmpty()) {
			submitBtnElement.click();
		} else {
			accountnoElement.sendKeys(accountNo);
			fromDateElement.sendKeys(fromDateDay);
			fromDateElement.sendKeys(fromDateMonth);
			fromDateElement.sendKeys(fromDateYear);
			toDateElement.sendKeys(toDateDay);
			toDateElement.sendKeys(toDateMonth);
			toDateElement.sendKeys(toDateYear);
			minimumTransactionValueElement.sendKeys(miniTrans);
			numberOfTransactionElement.sendKeys(noTrans);
			submitBtnElement.click();
		}

	}

	public void resetCustomizedStatementForm(String accountNo, String fromDateMonth,String fromDateDay, 
			String fromDateYear,String toDateMonth,String toDateDay,  String toDateYear, String miniTrans, String noTrans)
			throws InterruptedException, IOException {

		objAccountOptions = new AccountOptionsPage(ldriver);
		objAccountOptions.customisedStatementOption();

		accountnoElement.sendKeys(accountNo);
		fromDateElement.sendKeys(fromDateDay);
		fromDateElement.sendKeys(fromDateMonth);
		fromDateElement.sendKeys(fromDateYear);
		toDateElement.sendKeys(toDateDay);
		toDateElement.sendKeys(toDateMonth);
		toDateElement.sendKeys(toDateYear);
		minimumTransactionValueElement.sendKeys(miniTrans);
		numberOfTransactionElement.sendKeys(noTrans);
		resetBtnElement.click();

	}

	public boolean isAccountNoEmpty() {
		return accountnoElement.getText().isEmpty();
	}

}
