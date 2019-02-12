package com.Ashish.rough;

import com.Ashish.base.Page;
import com.Ashish.pages.HomePage;
import com.Ashish.pages.LoginPage;
import com.Ashish.pages.ZohoAppPage;
import com.Ashish.pages.crm.CRMHomePage;
import com.Ashish.pages.crm.accounts.AccountsPage;
import com.Ashish.pages.crm.accounts.CreateAccountsPage;

public class LoginTest {

	public static void main(String[] args) {
		
		 
		 HomePage home = new HomePage();
		 LoginPage login = home.gotoLogin();
		 
		 ZohoAppPage zp =  login.doLogin("jonny.esmith90@gmail.com", "@@Ar14021991");
		 CRMHomePage crm = zp.gotoCRM();
		 
		 AccountsPage crmAP = Page.menu.gotoAccounts();
		 
		 CreateAccountsPage cap = crmAP.gotoCreateAccounts();
		 
		 cap.createAccount("Ashish");
		 
		 
	}

}
