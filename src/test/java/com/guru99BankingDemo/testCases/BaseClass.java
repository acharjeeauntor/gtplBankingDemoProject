package com.guru99BankingDemo.testCases;

import java.io.File;
import java.io.IOException;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.guru99BankingDemo.pageObjects.ManagerLoginPage;
import com.guru99BankingDemo.utilities.Config;

public class BaseClass {

	public static Config config = new Config();
	public static String baseUrl = config.getBaseUrl();
	public static String userId = config.getUserId();
	public static String password = config.getPassword();
	public static String customerId = config.getCustomerId();
	public static String accountId = config.getAccountNo();
	
	
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void appSetUp(String br) throws IOException {
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
			driver = new ChromeDriver();

		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().operatingSystem(OperatingSystem.LINUX).setup();
			driver = new FirefoxDriver();
		}else if(br.equals("ie")) {
			WebDriverManager.iedriver().operatingSystem(OperatingSystem.LINUX).setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
		
		
	}
	
	
	public boolean isAlertPresent() { // method to check alert is present or not
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(4);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(6);
		return (generatedString2);
	}
	
	
	public static void loginToTheApplication() throws InterruptedException, IOException {
		ManagerLoginPage objManagerLogin = new ManagerLoginPage(driver);
		driver.get(baseUrl);
		objManagerLogin.ManagerLogin                                                                                                                                        (userId, password);

	}
	
	

}
