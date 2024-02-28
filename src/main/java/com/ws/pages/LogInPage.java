package com.ws.pages;

import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;


/*
 * Title: LogIn Page
 * Description: This page contains elements and methods of the LogIn page
 * Developed By: , date-02.22.2024
 * Approved by: 
 */
public class LogInPage extends DriverScript {
	

	//***************************************Page Elements*************************************//
	@FindBy(id = "Email") WebElement emailTextField;
	@FindBy(name = "Password") WebElement passwordField;
	@FindBy(xpath = "//input[@class='button-1 login-button']") WebElement loginButton;
	@FindBy(linkText = "Forgot password?") WebElement forgotPasswordLink;
	
	
	//***************************************Page Initialization******************************//
	public LogInPage() {
		PageFactory.initElements(driver,this);
	
	}
	
	//****************************************Page Actions***********************************//
    public void enterEmail(String email) {
    	emailTextField.sendKeys(email);
    }
    public void enterPassword(String password) {
    		passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
    	loginButton.click();
    }
    public boolean isForgotpasswordLinkPresent() {
    	return forgotPasswordLink.isDisplayed();
    }
    public void forgotPasswordLink() {
    	forgotPasswordLink.click();
    }
    
    public String getLoginPageTitle() {
    	return driver.getTitle();
    }

}
