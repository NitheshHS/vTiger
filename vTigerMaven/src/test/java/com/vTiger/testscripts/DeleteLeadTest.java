package com.vTiger.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.GenericLibs.Base;
import com.vTiger.PageObject.Home;
import com.vTiger.PageObject.Lead;

@Listeners(com.vTiger.GenericLibs.ListenerIMP.class)
public class DeleteLeadTest extends Base {
//	@DataProvider
//	public String firstName() {
//		String str = fi.readDataInExcel("sheetname1", 1, 1);
//		System.out.println(str);
//		return str;
//		
//	}
	@Test()
	public void deleteLead() {
		home=PageFactory.initElements(driver, Home.class);
		home.clickOnLead();
		Lead lead = PageFactory.initElements(driver, Lead.class);
		
			lead.deleteLead("Watson",driver);
		}

}
