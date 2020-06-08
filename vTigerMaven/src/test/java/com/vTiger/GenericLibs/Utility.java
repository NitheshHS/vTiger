package com.vTiger.GenericLibs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

public class Utility {
	public static Actions ac;
	public static Select s;
	public static void moveToElement(WebDriver driver, WebElement element)
	{
		ac=new Actions(driver);
		ac.moveToElement(element).perform();
	}
	public static void dropDown(WebElement element,String value) {
		s=new Select(element);
		s.selectByValue(value);
	}
	
	public static void takeScreenshot(WebDriver driver, ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+methodName+".PNG");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
