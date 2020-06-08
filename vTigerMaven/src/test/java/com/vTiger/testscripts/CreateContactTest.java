package com.vTiger.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.GenericLibs.Base;
import com.vTiger.PageObject.Contacts;
import com.vTiger.PageObject.Home;

@Listeners(com.vTiger.GenericLibs.ListenerIMP.class)
public class CreateContactTest extends Base {
	@DataProvider
	public Object[][] readdata(){
		
		return fi.readAllDataFromExcel(fi.getCommonKeyValue("sheetname"));
		
	}
	
@Test(dataProvider="readdata")
public void createContact(String value, String firstname, String lastname) {
	home=PageFactory.initElements(driver,Home.class);
	home.clickOnConatcts();
	Contacts contact = PageFactory.initElements(driver, Contacts.class);
	contact.enterContacts(value, firstname, lastname);
	

}
}
