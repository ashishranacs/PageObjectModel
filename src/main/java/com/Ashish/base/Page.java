package com.Ashish.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.Ashish.utilities.ExcelReader;
import com.Ashish.utilities.ExtentManager;
import com.Ashish.utilities.Utilities;



public class Page {
	
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\Ashish\\excel\\testdata.xlsx");
	public int implicitwaitTime = 20;
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInsatnce();
	public static ExtentTest test;
	public static String browser;
	public static TopMenu menu;
	
	public Page() {
		
		
		if(driver==null) {
			
			
			
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir")+"\\src\\test\\resources\\com\\Ashish\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				config.load(fis);
				log.debug("config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir")+"\\src\\test\\resources\\com\\Ashish\\properties\\OR.properties");

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				OR.load(fis);
				log.debug("OR file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Jenkins browser selection
			
			if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()) {
				
				browser = System.getenv("browser");
			} else {
				
				browser = config.getProperty("browser");
			}
			
			config.setProperty("browser", browser);
			
			
			if (config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\Ashish\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("chrome launched");
			}

			else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\Ashish\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
				log.debug("firefox launched");

			}
			
			else if(config.getProperty("browser").equals("edge")) {
				
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\com\\Ashish\\executables\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
				log.debug("Edge browser launched");
			}
			
			
			driver.get(config.getProperty("baseUrl"));
			log.debug("navigating to: " + config.getProperty("baseUrl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(implicitwaitTime, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);
		}
		
	}
	
	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {

			return false;
		}
	}

	public void click(String locator) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}

		else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}

		else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}

		test.log(LogStatus.INFO, "Clicking on: " + locator);
	}

	public void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}

		else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}

		else if (locator.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
		test.log(LogStatus.INFO, "Typing in: " + locator + " entered value: " + value);
	}

	public void verifyEqual(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);
		} catch (Throwable t) {

			Utilities.captureScreenshot();

			// ReportNG

			Reporter.log("Click to see..");
			Reporter.log("<a target=\"_blank\" href=" + Utilities.screenShotName + ">Screenshot</a>");
			Reporter.log("<br>");

			// Extent Report

			test.log(LogStatus.FAIL, " Verification failed with exception: " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenShotName));
		}
	}

	static WebElement dropdown;

	public void select(String locator, String value) {
		
		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}

		else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		}

		else if (locator.endsWith("_ID")) {

			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}
		
		
		Select select = new Select(dropdown);
		
		select.selectByVisibleText(value);
		
		test.log(LogStatus.INFO, "Selecting from dropdown: " + locator + " selected  value: " + value);
	}
	
	
	 public static void quit() {
		 
		 driver.quit();
	 }
	
}
