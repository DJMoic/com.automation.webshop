package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ComputerpageTest extends BaseTest {
	
	@Test
	public void computerheadertext() {
		logger = report.createTest("Validating computer header is present");
		homepage.clickcomputerpage();
		logger.pass("computer page clicked");
	    String text = computer.getcomputerheadertext();
		Assert.assertTrue(text.contains("Computers"));
		System.out.println(text);
		logger.pass("Header has text \"Computers" );
		computer.clickdesktoplink();
		logger.pass("clicked desktop link");

	}

}
