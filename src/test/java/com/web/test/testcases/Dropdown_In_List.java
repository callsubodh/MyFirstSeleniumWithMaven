package com.web.test.testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Dropdown_In_List {
	
	public WebDriver driver;
	public Select dd_mon_sel;
	
	@Test
	public void getDropdown() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.get("http://www.facebook.com");	
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<String> actualList = new ArrayList<String>();
		
		List<WebElement> dd_mon = driver.findElements(By.id("month"));
		
		for(int i=0;i<dd_mon.size();i++) {
			
			System.out.println("-----Inside For loop...");
			
			WebElement dd_single_ele = dd_mon.get(i);
			String str1 = dd_single_ele.getText();
			
			System.out.println("Str value is: "+str1);
			
			dd_mon_sel = new Select(driver.findElement(By.id("month")));
			dd_mon_sel.selectByValue(str1);
			Thread.sleep(2000);
		}

		for(WebElement dd_ele: dd_mon)
		{

			String dd_str = dd_ele.getText();
			
			System.out.println("-------------"+dd_str);
		
			System.out.println("=====================");	
			
			actualList.add(dd_str);
		
		//dd_mon_sel.getOptions();
		
		//dd_mon_sel.selectByValue(dd_str);

		}
		

		//actualList.addAll(c)
		
		//Collection coll = Collections.addAll(c, actualList);
		//actualList.addAll(dd_mon.getText());
		
		dd_mon_sel.selectByIndex(3);
		
		WebElement dd_day = driver.findElement(By.xpath("//select[@id='day']"));
		
		Select dd_day_sel = new Select(dd_day);
		
		dd_day_sel.selectByValue("24");
		
		WebElement dd_year = driver.findElement(By.xpath("//select[@title='Year']"));
		
		Select dd_year_sel = new Select(dd_year);
		
		dd_year_sel.selectByVisibleText("2010");
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
	}
	
}
