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
import com.ws.pages.ComputerPage;
import com.ws.pages.HomePage;
import com.ws.pages.LogInPage;
import com.ws.pages.RegisterPage;
import com.ws.utils.ExcelUtils;
import com.ws.utils.Helper;

public class BaseTest extends DriverScript {
	
	protected static ExtentReporter extent;
	 protected static ExtentReports report;
	 protected static ExtentTest logger;
	
	
	HomePage homepage;
	LogInPage loginpage;
	RegisterPage registerpage;
	ComputerPage computer;
	
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
		registerpage = new RegisterPage();
		computer = new ComputerPage();
	
		
		
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
		ExcelUtils xl = new ExcelUtils("./src/test/resources/testdata/wsexceldata.xlsx");
		int rows = xl.getRowCount(0);
		Object[][] data = new Object[rows][6];
		
		for(int i = 0; i<rows; i++)
		{
			for(int j =0; j<6; j++) {
				data[i][j] = xl.getCellData(0, i, j);
			}
			
		}
		return data;
			
			
	
			
		
	}
	

}
