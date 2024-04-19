package com.web.test.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.annotations.Test;

public class JS_Send_Click {
	
	public WebDriver driver;
	
	@Test
	public void verify() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://login.yahoo.com/");		
		
		WebElement username = driver.findElement(By.id("login-username"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=arguments[1]", username, "callsub@gmail.com");
		
		WebElement check = driver.findElement(By.name("persistent"));
		js.executeScript("arguments[0].click()", check);
		Thread.sleep(2000);
		
		js.executeScript("document.getElementById('persistent').click()");
		
		js.executeScript("alert('this is checked again now.')");
	}

}
