package com.vTiger.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.vTiger.GenericLibs.Base;

public class Vendor {
	@FindBy(xpath="//img[@title='Create Vendor...']")
	private WebElement createVendorIcon;
	
	@FindBy(name="vendorname")
	private WebElement vendornameTF;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement vendorInfo;

	public WebElement getCreateVendorIcon() {
		return createVendorIcon;
	}

	public WebElement getVendornameTF() {
		return vendornameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	public WebElement getVendorInfo() {
		return vendorInfo;
	}

	public void createVendor(String vendorName) {
		createVendorIcon.click();
		Reporter.log("click on vendor Icon", true);
		vendornameTF.sendKeys(vendorName);
		Reporter.log("enter vendor name", true);
		saveButton.click();
		Reporter.log("click on save", true);
		Assert.assertTrue((vendorInfo.getText()).contains(vendorName));
	}
	
	public void deleteVendor(String vendorName) {
		Base.staticDriver.findElement(By.xpath("//table/tbody/tr[*]//a[.='"+vendorName+"']/ancestor::td/following-sibling::td[last()]/a[.='del']")).click();
		Reporter.log("delete vendor", true);
		Base.staticDriver.switchTo().alert().accept();
	}
}
