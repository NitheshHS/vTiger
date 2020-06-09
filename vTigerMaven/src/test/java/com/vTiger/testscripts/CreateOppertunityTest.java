package com.vTiger.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.GenericLibs.Base;
import com.vTiger.PageObject.Home;
import com.vTiger.PageObject.Oppertunity;

@Listeners(com.vTiger.GenericLibs.ListenerIMP.class)
public class CreateOppertunityTest extends Base{
	@DataProvider
	public Object[][] opreaddata(){
		return fi.readAllDataFromExcel("Oppertunity");
		
	}
	@Test(dataProvider="opreaddata")
	public void createOppertunity(String opname, String typevalue, String leadsource,String amount, String salesstage) {
		home=PageFactory.initElements(driver, Home.class);
		home.clickOnOppertunity();
		Oppertunity opp = PageFactory.initElements(driver, Oppertunity.class);
		opp.createOppertunity(opname, typevalue, leadsource, amount, salesstage);
		
	}

}
