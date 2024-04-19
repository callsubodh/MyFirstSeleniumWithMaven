package com.web.test.testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.web.test.utility.Highlight_Fields;

public class JS_Highlight_Fields {
	
public WebDriver driver;
	
	@Test
	public void getBrokenLinks() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); -- deprecated
		
		//Below is the new way to add timeouts
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		driver.get("https://login.yahoo.com/account/create");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement email = driver.findElement(By.name("userId"));
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;')", email);
		
		Highlight_Fields.highlight(driver, email);
		
		Thread.sleep(3000);		
		driver.quit();

}
}