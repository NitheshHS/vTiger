package com.vTiger.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.vTiger.GenericLibs.Base;
import com.vTiger.GenericLibs.Utility;

public class Contacts {
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactIcon;
	
	@FindBy(name="salutationtype")
	private WebElement firstdrop;
	
	@FindBy(name="firstname")
	private WebElement firstnameTF;
	
	@FindBy(name="lastname")
	private WebElement lastnameTF;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactInfo;
	
	@FindBy(id="selectCurrentPageRec")
	private WebElement checkBox;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteButton;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastnameInfo;
	
	@FindBy(xpath="//img[contains(@src,'status.gif')]")
	private WebElement statusBar;
	
	public WebElement getStatusBar() {
		return statusBar;
	}

	public WebElement getLastnameInfo() {
		return lastnameInfo;
	}

	public WebElement getCreateContactIcon() {
		return createContactIcon;
	}

	public WebElement getFirstdrop() {
		return firstdrop;
	}

	public WebElement getFirstnameTF() {
		return firstnameTF;
	}

	public WebElement getLastnameTF() {
		return lastnameTF;
	}
	

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	public WebElement getContactInfo() {
		return contactInfo;
	}

	public void enterContacts(String value,String firstname,String lastname) {
		createContactIcon.click();
		Reporter.log("click on create contact Link",true);
		Utility.dropDown(firstdrop, value);
		Reporter.log("Select salutaion",true);
		firstnameTF.sendKeys(firstname);
		Reporter.log("enter firstname",true);
		lastnameTF.sendKeys(lastname);
		Reporter.log("enter lastname", true);
		savebutton.click();
		Assert.assertTrue((contactInfo.getText()).contains(firstname));
	}
	
	public void deleteAllContact(WebDriver driver)
	{
		checkBox.click();
		Reporter.log("click on checkbox", true);
		deleteButton.click();
		Reporter.log("click on delete button",true);
		Base.staticDriver.switchTo().alert().accept();
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(statusBar));
	}
}
