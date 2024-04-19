package MyFirstTestNGPackage;
	
	import java.io.File;
	import java.io.IOException;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;

	public class Screenshot {

	 static WebDriver driver;
	 /**
	  * @param args
	  * @throws IOException
	  */
	 @BeforeClass
	 public void Initiate()
	 {
	   driver = new FirefoxDriver();
	 }
	 @Test
	 public void passurl()
	 {
	  driver.get("http://www.google.com/");
	  
	     
	 }
	 @AfterTest
	 public void teardown() throws IOException
	 {
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-YYYY HHMMSS");	  
	  LocalDateTime date = LocalDateTime.now();
	  System.out.println("Local date time value for date var is: "+date);
	  String datetime = dtf.format(date);	  
	  System.out.println("Local date with format before is:" +datetime);
	  
	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(scrFile, new File("C:\\Users\\Subodh\\Documents\\My Docs\\workspace\\Screenshots\\screenshot"+datetime+".png"));
	        driver.quit();
	 }
	}
	