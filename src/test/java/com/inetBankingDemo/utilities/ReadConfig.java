package com.inetBankingDemo.utilities;

import java.io.*;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getHomePagetitle() {
		String title  = pro.getProperty("homePageTitle");
		return title;
	}
	
	public String getChromePath() {
		String chromePath  = pro.getProperty("chromepath");
		return chromePath;
	}
	
	public String getFirefoxPath() {
		String firefoxPath  = pro.getProperty("firefoxpath");
		return firefoxPath;
	}
	
	public String getIePath() {
		String iePath  = pro.getProperty("iepath");
		return iePath;
	}
	
	public String getExcelPath() {
		String excelpath  = pro.getProperty("excelPath");
		return excelpath;
	}

}
