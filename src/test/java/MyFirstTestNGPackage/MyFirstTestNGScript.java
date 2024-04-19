package MyFirstTestNGPackage;

import org.testng.annotations.Test;

public class MyFirstTestNGScript {
	
	@Test(priority=3,description="This is to verify logout functionality")
	public void logout() {
		
		System.out.println("Logged out from the application successfully..");
		
	}
	
	@Test(priority=2,description="This is to verify browse pages..")
	public void browsePage() {
		
		System.out.println("Browse Homepage of an application successfully..");
		
	}
	
	@Test(priority=1, description="This is to verify login functionality")
	public void login() {
		
		System.out.println("Login to the application successfully..");
		
	}
}
