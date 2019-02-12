package com.Ashish.pages;

import org.openqa.selenium.By;

import com.Ashish.base.Page;

public class HomePage extends Page{
	
	
	
	public LoginPage gotoLogin() {
			
		click("loginBtn_XPATH");
		return new LoginPage();
	}
	
	public void gotoSupport() {
		
		
	}
	
	public void gotoAboutUs() {
		
		
	}
}
