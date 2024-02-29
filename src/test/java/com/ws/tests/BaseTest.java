package com.ws.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LogInPage;

public class BaseTest extends DriverScript {
	
	HomePage homepage;
	LogInPage loginpage;
	
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
		driver.quit();
		
	}
	

}
