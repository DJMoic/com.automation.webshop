package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BooksPageTest extends BaseTest {
	
	@Test
	public void testbookspage() {
		int actual = 4;
		logger = report.createTest("Validating the Books Menu");
		homepage.clickbooksmenu();
		logger.pass("Clicked Books Menu");
		bookspage.selectbooksdisplayindex(0);
		logger.pass("Selected the dropdown value as 4");
		int count = bookspage.getbookdisplay();
		Assert.assertEquals(actual, count);
		logger.pass("verified the books count from dropdown count");
		System.out.println(count);
		bookspage.selectbookgrid("List");
		logger.pass("verified the view grid");
	
	}
	

}
