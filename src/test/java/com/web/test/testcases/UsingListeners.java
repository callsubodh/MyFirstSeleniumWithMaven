package com.web.test.testcases;

import java.time.Duration;
import com.web.test.utility.Listeners2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.web.test.utility.Listeners2.class)
public class UsingListeners {
	
	public static WebDriver driver;
	
	@Test(priority=1, description="This is to load webdriver")
	public void verifyLogin() {	
		
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		Listeners2.driver = driver;
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("http://www.facebook.com");
		
		Assert.assertEquals(driver.getTitle(), "Facebook - log in or sign up");
		
		
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
