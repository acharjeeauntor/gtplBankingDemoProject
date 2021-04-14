package com.guru99BankingDemo.utilities;

import java.io.*;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	File src = new File("./Configuration/config.properties");
	
	public ReadConfig() {
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	
	public void writeManagerInfo(String id,String pass) throws IOException {
		FileOutputStream out = new FileOutputStream(src);
		pro.setProperty("managerId",id);
		pro.setProperty("managerPass",pass);
		pro.store(out, null);
		out.close();
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
	
	public String getBaseUrl() {
		String url  = pro.getProperty("baseUrl");
		return url;
	}

}
