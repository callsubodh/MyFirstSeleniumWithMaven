package com.web.test.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JS_ScrollPage {
	
	WebDriver driver;
	
	@Test
		public static void scrollPage(WebDriver driver){
	
	/*public void scrollPage() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.yahoo.com");*/
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("scroll(0,500)");
		
		//Thread.sleep(5000);
		//driver.quit();
		
	}

}
