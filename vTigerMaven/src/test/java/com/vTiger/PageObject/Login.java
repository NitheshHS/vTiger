package com.vTiger.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	@FindBy(name="user_name")
	private WebElement usernameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	public void logIn(String username, String password)
	{
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginButton.click();
	}
}
