package com.web.test.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	BufferedReader br;
	BufferedWriter bw;
	String propFilePath = System.getProperty("user.dir")+"\\Configuration\\config.properties";

	static Properties prop;

	public PropertiesReader(){

		try {
			if(propFilePath.contains(".properties")) {
			br = new BufferedReader(new FileReader(propFilePath));			
			prop = new Properties();
			prop.load(br);
			}else
				System.out.println("No properties file was found...");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getPropertiesData(String searchProp) {
		String propData=prop.getProperty(searchProp);
		if(propData==null || propData.isBlank()||propData.isEmpty()) {
			propData = "Invalid property";
		}
		else {
			propData=prop.getProperty(searchProp);
		}
		System.out.println("Property Data is: "+propData);
		return propData;
	}

	public String getBrowserVal() {
		String browser_val = prop.getProperty("browser");
		//		System.out.println(browser_val);	
		return browser_val;
	}

	public String getEmailAddress() {
		System.out.println(prop.getProperty("email"));
		return prop.getProperty("email");
	}

	public String getPassword() {

		return prop.getProperty("password");
	}

	public String getAppURL() {
		System.out.println(prop.getProperty("gurl"));
		return prop.getProperty("gurl");
	}

	public static void main(String[] args) {
		PropertiesReader pr = new PropertiesReader();
		pr.getEmailAddress();
		pr.getAppURL();
		pr.getPropertiesData("myname");
	}

}
