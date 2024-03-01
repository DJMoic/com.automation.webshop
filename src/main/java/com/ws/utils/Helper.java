package com.ws.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.ws.base.DriverScript;

public class Helper extends DriverScript {
	
	public static String captureScreen(WebDriver driver) 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenPath = "C:/Users/DURJOY/Desktop/selenium class/workspace/Selenium Automation Framework/com.automation.webshop/reports/screenshots/screen.png";
		//String screenPath = System.getProperty("user-dir")+ "./reports/screenshots/screen.png";
		try {
			FileHandler.copy(src,new File(screenPath));
		} 
		  catch (IOException e) {
			e.printStackTrace();
		}
		return screenPath;
			
	}

}
