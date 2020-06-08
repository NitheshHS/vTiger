package com.vTiger.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.GenericLibs.Base;
import com.vTiger.PageObject.Home;
import com.vTiger.PageObject.Vendor;
@Listeners(com.vTiger.GenericLibs.ListenerIMP.class)
public class CreateVendorTest extends Base {
	@Test
	public void createVendor() {
		home=PageFactory.initElements(driver, Home.class);
		home.clickonMore(driver);
		
		Vendor ven = PageFactory.initElements(driver, Vendor.class);
		ven.createVendor(fi.getCommonKeyValue("vendorname"));
		
	}
}

