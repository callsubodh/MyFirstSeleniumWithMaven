package com.web.test.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReaderByEnv {

	BufferedReader br;
	BufferedWriter bw;
	String env=System.getenv("env_values");
	String propFilePath = System.getProperty("user.dir")+"\\Configuration\\"+env+"config.properties";

	static Properties prop;

	public PropertiesReaderByEnv(){

		try {
			System.out.println("Env value from batch file is: "+env);

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
		PropertiesReaderByEnv pr = new PropertiesReaderByEnv();
		pr.getEmailAddress();
		pr.getAppURL();
		pr.getPropertiesData("env_name");
	}

}
