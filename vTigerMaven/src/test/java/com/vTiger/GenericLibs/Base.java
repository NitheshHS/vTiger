package com.vTiger.GenericLibs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.vTiger.PageObject.Home;
import com.vTiger.PageObject.Login;

public class Base {
	public FileLib fi =new FileLib();
	public WebDriver driver;
	public static WebDriver staticDriver;
	
	public Login login;
	public Home home;

	@BeforeClass
	public void configBc()
	{
//		if(browserVar.equals("chrome")) {
//			
//			driver = new ChromeDriver();
//			staticDriver=driver;
//		}
//		else if(browserVar.equals("firefox")) {
//			driver = new FirefoxDriver();
//			staticDriver=driver;
//		}
		
		if(fi.getCommonKeyValue("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
			
			driver = new ChromeDriver();
			staticDriver=driver;
		}
		else if(fi.getCommonKeyValue("browser").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			staticDriver=driver;
		}
		driver.manage().window().maximize();
		driver.get(fi.getCommonKeyValue("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	@BeforeMethod
	public void configBM()
	{
		login=PageFactory.initElements(driver, Login.class);
		Reporter.log("log in to vTiger", true);
		login.logIn(fi.getCommonKeyValue("username"),fi.getCommonKeyValue("password"));
		
	}
	@AfterMethod
	public void configAm()
	{
		home=PageFactory.initElements(driver, Home.class);
		home.signOut(driver);
		
	}
	@AfterClass
	public void configAc()
	{
		driver.close();
		
	}
}
