package com.freeCrm.testcases;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Example {
	
	
	@Test
	
	public void printvalues() throws IOException {
		 Properties prop=new Properties();
		 FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Selenium Framework\\src\\com\\free\\configproperties\\config.Properties");
		 prop.load(fis);
		 String url=prop.getProperty("url");
		 System.out.println(url);
	}

}
