package com.Ashish.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	
	private static ExtentReports extent;
	
	public static ExtentReports getInsatnce() {
		
		if(extent == null) {
			
			extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\Ashish\\extentconfig\\ReportsConfig.xml"));
			
		}
		
		return extent;
	}
}
