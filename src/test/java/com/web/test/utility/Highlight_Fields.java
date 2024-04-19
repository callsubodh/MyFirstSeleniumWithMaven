package com.web.test.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlight_Fields {
	
	
	public static void highlight(WebDriver driver, WebElement ele) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;')", ele);
	
	}
}
