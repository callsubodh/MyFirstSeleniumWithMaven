package com.web.test.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.web.test.utility.CurrentDateAddition;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar {
	
	
	@Test
	public void clickCal() throws InterruptedException {
		
		//Use WebDriverManager instead of System.set property to set the path of ChromeDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get("http://www.redbus.in");	
		driver.findElement(By.id("onward_cal")).click();
		
		String getDate = driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td[@class='current day']")).getText();
		System.out.println("Current date is: "+getDate);
		
		//driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td[@class='current day']")).click();
		//List<WebElement> cal_eles = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td[@class='wd day'or@class='current day'or@class='we day']"));
		
		List<WebElement> cal_eles = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td[@class='wd day' or ']"));
		
		System.out.println("List count of tds is: "+cal_eles.size());
		
		//for(WebElement calen_ele: cal_eles) {
			
		for(int i=0;i<cal_eles.size();i++) {
			String str = cal_eles.get(i).getText();
			
			System.out.println("String value is: "+str);
			
			if(str.contains("27")) {
				
				driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td[@class='wd day']")).click();
				break;
			}
			
		}
		
		System.out.println("OUtside for loop");
		Assert.assertEquals(getDate, CurrentDateAddition.getDate(), "Verify current date");
		Thread.sleep(10000);
		
		
		Thread.sleep(10000);
		//driver.quit();
		
		
	}

}
