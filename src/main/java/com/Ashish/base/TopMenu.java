package com.Ashish.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Ashish.pages.crm.accounts.AccountsPage;

public class TopMenu {
	
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void gotoHome() {
		
	}
	
	public void gotoLeads() {
		
		
	}
	
	public void gotoContacts() {
		
	}
	
	
	public AccountsPage gotoAccounts() {
		
		driver.findElement(By.xpath("//*[@id=\"mainMenuTabDiv\"]/crm-menu/div[1]/crm-tab/div[2]/div[4]/link-to/a")).click();
		
		return new AccountsPage();
	}

	public void gotoDeals() {
		
		
	}
	
	
	public void gotoActivities() {
		
		 
	}
	
	public void signOut() {
		
		
	}
}
