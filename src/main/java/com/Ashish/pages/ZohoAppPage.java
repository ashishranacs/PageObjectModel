package com.Ashish.pages;

import org.openqa.selenium.By;

import com.Ashish.base.Page;
import com.Ashish.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page {
	
	
	public void gotoCliq() {
		
		
	}
	
	public CRMHomePage gotoCRM() {
		
		click("gotoCRMPageLink_XPATH");
		
		return new CRMHomePage();
		
	}
	
	public void gotoSalesIQ() {
		
		
	}
}
