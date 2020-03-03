package com.freebase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import comFreeUTIL.WebListener;

public class TestBaseclass {
	public static Properties prop;

	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebListener weblistener;
	
	public TestBaseclass() throws IOException {
	 prop=new Properties();
		 FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Selenium Framework\\src\\com\\free\\configproperties\\config.Properties");
		 prop.load(fis);
	}
	
	public void intialization() {
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
	//	driver.get(prop.getProperty("url"));
	
		driver.manage().window().maximize();
		
		e_driver=new EventFiringWebDriver(driver);
		weblistener=new WebListener();
		e_driver.register(weblistener);
		driver=e_driver;
		
		
	}
	

}
