package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LogInPage;



public class LogInPageTest extends DriverScript{
	
	@Test
	public void testHomePageTitle() {
		initApplication();
		HomePage homepage = new HomePage();
		String title = homepage.getHomePageTitle();
		Assert.assertTrue(title.contains("Demo Web Shop"));
		quitDriver();
	}
	@Test
	public void testLoginFucntion() {
		initApplication();
		HomePage homepage = new HomePage();
		homepage.clickLogin();
		LogInPage loginpage = new LogInPage();
	    String loginpagetitle = loginpage.getLoginPageTitle();
	    Assert.assertTrue(loginpagetitle.contains("Login"));
	    loginpage.enterEmail("seleautouser01@test.com");
		loginpage.enterPassword("Pass@123");
		loginpage.clickLoginButton();
		String title = homepage.getHomePageTitle();
		Assert.assertTrue(title.contains("Demo Web Shop"));
		homepage.clickLogout();
		quitDriver();
				
	}
	@Test
	public void testForgotPasswordLink() {
		initApplication();
		HomePage homepage = new HomePage();
		homepage.clickLogin();
		LogInPage loginpage = new LogInPage();
		loginpage.isForgotpasswordLinkPresent();
		quitDriver();
	   
		
	}
	

}
