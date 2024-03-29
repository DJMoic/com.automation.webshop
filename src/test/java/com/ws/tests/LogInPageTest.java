package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LogInPage;



public class LogInPageTest extends BaseTest{
	
	
	
	@Test(enabled = true)
	public void testHomePageTitle() 
	{
		logger = report.createTest("Validating HomePage Title");
		String title = homepage.getHomePageTitle();
		logger.pass("Got the HomePageTitle");
		System.out.println(title);
		Assert.assertTrue(title.contains("Demo Web Shop"));
		logger.pass("Verified the HomePageTitle Successfully");
		
	}
	@Test(dataProvider = "wsdata", enabled = false)
	public void testLoginFucntion(String username, String password) throws InterruptedException {
		logger = report.createTest("Validating the login Function");
		homepage.clickLogin();
		logger.pass("Verified login");
	    String loginpagetitle = loginpage.getLoginPageTitle();
	    logger.pass(loginpagetitle);
	    Assert.assertTrue(loginpagetitle.contains("Login"));
	    logger.pass("Verified the loginpagetitle");
	    
	    loginpage.enterEmail(username);
	    logger.pass("Entered email");
		loginpage.enterPassword(password);
		logger.pass("entered password");
		Thread.sleep(3000);
		loginpage.clickLoginButton();
		logger.pass("Successfully clicked Login");
		String title = homepage.getHomePageTitle();
		Assert.assertTrue(title.contains("Demo Web Shop"));
		logger.pass("Got HomePege Title");
		homepage.clickLogout();
		logger.pass("Clicked Logout");
		
				
	}
	@Test (enabled = true)
	public void testForgotPasswordLink() {
		logger = report.createTest("Validating the forgotpassword link is present");
		homepage.clickLogin();
		logger.pass("Verified click Login" );
		boolean flag = loginpage.isForgotpasswordLinkPresent();
		logger.pass("Verified ForgotPasswordLink is present");
		Assert.assertTrue(flag);
		quitDriver();
	}
	
	@Test(enabled =true)
	public void testinvalidemailid()
	{
		logger = report.createTest("Validating message showing \"invalid email");
		homepage.clickLogin();
		logger.pass("Clicked Login");
		loginpage.enterEmail("se");
		logger.pass("Entered invalid email");
		loginpage.clickLoginButton();
		logger.pass("Clicked LogIn Button");
		String emailerrormessage = loginpage.invalidemailMsg();
		System.out.println(emailerrormessage);
		Assert.assertTrue(emailerrormessage.contains("Please enter a valid email address."));
       
		 
		
		
		
		
	   
		
	}
	

}
