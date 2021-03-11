package com.inetBankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingDemo.pageObjects.LoginPage;
import com.inetBankingDemo.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{


	@Test(dataProvider="LoginData")
	public void loginDDT(String userId,String pass) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserId(userId);
		logger.info("Entered UserId");
		
		lp.setUserPassword(pass);
		logger.info("Entered Password");
		
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept(); // close alert
			driver.switchTo().defaultContent();
			Assert.fail();
			logger.warn("Login Failed");
		}else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); // close alert
			driver.switchTo().defaultContent();
		}
	}
	
	
	
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		
		String path = "./src/test/java/com/inetBankingDemo/testData/LoginData.xlsx";
		int rowNum = XLUtils.getRowCount(path, "sheet1");
		int colNum = XLUtils.getCellCount(path, "sheet1", 1);
		
		
		String logindata[][] = new String[rowNum][colNum];
		
		for(int i =1;i<=rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		
		return logindata;
		
		
	}
	
}
	
	
