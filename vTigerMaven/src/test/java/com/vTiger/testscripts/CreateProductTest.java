package com.vTiger.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.GenericLibs.Base;
import com.vTiger.PageObject.Home;
import com.vTiger.PageObject.Products;

@Listeners(com.vTiger.GenericLibs.ListenerIMP.class)
public class CreateProductTest extends Base {
	@Test
	public void createproduct() {
		home=PageFactory.initElements(driver, Home.class);
		home.clickOnProducts();
		Products product = PageFactory.initElements(driver, Products.class);
		product.createProduct(fi.getCommonKeyValue("productName"));
		
	}

}
