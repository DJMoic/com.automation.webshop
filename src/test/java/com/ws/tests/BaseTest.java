package com.ws.tests;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.xml.SuiteGenerator;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LogInPage;
import com.ws.utils.ExcelUtils;
import com.ws.utils.Helper;

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
	public void teardown(ITestResult result) 
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			try {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreen(driver)).build());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		report.flush();
		driver.quit();
		
	}
	
	@DataProvider(name = "wsdata")
	public Object[][] testdata() {
		ExcelUtils xl = new ExcelUtils("./src/test/resources/testdata/wsdatatest.xlsx");
		int rows = xl.getRowCount(0);
		Object[][] data = new Object[rows][2];
		
		for(int i = 0; i<rows; i++) {
			data[i][0] = xl.getCellData(0, i, 0);
			data[i][1] = xl.getCellData(0, i, 1);
			
		}
		return data;
			
			
	
			
		
	}
	

}
