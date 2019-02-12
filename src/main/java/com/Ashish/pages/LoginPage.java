package com.Ashish.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Ashish.base.Page;

public class LoginPage extends Page {
	
	
	
	
	public ZohoAppPage doLogin(String username, String password) {
		
		type("username_XPATH", username);
		
		type("password_XPATH",password);
		click("userloginBtn_XPATH");
		
		return new ZohoAppPage();
		
	}
	
	public void gotoSignUpPage() {
		
		click("signUplinkonLoginPage_XPATH");
	}
}
