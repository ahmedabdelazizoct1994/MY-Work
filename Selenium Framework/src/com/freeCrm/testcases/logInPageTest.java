package com.freeCrm.testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ReporterConfig.Property;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.freebase.TestBaseclass;

public class logInPageTest extends TestBaseclass {
public logInPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
//	WebDriver driver;
//@BeforeSuite
//public void beforeSuite() {
//	System.out.println("Before Suite");
//}
//public void afterSuite() {
//	System.out.println("After Suite");
//}
//	@BeforeTest
//	public void beforeTest() {
//		
//		System.out.println("I will excute beforeTest");
//	}
//	@AfterTest
//	public void afterTest() {
//		System.out.println("I will excute afterTest");
//	}
//	@BeforeClass
//	public void beforeClass() {
//		System.out.println("Hi");
//
//	}
//	@AfterClass
//	public void aftereClass() {
//		System.out.println("goodBye");

//	}
	
	@BeforeMethod()
	public void precondtions() {
		intialization ();
//		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
//    	 driver = new ChromeDriver();
////    driver.get(prop.getProperty("url"));
//    	
	}
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	
	public void title() throws IOException {
		//here we write testcase related to title
	String expectedResult="Free CRM #1 cloud software for any business large or small";
	String actualresult=driver.getTitle();
	System.out.println(actualresult);
	Assert.assertEquals(actualresult, expectedResult);
	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File("C:\\Users\\DELL\\eclipse-workspace\\Selenium Framework\\ScreenShots\\titleScreenshot"));
}
	
	@Test(priority = 2)
	
	public void urlcheck() {
		String xpectedurl="https://freecrm.com/";
	    String actualUrl=driver.getCurrentUrl();
     	System.out.println(actualUrl);
	
        Assert.assertEquals(actualUrl, xpectedurl);
}

	@Test(priority = 3)
	
public void logoIsDisplayedOrNot() {

	WebElement logo= driver.findElement(By.xpath("//a[@title='free crm home']"));
	System.out.println(logo);
   // boolean erLogo=true;
	boolean actualLogo=logo.isDisplayed();
	System.out.println(actualLogo);
	//Assert.assertEquals(actualLogo, erLogo);
Assert.assertTrue(actualLogo," the logo is not displayed");
}
	@Test(priority = 4)
    public void loginTestCases() {
          WebElement homelogin=driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']"));
         homelogin.click();
         String loginpageURL=driver.getCurrentUrl();
         driver.get(loginpageURL);
        

        WebElement userName=driver.findElement(By.name("email"));
        WebElement passWord=driver.findElement(By.name("password"));
        WebElement loginpageLoginButton=driver.findElement(By.xpath("//Div[@class='ui fluid large blue submit button']"));
        userName.sendKeys(prop.getProperty("user"));
        passWord.sendKeys(prop.getProperty("pass"));
         loginpageLoginButton.click();

}
//	@DataProvider
//	public Object[][] myData(){
//		Object[][] data=new Object[2][2];
//		data[0][0]="slayerscream11@gmail.com";
//		data[0][1]="123456";
//		data[1][0]="slayerscream11@gmail.com";
//		data[1][1]="Ahm2715130";
//	return data;
//}
}
