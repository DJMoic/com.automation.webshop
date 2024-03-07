package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftCardPageTest extends BaseTest {
	
	@Test
	public void testgiftcardpage() {
		logger = report.createTest("Validating GiftCard Menu");
		int actual = 4;
		homepage.clickgiftcardmenu();
		logger.pass("Clicked Giftcard Menu");
		giftcardpage.clickcarddisplaynum(0);
		logger.pass("Verified the correct number selected is 4");
		int expected = giftcardpage.giftcard();
		Assert.assertEquals(actual, expected);
		System.out.println(expected);
		giftcardpage.clickcarddisplayview("List");
		logger.pass("Clicked on the view type");
		giftcardpage.clickaddtocart();
		logger.pass("Clicked the add to cart button");
	
	}
	
	

}
