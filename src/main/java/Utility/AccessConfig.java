package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class AccessConfig {
	
	private Properties prop;
	private String filepath= System.getProperty("user.dir")+"/Configuration/config.properties";
	
	public AccessConfig() {
	try {
		File f = new File(filepath);
		FileInputStream fis = new FileInputStream(f);
		
		prop = new Properties();
		prop.load(fis);	
		//System.out.println("Property value is: "+prop.getProperty("URL"));
		
	}catch(Exception e) {
		e.getMessage();
	}
	
	}
	
	public String getConfigDataURL() {
		
		String url = prop.getProperty("URL");		
		return url;
	}
	
	public String getChromeDriverPath() {
		
		return prop.getProperty("ChromeDriverPath");
	}
	
	public String getFirefoxDriverPath() {
		
		return prop.getProperty("FirefoxDriverPath");
	}
}
