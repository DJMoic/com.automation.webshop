package com.ws.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.SuiteGenerator;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LogInPage;

public class BaseTest extends DriverScript {
	
	protected static ExtentReporter extent;
	 protected static ExtentReports report;
	 protected static ExtentTest logger;
	
	
	HomePage homepage;
	LogInPage loginpage;
	
	@BeforeSuite
	public void setUpReport()
	{
	extent = new ExtentHtmlReporter("./reports/index.html");
	report = new ExtentReports();
	report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void setup()
	{
		
		initApplication();
		homepage = new HomePage();
		loginpage = new LogInPage();
		
	}
	
	@AfterMethod
	public void teardown() 
	{
		report.flush();
		driver.quit();
		
	}
	

}
