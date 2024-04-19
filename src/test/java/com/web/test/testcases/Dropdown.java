package com.web.test.testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Dropdown {
	
	public WebDriver driver;
	
	@Test
	public void getDropdown() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get("http://www.facebook.com");	
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement dd_mon = driver.findElement(By.id("month"));

		Select dd_mon_sel=new Select(dd_mon);
		
		Thread.sleep(3000);
		
		dd_mon_sel.selectByIndex(3);
		
		WebElement dd_day = driver.findElement(By.xpath("//select[@id='day']"));
		
		Select dd_day_sel = new Select(dd_day);
		
		dd_day_sel.selectByValue("24");
		
		WebElement dd_year = driver.findElement(By.xpath("//select[@title='Year']"));
		
		Select dd_year_sel = new Select(dd_year);
		
		dd_year_sel.selectByVisibleText("2010");
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
	}
	
}
