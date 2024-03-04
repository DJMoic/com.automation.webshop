package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
	
	
    @Test (enabled=false)
	public void testHomePageTitle() 
	{
		logger = report.createTest("Validating HomePage Title");
		String title = homepage.getHomePageTitle();
		logger.pass("Got the HomePageTitle");
		System.out.println(title);
		Assert.assertTrue(title.contains("Demo Web Shop"));
		logger.pass("Verified the HomePageTitle Successfully");
		
	}
    @Test(dataProvider = "wsdata")
    public void testregisterpage(String gender, String  Name, String LastName, String email, String password, String confrmpasswrd ) throws InterruptedException {
    	logger = report.createTest("Validating Register Page");
    	homepage.clickregisterlink();
    	logger.pass("Successfully clicked register link");
    	registerpage.clickgenderbutton(gender);
    	registerpage.firstname(Name);
    	registerpage.lastname(LastName);
    	registerpage.emailfield(email);
    	registerpage.passwordfield(password);
    	registerpage.confrmpsswrdfield(confrmpasswrd);
    	registerpage.clickregisterbutton();
    	
    	
    	
    	
    	
    	
    }

}
