package com.ws.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ws.base.DriverScript;

public class GiftCardPage extends DriverScript {

	// *********************************************page
	// element*****************************************
	@FindBy(id = "products-pagesize")
	WebElement carddisplaynum;
	@FindBy(id = "products-viewmode")
	WebElement carddisplayview;
	@FindBy(xpath = "//div[@class='product-item']")
	List<WebElement> giftcard;
	@FindBy(xpath = "//input[@class='button-2 product-box-add-to-cart-button']")
	WebElement addtocart;

	// ********************************************page
	// initialization***********************************
	public GiftCardPage() {
		PageFactory.initElements(driver, this);
	}
	// *******************************************page
	// action********************************************

	public void clickcarddisplaynum(int index) {
		Select sel = new Select(carddisplaynum);
		sel.selectByIndex(index);
	}

	public void clickcarddisplayview(String name) {
		Select sel1 = new Select(carddisplayview);
		sel1.selectByVisibleText(name);
	}

	public int giftcard() {
		return giftcard.size();
	}

	public void clickaddtocart() {
		addtocart.click();
	}

}
