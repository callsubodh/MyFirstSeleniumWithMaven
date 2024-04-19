package com.web.test.utility;

public interface ChromeSwitchesInt {
	
	String INCOGNITO = "incognito";
	String ALLOW_INSECURE_CONTENT = "allow-running-insecure-content";
	String IGNORE_CERTIFICATE_ERRORS = "--ignore-certificate-errors" ;
	String START_FULLSCREEN = "start-fullscreen";
	String HEADLESS = "headless";
	String REMOTE_ORIGINS = "--remote-allow-origins=*";
	String DISABLE_POPUP_BLOCKING = "disable-popup-blocking";
	String ENABLE_AUTOMATION = "--enable-automation";
	
	//below variables are not being used in any program yet. Need to explore
	final String BROWSER_NOTIFICATIONS = "profile.managed_default_content_settings.notifications";
    final short DISABLED = 2;

}
