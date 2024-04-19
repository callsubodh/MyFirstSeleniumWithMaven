package com.web.test.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	public WebDriver driver;

	@Test
	public void getCheckbox() throws InterruptedException {

		WebDriverManager.chromedriver().clearDriverCache().setup();
		//		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();

		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

		int count = checkboxes.size();

		System.out.println("Checkbox count in this page is: "+ count);		


		for(WebElement ele: checkboxes) {
			String checkValue = ele.getText();
			System.out.println("Name of the checkbox button is: "+ checkValue);

			/*if(checkValue.equalsIgnoreCase("code")) {
				if(!ele.isSelected())
					ele.click();
				Thread.sleep(3000);
				//To uncheck the checkbox
				ele.click();
				break;
			}	*/		

		}

		WebElement label = driver.findElement(By.xpath("//h4[text()='No comments:']"));
		String s = label.getAttribute("innerHTML");
		System.out.println("Label of the element: " +s);

		driver.quit();

	}


}
