package com.web.test.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Config {
	
	Properties prop;

	public Config() {
		
		String src = System.getProperty("user.dir")+"\\Configuration\\config.properties";
		System.out.println(src);
		File f = new File(src);
		FileInputStream fis;
		try {
			fis = new FileInputStream(f);
		
		prop = new Properties();
		prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		String appURL = prop.getProperty("URL");
		System.out.println("Application in config mtd URL is: "+appURL);
		
	}
	
	public String getURL() {
		
		String appURL = prop.getProperty("URL");
		System.out.println("Application URL is: "+appURL);
		
		return appURL;
	}
	
	public String getChromePath() {
		
		return prop.getProperty("ChromeDriverPath");
	}
	
	public String getFirefoxPath() {
		
		return prop.getProperty("FirefoxDriverPath");
	}

}
