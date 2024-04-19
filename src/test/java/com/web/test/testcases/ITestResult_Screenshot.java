package com.web.test.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.web.test.utility.CaptureScreenshot;

public class ITestResult_Screenshot {
	
	
	static WebDriver driver;
	
	@Test(priority=1)
	public void captureScreenshot() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("http://www.facebook.com");
		
		String strTitle = driver.getTitle();
		
		Reporter.log("Page title is: "+strTitle, true);
		
		Assert.assertEquals(strTitle.contains("Facebook"), "Facebook");
			
		}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			
			Reporter.log("Screenshot taken for success", true);
			Reporter.log("GetName value is: "+ result.getName(), true);			
			
		}else if(result.getStatus() == ITestResult.FAILURE){
			
			Reporter.log("Screenshot taken for failure", true);
			Reporter.log("GetName value is: "+ result.getName(), true);
			
		
	}
		CaptureScreenshot.captureScreen(driver, "Facebookscreen");	
		driver.quit();
}
}