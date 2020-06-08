package com.vTiger.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.GenericLibs.Base;
import com.vTiger.PageObject.Home;
import com.vTiger.PageObject.Lead;
@Listeners(com.vTiger.GenericLibs.ListenerIMP.class)
public class CreateLeadTest extends Base {
	@DataProvider
	public Object[][] readdata() {
		return fi.readAllDataFromExcel(fi.getCommonKeyValue("sheetname1"));
	}
	
	
	@Test(dataProvider="readdata")
	public void createLead(String fnamesalutaion,String firstname,String lastname,String company,String title,
			String leadsrc,String industry,String anrevenue, String noEmployees,String secMail,String phone,String mobileno,
			String fax,String email,String website,String leadstatus,String rating)
	{
		Reporter.log("Click on leadLink",true);
		home=PageFactory.initElements(driver, Home.class);
		home.clickOnLead();
		Lead lead = PageFactory.initElements(driver, Lead.class);
		lead.enetrLeadDtails(fnamesalutaion, firstname, lastname, company, title, leadsrc, industry, anrevenue, noEmployees, secMail, phone, mobileno, fax, email, website, leadstatus, rating);
		
	}

}
