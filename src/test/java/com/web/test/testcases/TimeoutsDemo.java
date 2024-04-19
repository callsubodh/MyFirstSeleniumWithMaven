package com.web.test.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.web.test.utility.GetFinalValues;

public class TimeoutsDemo {

	@Test()
	public void testtimeout() {
		
		System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
		driver.get(new GetFinalValues().QA_env);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String title = driver.getTitle();
		System.out.println("Page title is: "+title);
		//wait.until(ExpectedConditions.textToBePresentInElement(element, text)
		
		//WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
		//wait.until(ExpectedConditions.visibilityOf(emailElement));
		//emailElement.sendKeys("subodh@email.com");
		
		WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
		emailElement.sendKeys("subodh@email.com");
		
		if(title.contains("CRM")) {
			Assert.assertTrue(true,"Test case passed");
		}else
			Assert.assertTrue(false, "Test case failed");
	}

}
