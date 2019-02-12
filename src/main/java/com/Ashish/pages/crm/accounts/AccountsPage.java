package com.Ashish.pages.crm.accounts;

import org.openqa.selenium.By;

import com.Ashish.base.Page;

public class AccountsPage extends Page {
	
	
	public CreateAccountsPage gotoCreateAccounts() {
		
		click("createAccountsBtn_XPATH");
		
		return new CreateAccountsPage();
	}
	
	public ImportAccountsPage gotoImportAccounts() {
		
		click("gotoImportAccountsBtn_XPATH");
		
		return new ImportAccountsPage();
		
	}
}
