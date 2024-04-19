package com.web.test.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import com.web.test.utility.BrowserFactory;

public class TestOne {

	public WebDriver driver;


	@Test
	public void set() {

		driver = BrowserFactory.startApp("chrome", "https://register.freecrm.com/register/");

		WebElement emailId= driver.findElement(By.name("email"));
		emailId.sendKeys("testing");
		driver.close();

	}

}
