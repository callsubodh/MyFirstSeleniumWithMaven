package com.web.test.utility;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory{

	public static WebDriver driver;	

	public static WebDriver startApp(String browser, String appURL) {

		if(browser.equalsIgnoreCase("Chrome")) {

			ChromeOptions options = new ChromeOptions();

			/*By default, ChromeDriver configures Chrome to allow pop-up windows. If you want to block pop-ups 
			(i.e., restore the normal Chrome behavior when it is not controlled by ChromeDriver), do the following:*/
			//options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation","--remote-allow-origins=*"));
			List<String> optArgs = Arrays.asList("disable-popup-blocking", "enable-automation","--remote-allow-origins=*");
			options.addArguments(optArgs);
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver(options);
			
		}
		else if(browser.equalsIgnoreCase("Firefox")) {	
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();			
		}
		else if(browser.equalsIgnoreCase("Edge")) {		
		}
		else if(browser.equalsIgnoreCase("IE")) {		
		}
		else {	
			System.out.println("This browser is not supported.");	
		}	
		//Initiate the driver variable in Listeners2 class for CaptureScreenshot method
		Listeners2.driver = driver;	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get(appURL);
		System.out.println("===============App Url is: "+appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		return driver;		
	}	
	public static void quitBrowser(WebDriver driver) {		
		driver.quit();
	}	
}
