package BrowserSetup;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Browsers {
	
	public WebDriver driver=null;
	public String browser="Chrome";
	
	@Parameters("webURL")
	@BeforeMethod(description="This is Before Suite test case")
	public void Browser(String appURL) throws InterruptedException {
		// TODO Auto-generated method stub
		if(browser.equalsIgnoreCase("Chrome")) {
			
			ChromeOptions chopt = new ChromeOptions();
			chopt.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver(chopt);		
		}
		else if(browser.equalsIgnoreCase("firefox")){
			
			//ProfilesIni profile = new ProfilesIni();
			//FirefoxProfile  fp = profile.getProfile("default");
			FirefoxOptions fopt = new FirefoxOptions();	
			FirefoxProfile fp = fopt.getProfile();
			fp.setPreference("browser.startup.homepage", "http://youtube.com");
			fp.setPreference("browser.menu.showViewImageInfo", true);
			fp.setPreference("browser.download.folderList", "C:\\");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Subodh\\Documents\\My Docs\\workspace\\Selenium\\Selenium Jars\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();			
			driver.get("http://google.com");
			System.out.println("Inside FF browser condition..");
			
		}else {
			Reporter.log("This browser is not supported", true);
		}
		
		driver.manage().window().maximize();
		driver.get(appURL);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.navigate().to("http://amazon.com");
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	
	@Test(priority=1, description="This is to verify title")
	public void verifyPageTitle() {
		
		String title = driver.getTitle();
		System.out.println(driver.getTitle());
		
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}
	
	@Test(priority=2, description="This is to verify second page title")
	public void verifyPage2Title() {
		
		driver.navigate().back();
		String title = driver.getTitle();
		System.out.println(driver.getTitle());
		
		Assert.assertEquals(title, "Google.");
	}
	
	@AfterMethod(description="This is After class test case")
	public void tearDown() {
		
		driver.navigate().refresh();
		driver.navigate().back();
		driver.getTitle();
		driver.quit();
	}
}
