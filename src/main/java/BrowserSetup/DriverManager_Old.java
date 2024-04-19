package BrowserSetup;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager_Old {

	WebDriver driver;
	Logger log = Logger.getLogger(DriverManager_Old.class.getClass());
	
	@Test
	public void testDriverManager() throws InterruptedException {
		
		//ChromeOptions chromeOptions = new ChromeOptions();
		//import webdrivermanager dependency in maven
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();	
		driver.get("http://facebook.com");
		System.out.println(driver.getTitle());
		log.info("#######################################This is after getting title ##################################################################");
		WebElement email = driver.findElement(By.id("email"));
		String bgColor = email.getCssValue("backgroundColor");
		System.out.println("Background color is : "+ bgColor);
		email.sendKeys("subodhkoka@sanmar.com");
		log.warn("++++++++++++++++++++++++This is warning++++++++++++++++++++++++++");
		driver.manage().window().fullscreen();
		//Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);
		//driver.quit();

	}

}
