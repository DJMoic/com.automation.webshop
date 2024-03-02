package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class RegisterPage extends DriverScript {
	
	
	
	//*********************************************page elements*****************************************
	
	@FindBy(name = "Gender") WebElement genderbutton;
	@FindBy(id = "FirstName") WebElement firstname;
	@FindBy(id = "LastName") WebElement lastname;
	@FindBy(id = "Email") WebElement emailfield;
	@FindBy(id = "Password") WebElement passwordfield;
	@FindBy(id = "ConfirmPassword") WebElement confrmpsswrdfield;
	@FindBy(id = "register-button") WebElement registerbutton;

	
	
	
	//********************************************page initialization*************************************
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	//********************************************page actions*********************************************
	
	public void genderbutton(String gender) {
		genderbutton.sendKeys(gender);
	}
	
	public void firstname(String Name) {
		firstname.sendKeys(Name);
	}
	public void lastname(String LastName) {
		lastname.sendKeys(LastName);
	}
	public void emailfield(String email) {
		emailfield.sendKeys(email);
	}
	public void passwordfield(String password) {
		passwordfield.sendKeys(password);
	}
	public void confrmpsswrdfield(String confrmpasswrd) {
		confrmpsswrdfield.sendKeys(confrmpasswrd);
	}
	
	public void clickregisterbutton() {
		registerbutton.click();
	}
		
		
		
		
	
	
		
		
		
	}


