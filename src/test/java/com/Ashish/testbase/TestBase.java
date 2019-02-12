package com.Ashish.testbase;

import org.testng.annotations.AfterSuite;

import com.Ashish.base.Page;

public class TestBase {
	
	@AfterSuite
	public void teardown() {
		
		Page.quit();
	}
}
