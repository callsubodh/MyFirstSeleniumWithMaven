package BrowserSetup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HighlightElement {
	
	@Test
	public static void flash() throws NullPointerException, InterruptedException {	
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();	
		driver.get("http://facebook.com");
		driver.manage().window().fullscreen();	
		System.out.println(driver.getTitle());
		
		List<WebElement> ele = driver.findElements(By.tagName("input"));
		System.out.println("List of element size in page is: "+ele.size());
		
		//log.info("#######################################This is after getting title ##################################################################");
		WebElement email = driver.findElement(By.id("email"));
		String emailbgColor = email.getCssValue("backgroundColor");
		System.out.println("Background color is : "+ emailbgColor);
		flash(driver,email);
		email.sendKeys("subodhkoka@sanmar.com");
		
		WebElement pass = driver.findElement(By.id("pass"));
		flash(driver,pass);
		pass.sendKeys("password");
		String passbgColor=pass.getCssValue("backgroundColor");

		//log.warn("++++++++++++++++++++++++This is warning++++++++++++++++++++++++++");		
		driver.quit();
	}
	
	public static void flash(WebDriver driver, WebElement element) {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].setAttribute('style','background:Yellow; border: 2px solid Red');",element);
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	//System.out.println(("------arguments[0].setAttribute('style','background:"+emailbgColor+"; border: 2px solid Red');"));
	//jse.executeScript("arguments[0].setAttribute('style','background:"+emailbgColor+"; border: 2px solid Red');", element);
	jse.executeScript("arguments[0].setAttribute('style','background:White');", element);
	}
}
