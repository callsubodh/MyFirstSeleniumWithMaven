package com.web.test.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HiddenElements {
	
	public WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Test
	public void getHiddenElements() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		/*int x = driver.findElement(By.id("male")).getLocation().getX();
		int y = driver.findElement(By.id("male")).getLocation().getY();
		
		System.out.println("X value is: "+x);
		System.out.println("Y value is: "+y);
		*/
		
		List<WebElement> ele_values = driver.findElements(By.id("male"));
		for(WebElement ele: ele_values) {
			
			int i = ele.getLocation().getX();
			if(i!=0) {
				System.out.println("The element is located at: "+i);
				ele.click();
				break;
			}
		}

		Thread.sleep(2000);
		driver.quit();
		
	}
}
