package com.web.test.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Frame_Count {
	
	WebDriver driver;
	
	@Test
	public void verifyFramesinPage() {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
		
		List<WebElement> iframeWebEle = driver.findElements(By.tagName("iframe"));
		
		System.out.println("Frame Count in this page is: "+iframeWebEle.size());
		
		for(WebElement ele: iframeWebEle) {
			
			System.out.println("Class name of the frame is: "+ele.getAttribute("class"));
			String iframeClsName = ele.getAttribute("class");
			
			if(iframeClsName.equalsIgnoreCase("js-iframe active")) {
				System.out.println("Inside");
				driver.switchTo().frame(1);
				
				Actions act = new Actions(driver);
				WebElement allBooks = driver.findElement(By.xpath("//span[text()='Nancy Atherton']"));
				WebElement myLib = driver.findElement(By.xpath("//ul[@role='listbox']"));
				
				act.dragAndDrop(allBooks, myLib).perform();
				break;
			}
		}
		
		driver.quit();
	}

}
