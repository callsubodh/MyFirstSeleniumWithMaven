package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class AccessFiles {
	
	private Properties prop;
	//private XSSFWorkBook wb;
	private String filepath="./Configuration/config.properties";
	
	public AccessFiles() {
	try {
		File f = new File(filepath);
		FileInputStream fis = new FileInputStream(f);
		if(filepath.contains(".properties")){
		prop = new Properties();
		prop.load(fis);	
		//System.out.println("Property value is: "+prop.getProperty("URL"));
		}
		else if(filepath.contains(".csv") || filepath.contains(".xlsx")) {
			
			
			
		}
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
