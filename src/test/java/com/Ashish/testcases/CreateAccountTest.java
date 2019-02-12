package com.Ashish.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.Ashish.base.Page;
import com.Ashish.pages.ZohoAppPage;
import com.Ashish.pages.crm.accounts.AccountsPage;
import com.Ashish.pages.crm.accounts.CreateAccountsPage;
import com.Ashish.utilities.Utilities;

public class CreateAccountTest {

		
	@Test(dataProviderClass=Utilities.class, dataProvider="dp")
	public void createAccountTest(Hashtable<String, String> data) {
			
		ZohoAppPage zp = new ZohoAppPage();
		
		zp.gotoCRM();
		 AccountsPage crmAP = Page.menu.gotoAccounts();
		 
		 CreateAccountsPage cap = crmAP.gotoCreateAccounts();
		 
		 cap.createAccount(data.get("accountname"));
		}
}
