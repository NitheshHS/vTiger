package com.vTiger.PageObject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.vTiger.GenericLibs.Base;
import com.vTiger.GenericLibs.Utility;

public class Oppertunity {
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement createOppertunityIcon;
	
	@FindBy(name="potentialname")
	private WebElement oppertunityNameTF;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement relatedToTF;
	
	@FindBy(name="opportunity_type")
	private WebElement typeSalutation;
	
	@FindBy(name="leadsource")
	private WebElement leadsourceSalutation;
	
	@FindBy(name="amount")
	private WebElement amountTF;
	
	@FindBy(name="sales_stage")
	private WebElement salesstageSalutation;
	
	@FindBy(xpath="//a[.='Google']")
	private WebElement orgnameLink;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	

	public WebElement getOrgnameLink() {
		return orgnameLink;
	}

	public WebElement getCreateOppertunityIcon() {
		return createOppertunityIcon;
	}

	public WebElement getOppertunityNameTF() {
		return oppertunityNameTF;
	}

	public WebElement getRelatedToTF() {
		return relatedToTF;
	}

	public WebElement getTypeSalutation() {
		return typeSalutation;
	}

	public WebElement getLeadsourceSalutation() {
		return leadsourceSalutation;
	}

	public WebElement getAmountTF() {
		return amountTF;
	}

	public WebElement getSalesstageSalutation() {
		return salesstageSalutation;
	}
	
	
	public WebElement getSaveButton() {
		return saveButton;
	}

	public void createOppertunity(String opname, String typevalue, String leadsource,String amount, String salesstage) {
		createOppertunityIcon.click();
		Reporter.log("click on create oppertunity icon", true);
		oppertunityNameTF.sendKeys(opname);
		Reporter.log("enter oppertunity name", true);
		Utility.dropDown(typeSalutation, typevalue);
		Reporter.log("select type", true);
		Utility.dropDown(leadsourceSalutation, leadsource);
		Reporter.log("select lead source", true);
		amountTF.sendKeys(amount);
		Reporter.log("enter amount", true);
		Utility.dropDown(salesstageSalutation, salesstage);
		Reporter.log("select sales stage");
		relatedToTF.click();
		Set<String> win = Base.staticDriver.getWindowHandles();
		Iterator<String> i=win.iterator();
		String pid = i.next();
		String cid = i.next();
		Base.staticDriver.switchTo().window(cid);
		Reporter.log("switch to child window", true);
		WebDriverWait wait =new WebDriverWait(Base.staticDriver, 10);
		wait.until(ExpectedConditions.visibilityOf(orgnameLink));
		orgnameLink.click();
		Reporter.log("click on organization link", true);
		Base.staticDriver.switchTo().window(pid);
		Reporter.log("switch back to parent window", true);
		saveButton.click();
		Reporter.log("click on save", true);
	}
}
