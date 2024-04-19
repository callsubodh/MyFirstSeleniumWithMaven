package BrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirefoxBrowser {
	
	@Test
	public void FFBrowser() throws InterruptedException {

		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Subodh\\Documents\\My Docs\\workspace\\Selenium\\Selenium Jars\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
}
}
