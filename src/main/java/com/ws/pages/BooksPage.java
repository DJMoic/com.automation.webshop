package com.ws.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ws.base.DriverScript;

public class BooksPage extends DriverScript {
	
	
	//******************************************page elements****************************************
	@FindBy(id = "products-pagesize") WebElement selectbooksdisplayindex;
	@FindBy(xpath = "//select[@id ='products-viewmode']") WebElement selectbookgrid;
	@FindBy(xpath = "//div[@class = 'item-box']") List<WebElement> getbookdisplay;
	
	//******************************************page initialization***********************************
	
	public BooksPage() {
		PageFactory.initElements(driver, this);
	}
	//*****************************************page action********************************************
	
	public void  selectbooksdisplayindex(int index) {
		Select sel = new Select(selectbooksdisplayindex);
		sel.selectByIndex(index);
	}
	public void selectbookgrid(String name) {
		Select sel1 = new Select(selectbookgrid);
		sel1.selectByVisibleText(name);
	}
	public int getbookdisplay() {
	return getbookdisplay.size();
	}
	

}
