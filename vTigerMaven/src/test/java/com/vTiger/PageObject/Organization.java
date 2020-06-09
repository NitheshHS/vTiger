package com.vTiger.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.vTiger.GenericLibs.Base;
import com.vTiger.GenericLibs.Utility;

public class Organization {

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationIcon;
	
	@FindBy(name="accountname")
	private WebElement orgNameTF;
	
	@FindBy(xpath="//input[@name='website']")
	private WebElement websiteTF;
	
	@FindBy(name="tickersymbol")
	private WebElement tickerSymbolTF;
	
	@FindBy(id="employees")
	private WebElement employeeTF;
	
	@FindBy(name="industry")
	private WebElement industrySalutation;
	
	@FindBy(name="accounttype")
	private WebElement typeSaluation;
	
	@FindBy(id="phone")
	private WebElement phoneTF;
	
	@FindBy(id="fax")
	private WebElement faxTF;
	
	@FindBy(id="otherphone")
	private WebElement otherphoneTF;
	
	@FindBy(id="email1")
	private WebElement emailTF;
	
	@FindBy(id="ownership")
	private WebElement ownershipTF;

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
	

	public WebElement getCreateOrganizationIcon() {
		return createOrganizationIcon;
	}

	public WebElement getOrgNameTF() {
		return orgNameTF;
	}

	public WebElement getWebsiteTF() {
		return websiteTF;
	}

	public WebElement getTickerSymbolTF() {
		return tickerSymbolTF;
	}

	public WebElement getEmployeeTF() {
		return employeeTF;
	}

	public WebElement getIndustrySalutation() {
		return industrySalutation;
	}

	public WebElement getTypeSaluation() {
		return typeSaluation;
	}

	public WebElement getPhoneTF() {
		return phoneTF;
	}

	public WebElement getFaxTF() {
		return faxTF;
	}

	public WebElement getOtherphoneTF() {
		return otherphoneTF;
	}

	public WebElement getEmailTF() {
		return emailTF;
	}

	public WebElement getOwnershipTF() {
		return ownershipTF;
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

	public WebElement getStatusBar() {
		return statusBar;
	}

	public void createOrganization(String orgName, String website, String tickerSymbol,String employee,
			String industry, String type, String phone,String fax, String otherphone,String email, String ownership) {
		Reporter.log("click on create organization(+)",true);
		createOrganizationIcon.click();
		Reporter.log("enter organization name",true);
		orgNameTF.sendKeys(orgName);
		websiteTF.sendKeys(website);
		Reporter.log("enter wesite", true);
		tickerSymbolTF.sendKeys(tickerSymbol);
		Reporter.log("enter ticker symbol", true);
		employeeTF.sendKeys(employee);
		Reporter.log("enter employees", true);
		Utility.dropDown(industrySalutation, industry);
		Reporter.log("select industry", true);
		Utility.dropDown(typeSaluation, type);
		Reporter.log("enter type", true);
		phoneTF.sendKeys(phone);
		Reporter.log("enter phone no", true);
		faxTF.sendKeys(fax);
		Reporter.log("enter fax", true);
		otherphoneTF.sendKeys(otherphone);
		Reporter.log("enter other phone", true);
		emailTF.sendKeys(email);
		Reporter.log("enter email", true);
		ownershipTF.sendKeys(ownership);
		Reporter.log("enter ownership", true);
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
