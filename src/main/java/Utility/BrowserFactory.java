package Utility;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.support.PageFactory;

public class BrowserFactory {
	
	public WebDriver driver;
	
	public BrowserFactory(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver startApplication(String browserName, String appURL) {
		
		AccessConfig acg = new AccessConfig();
		WebDriver driver = null;
		
		if(browserName.equalsIgnoreCase("edge")){
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", acg.getFirefoxDriverPath());
			System.out.println("Using FF");
			driver = new FirefoxDriver();			
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", acg.getChromeDriverPath());
			System.out.println("Using Chrome");
			driver = new ChromeDriver(chromeSession());
		}
		
		//driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//driver.quit();
		return driver;
	}
	
	public void quitBrowser(WebDriver driver) {
		
		if (driver != null) {
	        TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
	        driver.quit();
	    }
	}
	
	public ChromeOptions chromeSession() {
		
		ChromeOptions chopt = new ChromeOptions();
		chopt.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		
		return chopt;
	}

}
