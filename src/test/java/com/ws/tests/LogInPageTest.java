package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LogInPage;



public class LogInPageTest extends BaseTest{
	
	
	
	@Test
	public void testHomePageTitle() 
	{
		String title = homepage.getHomePageTitle();
		Assert.assertTrue(title.contains("Demo Web Shop"));
		
	}
	@Test
	public void testLoginFucntion() throws InterruptedException {
		homepage.clickLogin();
	    String loginpagetitle = loginpage.getLoginPageTitle();
	    Assert.assertTrue(loginpagetitle.contains("Login"));
	    loginpage.enterEmail("seleautouser01@test.com");
		loginpage.enterPassword("Pass@123");
		Thread.sleep(3000);
		loginpage.clickLoginButton();
		String title = homepage.getHomePageTitle();
		Assert.assertTrue(title.contains("Demo Web Shop"));
		homepage.clickLogout();
		
				
	}
	@Test
	public void testForgotPasswordLink() {
		homepage.clickLogin();
		loginpage.isForgotpasswordLinkPresent();
		
	   
		
	}
	

}
