package com.guru99BankingDemo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99BankingDemo.pageObjects.AccountOptionsPage;
import com.guru99BankingDemo.pageObjects.ManagerLoginPage;
import com.guru99BankingDemo.pageObjects.ManagerRegistrationPage;
import com.guru99BankingDemo.utilities.XLUtils;

public class ManagerModuleTest extends BaseClass {
	
	ManagerRegistrationPage objManagerRegistration;
	ManagerLoginPage objManagerLogin;
	AccountOptionsPage objAccountOptions;

	@Test(priority = 1,enabled=false,dataProvider="RegistrationManagerData",description="Registration Manager using Valid and Invalid Data")
	public void doManagerRegistration(String email) throws IOException {
		objManagerRegistration = new ManagerRegistrationPage(driver);
		driver.get(baseUrl);
		objManagerRegistration.ManagerRegistration(email);
		if(driver.getPageSource().contains("Access details to demo site.")) {
			objManagerRegistration.setManagerInfo();
			Assert.assertTrue(true);
			System.out.println("pass");
		}else {
			System.out.println("fail");
			captureScreen(driver,"doManagerRegistration");
			Assert.fail();
		}
	}
	
	
	@Test(priority = 2,enabled=false,dataProvider="LoginManagerData",description="Login Manager Account using Valid and Invalid Data")
	public void doManagerLogin(String uId,String pass) throws IOException {
		objManagerLogin = new ManagerLoginPage(driver);
		driver.get(baseUrl);
		objManagerLogin.ManagerLogin(uId, pass);
		if(driver.getPageSource().contains("Welcome To Manager's Page of Guru99 Bank")) {
			Assert.assertTrue(true);
			System.out.println("pass");
		}else {
			System.out.println("fail");
			captureScreen(driver,"doManagerLogin");
			
			Assert.fail();
			
			
		}
	}
	
	
	@Test(priority = 3,description="Logout from Manager Account")
	public void doManagerLogout() throws IOException, InterruptedException {
		objAccountOptions = new AccountOptionsPage(driver);
		loginToTheApplication();
		Thread.sleep(2000);
		objAccountOptions.ManagerLogoutOption();
		if(driver.switchTo().alert().getText().contains("You Have Succesfully Logged Out!!")) {
			Assert.assertTrue(true);
			driver.switchTo().alert().accept();
		}else {
			Assert.fail();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@DataProvider(name="RegistrationManagerData")
	String [][] getRegistrationManagerData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/guru99BankingDemo/testData/Data.xlsx";
		
		int rowNum=XLUtils.getRowCount(path, "ManagerRegistrationData");
		int colCount=XLUtils.getCellCount(path,"ManagerRegistrationData",1);
		String registrationData[][]=new String[rowNum][colCount];
		
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				registrationData[i-1][j]=XLUtils.getCellData(path,"ManagerRegistrationData", i,j);
			}
				
		}
	return registrationData;
	}
	
	
	
	@DataProvider(name="LoginManagerData")
	String [][] getLoginManagerData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/guru99BankingDemo/testData/Data.xlsx";
		
		int rowNum=XLUtils.getRowCount(path, "ManagerLoginData");
		int colCount=XLUtils.getCellCount(path,"ManagerLoginData",1);
		String loginData[][]=new String[rowNum][colCount];
		
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path,"ManagerLoginData", i,j);
			}
				
		}
	return loginData;
	}
	
	

}
