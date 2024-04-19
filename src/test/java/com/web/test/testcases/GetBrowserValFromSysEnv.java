package com.web.test.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.web.test.pages.LoginCRMPage;
import com.web.test.utility.BaseClass;
import com.web.test.utility.DetectWebElement;

public class GetBrowserValFromSysEnv extends BaseClass {


	@Test(groups = {"Sanity"})
	@Parameters({"emailpm", "pwdpm"})
	public void firstTest(String varemail, String varpwd) {

		logger = report.createTest("Login to CRM Page");
		LoginCRMPage loginPage = PageFactory.initElements(driver, LoginCRMPage.class);

		//Reading property values from a properties file
		//loginPage.loginToCRM(propread.getEmailAddress(), propread.getPassword());

		//Reading variables from Parameters
		loginPage.loginToCRM(varemail, varpwd);
		logger.info("Entered the login credentials and logged in successfully.");

		String sysName = propread.getPropertiesData("full_name");

		Assert.assertEquals(sysName, "Subodh Koka");
		Assert.assertNotNull(sysName, "Email field is not empty");
		logger.pass("Logged in successfully...");

	}

}

