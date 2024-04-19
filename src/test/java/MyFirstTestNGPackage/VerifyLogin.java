package MyFirstTestNGPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.AccessConfig;
import Utility.BrowserFactory;

@Test
public class VerifyLogin extends BaseClass{

	//*****COMMENTS - Always extend BaseClass as Before and After Methods can be reused
	/*public WebDriver driver;
	public BrowserFactory bf;
	public AccessConfig ac;
	
	@BeforeTest
	public void setup() {
		
		bf = new BrowserFactory();
		ac = new AccessConfig();		
	}*/
	
	@Test
	public void login() throws InterruptedException {
		
		
		driver = bf.startApplication("chrome", ac.getConfigDataURL());
		
	}

}
