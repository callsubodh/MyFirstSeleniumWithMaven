package com.web.test.utility;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class KillBrowserDrivers {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		Process procval = Runtime.getRuntime().exec("./Drivers/chromedriver.exe");
		Boolean boolVal = procval.isAlive();
		System.out.println("Is ChromeDriver Available? "+boolVal);

		/*		/F is to forcefully perform the operation
		 * 		/IM is the image name aka the executable name	
		 * 		/T to terminate the specified and any of it's child processes	*/
				List<String> killSwitchesList = Arrays.asList("taskkill /F /IM geckodriver.exe /T","taskkill /F /IM chromedriver.exe /T", 
						"taskkill /F /IM msedge.exe /T", "taskkill /F /IM RuntimeBroker.exe /T");
				for(String killSwitch: killSwitchesList) {
				Process browserProcess = Runtime.getRuntime().exec(killSwitch);				
				//System.out.println("Successfully Killed: "+ killSwitch.substring(16));
				
				String[] splitString = killSwitch.split(" ");
				for(String str: splitString)
					if(str.contains(".exe"))
						System.out.println("Browser killed is: "+str);
				}
				
//				Process chromeprocess = Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
//				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe /T");
		//
		//		if((ffprocess.isAlive() && chromeprocess.isAlive())){
		//			System.out.println("==============Success==============");
		//		}else
		//			System.out.println("==============Failure==============");

	}

}
