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

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {
	
	WebDriver driver;
	
	@Test
	public void mouseHoverMethod() throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-perform-mouse-hover-in-selenium.html");
		
		WebElement ele = driver.findElement(By.xpath("//button[@class='dropbtn']"));
		
		Actions act = new Actions(driver);
				
		act.moveToElement(ele).perform();
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
