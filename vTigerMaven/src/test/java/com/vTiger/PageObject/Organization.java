package com.vTiger.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.vTiger.GenericLibs.Base;

public class Organization {

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationIcon;
	
	@FindBy(name="accountname")
	private WebElement orgNameTF;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgNameInfo;
	
	@FindBy(id="selectCurrentPageRec")
	private WebElement checkBox;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath="//img[contains(@src,'status.gif')]")
	private WebElement statusBar;
	
	
	
	public WebElement getStatusBar() {
		return statusBar;
	}

	public WebElement getCreateOrganizationIcon() {
		return createOrganizationIcon;
	}

	public WebElement getOrgNameTF() {
		return orgNameTF;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	
	public WebElement getOrgNameInfo() {
		return orgNameInfo;
	}
	

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public void createOrganization(String orgName) {
		Reporter.log("click on create organization(+)",true);
		createOrganizationIcon.click();
		Reporter.log("enter organization name",true);
		orgNameTF.sendKeys(orgName);
		Reporter.log("click on save button", true);
		savebutton.click();
		Reporter.log("Verify expected result with actual reault", true);
		Assert.assertTrue((orgNameInfo.getText()).contains(orgName));
	}
	
	public void deleteAllOrg() {
		checkBox.click();
		Reporter.log("click on check box", true);
		deleteButton.click();
		Reporter.log("click on delete button");
		Base.staticDriver.switchTo().alert().accept();
		
		WebDriverWait wait=new WebDriverWait(Base.staticDriver, 20); 
		wait.until(ExpectedConditions.invisibilityOf(statusBar));
		
	}
	
}
