package com.web.test.testcases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WriteIntoPropertiesFile {

	BufferedReader br;
	BufferedWriter bw;
	String propFilePath = System.getProperty("user.dir")+"\\Configuration\\config.properties";

	static Properties prop;

	public WriteIntoPropertiesFile(){
		
		try {
			br = new BufferedReader(new FileReader(propFilePath));
			
			//true below will append data to the file, false will overwrite data present in the file
			bw = new BufferedWriter(new FileWriter(propFilePath, true));
			
			/*bw.write("browser=Edge");
			bw.newLine();
			bw.write("secondline");
			bw.flush();*/
			
			prop = new Properties();
			prop.load(br);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void getBrowserVal() {
		String browser_val = prop.getProperty("full_name");
		System.out.println(browser_val);	
		//return browser_val;
	}
	
	public void writesetBrowserVal(String newBrowserVal) {
		prop.setProperty("browser", newBrowserVal);
		prop.setProperty("full_name", "Subodh Koka");
		prop.replace("browser", newBrowserVal, "Browser Updated");
		try {
			prop.store(bw, "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*finally {
			if(!bw.close()) {
			bw.close();
			}
		}*/
	}
	
	public static void main(String[] args) {
		
		WriteIntoPropertiesFile wrprop = new WriteIntoPropertiesFile();
		String str = wrprop.propFilePath;
		System.out.println("Properties file is located at: "+str);
		
		wrprop.writesetBrowserVal("Santa");
		getBrowserVal();
	}
	
}


