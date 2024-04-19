package MyFirstTestNGPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utility.AccessConfig;
import Utility.BrowserFactory;

public class BaseClass {
	
	public WebDriver driver;
	public BrowserFactory bf;
	public AccessConfig ac;
	
	@BeforeTest
	public void setup() {
		
		bf = new BrowserFactory(driver);
		ac = new AccessConfig();		
	}
	
	@AfterTest
	public void tearDown() {
		
		bf.quitBrowser(driver);
	}

}
