package com.vTiger.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.vTiger.GenericLibs.Base;
import com.vTiger.GenericLibs.Utility;

public class Lead {
	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement createLeadIcon;
	
	@FindBy(name="salutationtype")
	private WebElement firstnamedrop;
	
	@FindBy(name="firstname")
	private WebElement firstNameTF;
	
	@FindBy(name="lastname")
	private WebElement lastnameTF;
	
	@FindBy(name="company")
	private WebElement companyTF;
	
	@FindBy(id="designation")
	private WebElement titleTF;
	
	@FindBy(name="leadsource")
	private WebElement leadsourcedrop;
	
	@FindBy(name="industry")
	private WebElement industrydrop;
	
	@FindBy(name="annualrevenue")
	private WebElement annualrevTF;
	
	@FindBy(id="noofemployees")
	private WebElement noEmployeeTF;
	
	@FindBy(id="secondaryemail")
	private WebElement secondarymailTF;
	
	@FindBy(id="phone")
	private WebElement phoneTF;
	
	@FindBy(id="mobile")
	private WebElement mobileTF;
	
	@FindBy(id="fax")
	private WebElement faxTF;
	
	@FindBy(id="email")
	private WebElement emailTF;
	
	@FindBy(name="website")
	private WebElement websiteTF;
	
	@FindBy(name="leadstatus")
	private WebElement leadstatusDrop;
	
	@FindBy(name="rating")
	private WebElement ratingdrop;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement header;
	
	@FindBy(xpath="//img[contains(@src,'status.gif')]")
	private WebElement statusBar;
	
	
	
	public WebElement getStatusBar() {
		return statusBar;
	}
	public WebElement getCreateLeadIcon() {
		return createLeadIcon;
	}
	public WebElement getFirstnamedrop() {
		return firstnamedrop;
	}
	public WebElement getFirstNameTF() {
		return firstNameTF;
	}
	public WebElement getLastnameTF() {
		return lastnameTF;
	}
	public WebElement getCompanyTF() {
		return companyTF;
	}
	public WebElement getTitleTF() {
		return titleTF;
	}
	public WebElement getLeadsourcedrop() {
		return leadsourcedrop;
	}
	public WebElement getIndustrydrop() {
		return industrydrop;
	}
	public WebElement getAnnualrevTF() {
		return annualrevTF;
	}
	public WebElement getNoEmployeeTF() {
		return noEmployeeTF;
	}
	public WebElement getSecondarymailTF() {
		return secondarymailTF;
	}




	public WebElement getPhoneTF() {
		return phoneTF;
	}




	public WebElement getMobileTF() {
		return mobileTF;
	}




	public WebElement getFaxTF() {
		return faxTF;
	}




	public WebElement getEmailTF() {
		return emailTF;
	}




	public WebElement getWebsiteTF() {
		return websiteTF;
	}




	public WebElement getLeadstatusDrop() {
		return leadstatusDrop;
	}




	public WebElement getRatingdrop() {
		return ratingdrop;
	}




	public WebElement getSavebutton() {
		return savebutton;
	}




	public void enetrLeadDtails(String fnamesalutaion,String firstname,String lastname,String company,String title,
			String leadsrc,String industry,String anrevenue, String noEmployees,String secMail,String phone,String mobileno,
			String fax,String email,String website,String leadstatus,String rating)
	{
		Reporter.log("click on create lead icon(+)", true);
		createLeadIcon.click();
		Reporter.log("saluating first name",true);
		Utility.dropDown(firstnamedrop, fnamesalutaion);
		Reporter.log("enter first name", true);
		firstNameTF.sendKeys(firstname);
		Reporter.log("enter last name", true);
		lastnameTF.sendKeys(lastname);
		Reporter.log("enter company name");
		companyTF.sendKeys(company);
		Reporter.log("enter designation",true);
		titleTF.sendKeys(title);
		Reporter.log("Saluating leadsource", true);
		Utility.dropDown(leadsourcedrop, leadsrc);
		Reporter.log("saluating industry", true);
		Utility.dropDown(industrydrop, industry);
		Reporter.log("enter annual revenue", true);
		annualrevTF.sendKeys(anrevenue);
		Reporter.log("enter Employees", true);
		noEmployeeTF.sendKeys(noEmployees);
		Reporter.log("enter secondary mail");
		secondarymailTF.sendKeys(secMail);
		Reporter.log("enter phone no", true);
		phoneTF.sendKeys(phone);
		Reporter.log("enter mobile no", true);
		mobileTF.sendKeys(mobileno);
		Reporter.log("enter fax",true);
		faxTF.sendKeys(fax);
		Reporter.log("enter email",true);
		emailTF.sendKeys(email);
		Reporter.log("enter website", true);
		websiteTF.sendKeys(website);
		Reporter.log("saluating leadstatus", true);
		Utility.dropDown(leadstatusDrop, leadstatus);
		Reporter.log("saluating drop", true);
		Utility.dropDown(ratingdrop, rating);
		Reporter.log("click on save", true);
		savebutton.click();
		Reporter.log("comparing actual with expected", true);
		Assert.assertTrue((header.getText()).contains(firstname));
			
	}
	public void deleteLead(String firstname, WebDriver driver) {
		Reporter.log("delete lead", true);
		Base.staticDriver.findElement(By.xpath("//table/tbody/tr[*]//a[.='"+firstname+"']/ancestor::td/following-sibling::td[last()]/a[.='del']")).click();
		Base.staticDriver.switchTo().alert().accept();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOf(statusBar));
	}
}
