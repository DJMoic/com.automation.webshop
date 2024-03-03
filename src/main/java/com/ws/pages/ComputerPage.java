package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class ComputerPage extends DriverScript {
	
	
	//************************************page elements********************************************
	@FindBy(xpath = "//h1[contains(text(),'Computers')]") WebElement computerheadertext;
	@FindBy(xpath = "//img[@title='Show products in category Desktops']") WebElement desktoplink;
	
	//************************************page initialization**************************************
	public ComputerPage() {
		PageFactory.initElements(driver, this);
	}
	//***************************************page actions*******************************************
	public String getcomputerheadertext() {
		return computerheadertext.getText();
	}
	public void clickdesktoplink() {
		desktoplink.click();
		
	}


}
