package com.web.test.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DragDrop {
	
	WebDriver driver;
	
	@Test(description="This is drag and drop scenario..")
	public void dragdrop() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,500)");
		
		WebElement frame_ele = driver.findElement(By.cssSelector("iframe[src*='//dhtmlxcode.com']"));
		
		driver.switchTo().frame(frame_ele);
			
		WebElement allBooks = driver.findElement(By.xpath("//span[text()='Nancy Atherton']"));		
		
		WebElement myLib = driver.findElement(By.xpath("//ul[@role='listbox']"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(allBooks, myLib).perform();
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
