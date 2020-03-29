package com.amazonShopping.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

WebDriver rdriver;
	
	public SearchResultsPage(WebDriver ldriver){
		rdriver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Tata Agni Leaf Tea, 1kg')]")
	WebElement reqdItem;
	
	
	public void selectItem(){
		reqdItem.click();
	}
	
}
