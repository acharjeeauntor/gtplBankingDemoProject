package com.guru99BankingDemo.utilities;

import java.io.*;
import java.util.Properties;

public class Config {

	Properties pro;
	File src = new File("./Configuration/config.properties");
	
	public Config() {
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	
	public void setManagerInfo(String id,String pass) throws IOException {
		FileOutputStream out = new FileOutputStream(src);
		pro.setProperty("managerId",id);
		pro.setProperty("managerPass",pass);
		pro.store(out, null);
		out.close();
	}
	
	
	public void setCustomerId(String id) throws IOException {
		FileOutputStream out = new FileOutputStream(src);
		pro.setProperty("customerId",id);
		pro.store(out, null);
		out.close();
	}
	

	public void setAccountId(String id) throws IOException {
		FileOutputStream out = new FileOutputStream(src);
		pro.setProperty("accountId",id);
		pro.store(out, null);
		out.close();
	}
	
	public void setNewManagerPass(String pass) throws IOException {
		FileOutputStream out = new FileOutputStream(src);
		pro.setProperty("managerPass",pass);
		pro.store(out, null);
		out.close();
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
	
	public String getUserId() {
		String id  = pro.getProperty("managerId");
		return id;
	}
	
	public String getPassword() {
		String pass  = pro.getProperty("managerPass");
		return pass;
	}
	
	
	public String getCustomerId() {
		String cId  = pro.getProperty("customerId");
		return cId;
	}
	
	public String getAccountNo() {
		String accountNo  = pro.getProperty("accountId");
		return accountNo;
	}
	
	

}
