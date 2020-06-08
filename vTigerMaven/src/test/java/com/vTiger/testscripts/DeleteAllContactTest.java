package com.vTiger.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.GenericLibs.Base;
import com.vTiger.PageObject.Contacts;
import com.vTiger.PageObject.Home;
@Listeners(com.vTiger.GenericLibs.ListenerIMP.class)
public class DeleteAllContactTest extends Base {
	@Test
	public void deleteAllContact() {
		home=PageFactory.initElements(driver, Home.class);
		home.clickOnConatcts();
		Reporter.log("click on conatct link", true);
		Contacts conct = PageFactory.initElements(driver, Contacts.class);
		conct.deleteAllContact(driver);
	}
}
