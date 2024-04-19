package com.web.test.testcases;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleWindows {
	
	WebDriver driver;
	
	@Test
	public void multipleWindows() {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.naukri.com");
		
		String parent = driver.getWindowHandle();
		
		System.out.println("Parent window is "+parent);
		
		
		
		Set<String> allWindows = driver.getWindowHandles();
		
		System.out.println("Child window is "+allWindows.size());
		
		
	}

}
