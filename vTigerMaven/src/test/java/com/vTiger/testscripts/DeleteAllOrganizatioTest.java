package com.vTiger.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.GenericLibs.Base;
import com.vTiger.PageObject.Home;
import com.vTiger.PageObject.Organization;
@Listeners(com.vTiger.GenericLibs.ListenerIMP.class)
public class DeleteAllOrganizatioTest extends Base {
	@Test
	public void deleteOrg() {
		home=PageFactory.initElements(driver, Home.class);
		home.clickOnOrganization();
		Reporter.log("click on organization link in home page", true);
		Organization org = PageFactory.initElements(driver, Organization.class);
		org.deleteAllOrg();
	}
}
