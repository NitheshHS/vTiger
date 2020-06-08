package com.vTiger.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProductIcon;

	@FindBy(name="productname")
	private WebElement productnameTF;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id="mouseArea_Product Name")
	private WebElement productnameInfo;

	public WebElement getCreateProductIcon() {
		return createProductIcon;
	}

	public WebElement getProductnameTF() {
		return productnameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	public WebElement getProductnameInfo() {
		return productnameInfo;
	}

	public void createProduct(String productName) {
		createProductIcon.click();
		productnameTF.sendKeys(productName);
		saveButton.click();
		
	}

}
