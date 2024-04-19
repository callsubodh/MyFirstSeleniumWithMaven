package BrowserSetup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Browsers {
	
	public WebDriver driver=null;
	
	
	@Test
	@Parameters({"browsertype","firstURL", "secondURL"})
	//We can only add parameters to test method only when we add parameters annotations
	public void Browser(String browser, String googleURL, String amazonURL) throws InterruptedException {
		
		if(browser.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Subodh\\Documents\\My Docs\\workspace\\Selenium\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		}
		else {
			
			//ProfilesIni profile = new ProfilesIni();
			//FirefoxProfile  fp = profile.getProfile("default");
			FirefoxOptions fopt = new FirefoxOptions();	
			FirefoxProfile fp = fopt.getProfile();
			fp.setPreference("browser.startup.homepage", "http://youtube.com");
			fp.setPreference("browser.menu.showViewImageInfo", true);
			fp.setPreference("browser.download.folderList", "C:\\");
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Subodh\\Documents\\My Docs\\workspace\\Selenium\\Selenium Jars\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();			
			//driver.get("http://google.com");
			System.out.println("Inside FF browser condition..");
			
		}
		
		driver.manage().window().maximize();
		driver.get(googleURL);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		//driver.navigate().to("http://amazon.com");
		driver.navigate().to(amazonURL);
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		System.out.println(driver.getTitle());
		driver.navigate().refresh();
		driver.navigate().back();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.quit();
			
	}
}
