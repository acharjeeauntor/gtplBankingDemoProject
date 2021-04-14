package com.guru99BankingDemo.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

import com.guru99BankingDemo.pageObjects.LoginPage;
import com.guru99BankingDemo.utilities.ReadConfig;
import com.guru99BankingDemo.utilities.XLUtils;

public class BaseClass {

	public ReadConfig readConfig = new ReadConfig();
	public String homePageTitle = readConfig.getHomePagetitle();
	public String baseUrl = readConfig.getBaseUrl();

	
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) throws IOException {
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();

		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readConfig.getIePath());
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		logger.info("URL is opened");

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
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	public static void loginToTheApplication() throws InterruptedException, IOException {
//		String userId = XLUtils.getCellData(excelPath, "sheet1", 1, 0);
//		String password = XLUtils.getCellData(excelPath, "sheet1", 1, 1);
//		LoginPage lp = new LoginPage(driver);
//		lp.setUserId(userId);
//		logger.info("Entered UserId");
//		lp.setUserPassword(password);
//		logger.info("Entered Password");
//		lp.clickLogin();
//		logger.info("Clicked on Login Button");
//		Thread.sleep(2000);

	}
	
	

}
