package com.vTiger.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.vTiger.GenericLibs.Utility;

public class Home {
	@FindBy(linkText="Leads")
	private WebElement leadLink;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(xpath="//a[.='More']")
	private WebElement moreLink;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorLink;
	
	@FindBy(xpath="//img[contains(@src,'user.PNG')]")
	private WebElement userIcon;
	
	@FindBy(linkText="Opportunities")
	private WebElement oppertunityLink;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutLink;
	
	

	public WebElement getOppertunityLink() {
		return oppertunityLink;
	}

	public WebElement getLeadLink() {
		return leadLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getVendorLink() {
		return vendorLink;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	public void clickOnLead()
	{
		leadLink.click();
	}
	public void clickOnOrganization()
	{
		organizationLink.click();
	}
	
	public void clickOnConatcts() {
		contactLink.click();
	}
	public void clickOnProducts()
	{
		productLink.click();
	}
	
	public void clickOnOppertunity() {
		oppertunityLink.click();
	}
	public void clickonMore(WebDriver driver)
	{
		Utility.moveToElement(driver, moreLink);
		Reporter.log("move to more link", true);
		vendorLink.click();
	}
	public void signOut(WebDriver driver)
	{
		Reporter.log("move to user icon",true);
		Utility.moveToElement(driver, userIcon);
		
		signoutLink.click();
		Reporter.log("click on signoutLink",true);
	}
	
}
