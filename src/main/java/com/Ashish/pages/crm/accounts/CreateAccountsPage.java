package com.Ashish.pages.crm.accounts;

import org.openqa.selenium.By;

import com.Ashish.base.Page;

public class CreateAccountsPage extends Page {
	
	
	public void createAccount(String name) {
		
		type("accountNameField_XPATH",name);
	}
}
