package com.web.test.testcases;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class ChromeOptionsDemo {
	
	WebDriver driver;
	
	@Test
	public void loadChromeOptions() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.acceptInsecureCerts();
		
		ChromeOptions options = new ChromeOptions();
		//Add extensions
		options.addExtensions(new File("C:\\Users\\Subodh\\Downloads\\extension_7_2_3_0.crx"));
		//options.setAcceptInsecureCerts(true);
		
		//Disables the automation infobar that gets populated when a browser is opened by an automation script
		//options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		
		//we can enter multiple parameters below w.r.to only one in the above list
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation","disable-popup-blocking"));
		
		//Add multiple arguments to the browser at once
		options.addArguments("--start-in-incognito","--start-maximized","--disable-web-security",
				   "--ignore-certificate-errors","--allow-running-insecure-content",
				   "--allow-insecure-localhost","--no-sandbox","--disable-gpu");
		//Add the below parameter to execute the script without opening the browser i.e. execution will happen in the backend
		 //"--headless"
		
		//Add desired capabilities to Chrome options
		options.merge(cap);
		
		driver = new ChromeDriver(options);
		
		driver.get("http://www.facebook.com");	
		
		//System.out.println("================"+driver.getWindowHandles().size());
		Set<String> winhan = driver.getWindowHandles();
		for(String winhanName: winhan) {
			
			driver.switchTo().window(winhanName);
			String str = driver.getTitle();
			
			if(!str.contains("Facebook")) {
				System.out.println("Title of the page is: "+driver.getTitle());
				driver.close();
				//continue;
				break;
			}			
		}		
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
