package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LogInPage;



public class LogInPageTest extends BaseTest{
	
	
	
	@Test(enabled = false)
	public void testHomePageTitle() 
	{
		logger = report.createTest("Validating HomePage Title");
		String title = homepage.getHomePageTitle();
		logger.pass("Got the HomePageTitle");
		System.out.println(title);
		Assert.assertTrue(title.contains("Demo Web Shop"));
		logger.pass("Verified the HomePageTitle Successfully");
		
	}
	@Test(enabled = true)
	public void testLoginFucntion() throws InterruptedException {
		logger = report.createTest("Validating the login Function");
		homepage.clickLogin();
		logger.pass("Verified login");
	    String loginpagetitle = loginpage.getLoginPageTitle();
	    logger.pass(loginpagetitle);
	    Assert.assertTrue(loginpagetitle.contains("Login"));
	    logger.pass("Verified the loginpagetitle");
	    
	    loginpage.enterEmail("seleautouser01@test.com");
	    logger.pass("Entered email");
		loginpage.enterPassword("Pass@123");
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
	
	@Test(enabled = false)
	public void testinvalidemailid()
	{
		logger = report.createTest("Validating message showing \"invalid email");
		homepage.clickLogin();
		logger.pass("Clicked Login");
		loginpage.enterEmail("se");
		logger.pass("Entered invalid email");
		loginpage.clickLoginButton();
		logger.pass("Clicked LogIn Button");
		String emailerrormessage = loginpage.invalidemailMsg("please enter valid email");
		Assert.assertTrue(emailerrormessage.contains("enter valid email"));
		driver.quit();
		 
		
		
		
		
	   
		
	}
	

}
