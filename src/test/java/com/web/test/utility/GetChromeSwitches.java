package com.web.test.utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.chrome.ChromeOptions;

public class GetChromeSwitches {


	public static List<String> switches() {

		List<String> chromeSwitches = new ArrayList<String>();

		//ChromeSwitchesInt is an Interface
		chromeSwitches.add(ChromeSwitchesInt.INCOGNITO);
		//chromeSwitches.add(ChromeSwitchesInt.ALLOW_INSECURE_CONTENT);
		//chromeSwitches.add(ChromeSwitchesInt.IGNORE_CERTIFICATE_ERRORS);
		chromeSwitches.add(ChromeSwitchesInt.START_FULLSCREEN);
		System.out.println(chromeSwitches);

		return chromeSwitches;
	}

	public static List<String> exclSwitches(){

		List<String> exclSw = new ArrayList<String>();
		exclSw.add(ChromeSwitchesInt.DISABLE_POPUP_BLOCKING);
		exclSw.add(ChromeSwitchesInt.ENABLE_AUTOMATION);

		return exclSw;

	}

	public static ChromeOptions browserChromeOptions() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments(GetChromeSwitches.switches());
		options.setExperimentalOption("excludeSwitches", exclSwitches());
		
		return options;
	}

}
