package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.DeleteCustomerPage;
import com.inetBankingDemo.pageObjects.LoginPage;
import com.inetBankingDemo.utilities.XLUtils;

public class TC_DeleteCustomerTest_005 extends BaseClass {

	@Test(priority = 1)
	public void deleteCustomer() throws InterruptedException, IOException {
		String customerId = XLUtils.getCellData(excelPath, "sheet1", 6, 0);

		loginToTheApplication();
		DeleteCustomerPage dc = new DeleteCustomerPage(driver);

		dc.lnkDeleteCustomer();
		Thread.sleep(2000);

		logger.info("Customer Id verification start......");

		dc.cId(customerId);
		dc.submitBtn();

		logger.info("Alert For Confirming Delete customer");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (driver.switchTo().alert().getText().equals("Customer does not exist!!")) {
			logger.warn("Delete Customer test Failed...");
			driver.switchTo().alert().accept();
			// Alert Box Shoho Screentshoot neya jay na .So Alert accept korar por
			// Screenshot nite hbe.
			captureScreen(driver, "deleteCustomer");
			Assert.fail();
		} else if (driver.switchTo().alert().getText().equals("Customer deleted Successfully")) {
			logger.info("Delete Customer test Passed...");
			Assert.assertTrue(true);
			driver.switchTo().alert().accept();
		}

	}

}
