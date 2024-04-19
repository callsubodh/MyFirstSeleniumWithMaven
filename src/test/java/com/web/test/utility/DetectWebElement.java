package com.web.test.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetectWebElement {
	
	public static WebElement names(WebDriver driver, String nameval) {
		
		WebElement nameEle = driver.findElement(By.name(nameval));
		return nameEle;
	}

}
