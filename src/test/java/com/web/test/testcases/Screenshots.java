package com.web.test.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.web.test.utility.BrowserFactory;
import com.web.test.utility.CurrentDateFormat;

public class Screenshots {
	
	WebDriver driver;
	
	@Test
	public void captureScreenshot() throws Exception {
		
		/*System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("http://www.facebook.com");*/
		
		driver = BrowserFactory.startApp("chrome", "http://www.facebook.com");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);	

//		System.out.println("./Screenshots/"+this.getClass()+"_"+Thread.currentThread().getStackTrace()[1].getMethodName()+"_"+CurrentDateFormat.getDate()+".png");
		
		FileUtils.copyFile(src, new File("./Screenshots/"+this.getClass()+"_"+Thread.currentThread().getStackTrace()[1].getMethodName()+"_"+CurrentDateFormat.getDate()+".png"));
		
		//Thread.sleep(3000);
		
		driver.quit();

		
	}

}
