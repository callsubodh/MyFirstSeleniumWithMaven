package com.web.test.testcases;

import org.testng.annotations.Test;

public class GetEnvSetFromBatchFile {
	
	@Test
	public static void getEnvValue() {
		
		System.out.println(System.getenv("ENV_VALUE"));
		System.out.println(System.getProperty("browser","chromes"));
	}

}
