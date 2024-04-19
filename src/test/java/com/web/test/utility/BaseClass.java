package com.web.test.utility;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


//@Test(groups= {"Regression", "Sanity"})
public class BaseClass {

	public WebDriver driver;
	public PropertiesReader propread;
	public ExtentReports report;
	public ExtentTest logger;
	public MediaEntityBuilder meb;

	//Important note: After changing the system environment value, eclipse needs to be restarted in order to get the latest values
	public String browser=System.getenv("browser");

	@BeforeClass(alwaysRun = true)
	public void setupSuite() {
		Reporter.log("Inside the BeforeSuite i.e. setupSuite.", true);

		propread = new PropertiesReader();
		File f = new File(System.getProperty("user.dir")+"/Reports/ExtentReport_"+CurrentDateFormat.getDate()+".html");

		ExtentSparkReporter spark = new ExtentSparkReporter(f);
		report = new ExtentReports();
		report.attachReporter(spark);

		Reporter.log("All the setup done.", true);
	}

	@Parameters({"browserType","urlUsed"})
	@BeforeClass(alwaysRun = true)
	public void startApp(String browser, String url) {

		if(browser.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			List<String> optArgs = Arrays.asList();
			
			/*not all switches work when added to setExperimentalOption, we need to add others like --headless switch to 
			 * addArguments method as shown in the next commented out line. We can define switches with --headless or headless
			 */
			options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
//			options.addArguments(Arrays.asList("--remote-allow-origins=*", "start-fullscreen", "allow-running-insecure-content", "--headless", "--ignore-certificate-errors"));
			options.addArguments(optArgs);
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver(options);	

		}else if(browser.equalsIgnoreCase("firefox")) {
			System.out.println("Firfox browser initiated.");
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
			
		}else {
			System.out.println("Edge browser initiated.");
		}


		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		System.out.println("The entered parameter values are: "+browser+ " and "+url);
		//Reading property values from GetFinalValues class file by creating an object and calling the variable directly
		driver.get(new GetFinalValues().QA_env);
		//driver.get(propread.getAppURL());
		//driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@AfterMethod
	public void captureScreenshot(ITestResult result) throws Exception {
		String sspath = CaptureScreenshot.captureScreenWithPath(driver, result.getName());
		meb = MediaEntityBuilder.createScreenCaptureFromPath(sspath);
		if(result.getStatus() == ITestResult.SUCCESS) {
			//			logger.pass("Test "+result.getName()+" Passed", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreenshot.captureScreenWithPath(driver, result.getName())).build());
			logger.pass("Test "+result.getName()+" Passed", meb.build());
		}
		else if(result.getStatus() == ITestResult.SKIP) {

			logger.skip("Test "+result.getName()+" Failed", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreenshot.captureScreenWithPath(driver, result.getName())).build());
		}
		else if(result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SKIP) {

			logger.fail("Test "+result.getName()+" Failed", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreenshot.captureScreenWithPath(driver, result.getName())).build());
		}
		report.flush();


		//driver = BrowserFactory.startApp(driver, "chrome", "http://www.facebook.com");
		/*TakesScreenshot ts = (TakesScreenshot)driver;
				File src = ts.getScreenshotAs(OutputType.FILE);	

				//FileUtils.copyFile(src, new File("./Screenshots/"+this.getClass()+"_"+Thread.currentThread().getStackTrace()[1].getMethodName()+"_"+CurrentDateFormat.getDate()+".png"));
				FileUtils.copyFile(src, new File("./Screenshots/"+result.getTestName()+"_"+CurrentDateFormat.getDate()+".png"));
		 */
		//CaptureScreenshot.captureScreen(driver, result.getName());

	}

	@AfterClass(alwaysRun = true)
	public void quitBrowser() {

		if (driver != null) {
			//TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
			driver.quit();
		}
	}

}
