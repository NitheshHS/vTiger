package com.vTiger.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.GenericLibs.Base;
import com.vTiger.PageObject.Home;
import com.vTiger.PageObject.Organization;

@Listeners(com.vTiger.GenericLibs.ListenerIMP.class)
public class CreateOrganizationTest extends Base {
	@DataProvider
	public Object[][] orgreadData(){
		return fi.readAllDataFromExcel("Organization");
		
	}
	@Test(dataProvider="orgreadData")
	public void createOrganization(String orgName, String website, String tickerSymbol,String employee,
			String industry, String type, String phone,String fax, String otherphone,String email, String ownership)
	{
		home=PageFactory.initElements(driver, Home.class);
		home.clickOnOrganization();
		Organization org = PageFactory.initElements(driver, Organization.class);
		org.createOrganization(orgName, website, tickerSymbol, employee, industry, type, phone, fax, otherphone, email, ownership);
		
	}
}
