package com.web.test.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioButton {
	
	public WebDriver driver;
	
	@Test
	public void getRadios() {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
		
		int count = radios.size();
		
		System.out.println("Radio count in this page is: "+ count);
		
		
		
		for(WebElement ele : radios) {
			String radioValue = ele.getAttribute("value");
			System.out.println("Name of the radio button is: "+ radioValue);
			
			if(radioValue.equalsIgnoreCase("JAVA")) {
				ele.click();
				break;
			}
		}
	}

}
