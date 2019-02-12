package com.Ashish.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.Ashish.pages.HomePage;
import com.Ashish.pages.LoginPage;
import com.Ashish.pages.ZohoAppPage;
import com.Ashish.testbase.TestBase;
import com.Ashish.utilities.Utilities;

public class LoginTest extends TestBase {
	
	@Test(dataProviderClass=Utilities.class, dataProvider="dp")
	public void login(Hashtable<String, String> data) {
		
		HomePage home = new HomePage();
		 LoginPage login = home.gotoLogin();
		 
		 ZohoAppPage zp =  login.doLogin(data.get("username"), data.get("password"));
	}
}
