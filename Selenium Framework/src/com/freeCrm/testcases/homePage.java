package com.freeCrm.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.freebase.TestBaseclass;

public class homePage extends TestBaseclass {


public homePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
@BeforeMethod()

public void preconditionLogin() {
	intialization();
//	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
//driver = new ChromeDriver();
//driver.get("https://freecrm.com/");



WebElement homelogin=driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']"));
homelogin.click();
String loginpageURL=driver.getCurrentUrl();
driver.get(loginpageURL);
driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);

WebElement userName=driver.findElement(By.name("email"));
WebElement passWord=driver.findElement(By.name("password"));
WebElement loginpageLoginButton=driver.findElement(By.xpath("//Div[@class='ui fluid large blue submit button']"));
userName.sendKeys(prop.getProperty("username"));
passWord.sendKeys(prop.getProperty("password"));
loginpageLoginButton.click();

}
@BeforeClass
public void beforeClass() {
	System.out.println("Hi");

}
@AfterClass
public void aftereClass() {
	System.out.println("goodBye");

}
@Test(priority = 6)
 public void clickOnContact() {
	 WebElement conTacts=driver.findElement(By.xpath("//*[@id=\"main-nav\"]/a[3]"));
	 conTacts.click();
	 driver.quit();
 }
	
 @Test(priority = 6)
 public void nameIsdispalyedorNot() {
	 WebElement name=driver.findElement(By.xpath("//*[text()='ahmed ali']"));
	 boolean actualResult=name.isDisplayed();
	 Assert.assertTrue(actualResult, "the name is not displayed");
 }

}
