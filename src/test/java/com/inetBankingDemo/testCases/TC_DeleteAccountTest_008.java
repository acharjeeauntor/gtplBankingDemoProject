package com.inetBankingDemo.testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBankingDemo.pageObjects.DeleteAccountPage;
import com.inetBankingDemo.pageObjects.LoginPage;
import com.inetBankingDemo.utilities.XLUtils;

public class TC_DeleteAccountTest_008 extends BaseClass{
	
	
	@Test(priority=1)
	public void deleteAccount() throws InterruptedException, IOException {
		String accountId = XLUtils.getCellData(excelPath, "sheet1", 10, 0);
		DeleteAccountPage dacc = new DeleteAccountPage(driver);
		loginToTheApplication();
		dacc.lnkDeleteAccount();
		Thread.sleep(2000);
		
		logger.info("Account no. verification start......");
		
		dacc.accountNo(accountId);
		dacc.submitBtn();
		
		logger.info("Alert For Confirming Delete Account");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		if(driver.switchTo().alert().getText().equals("Account does not exist")){
			logger.warn("Delete Account test Failed...");
			driver.switchTo().alert().accept();
			// Alert Box Shoho Screentshoot neya jay na .So Alert accept korar por Screenshot nite hbe.
			//captureScreen(driver, "deleteCustomer");
			Assert.fail();
		}else if(driver.switchTo().alert().getText().equals("Account Deleted Sucessfully")) {
			logger.info("Delete Account test Passed...");
			Assert.assertTrue(true);
			driver.switchTo().alert().accept();
		}
		
	}
}
