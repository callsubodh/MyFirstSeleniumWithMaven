package com.web.test.testcases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyPress {
	
	WebDriver driver;
	
	@Test
	public void multipleWindows() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://login.yahoo.com/account/create");
		
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("Fname");
		
		Actions act = new Actions(driver);
				
		act.sendKeys(Keys.TAB)
			.pause(Duration.ofSeconds(1))
			.sendKeys("Lname")
			.pause(Duration.ofSeconds(1))
			.sendKeys(Keys.TAB)
			.build().perform();
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
