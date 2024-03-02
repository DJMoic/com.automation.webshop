package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;


/*
 * Title : Home Page
 * Description : Home Page class which contains elements and its methods
 * Developed by: Moitrayee , date: 02.22.2024
 * Approved By:  
 */
public class HomePage extends DriverScript {
	
	//***************************************Page Elements*************************************//
	@FindBy(linkText ="Log in") WebElement loginLink;
	@FindBy(linkText ="Log out" ) WebElement logoutLink;
	@FindBy(xpath = "//a[@href='/register']")WebElement registerlink;
	
	//***************************************Page Initialization******************************//
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//****************************************Page Actions***********************************//
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public void clickLogin() {
		loginLink.click();
	}
	public void clickLogout() {
		logoutLink.click();
	}
	public void clickregisterlink() {
		registerlink.click();
	}
	

}
