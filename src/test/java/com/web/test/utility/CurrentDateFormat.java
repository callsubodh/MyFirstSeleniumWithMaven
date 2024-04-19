package com.web.test.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateFormat {

	public static String getDate() {	

		//HH - will print in 24 hr format
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		Date dte = new Date();
		/*System.out.println("Date value is: "+dte);
		System.out.println(System.getProperty("user.dir"));
		System.out.println(df.format(dte));*/
		return df.format(dte);
	}
	
	public static void getDate1() {	

		//hh - will print in 12 hr format and 'a' will be for am/pm
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy hh_mm_ss a");
		Date dte = new Date();
		System.out.println("Date value is: "+dte);
		System.out.println(System.getProperty("user.dir"));
		System.out.println(df.format(dte));
	}

}
