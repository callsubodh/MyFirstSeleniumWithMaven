package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Guru99LoginPageObject {
	
	public Guru99LoginPageObject(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	public WebElement txtEmailAddress;
	
	@FindBy(id="passwd")
	public WebElement txtPassword;
	
	@FindBy(id="SubmitLogin")
	public WebElement btnSignIn;
	
	@FindBy(xpath="//*[@id=\"login_form\"]/div/p[1]/a")
	public WebElement lnkForgotPwd;
	
	
	public void txtEmailAddress(String email) {
		
		txtEmailAddress.sendKeys(email);
	}
	
	public void txtPassword(String pass) {
		
		txtEmailAddress.sendKeys(pass);
	}
	
}
