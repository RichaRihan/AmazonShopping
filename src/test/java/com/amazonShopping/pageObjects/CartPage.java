package com.amazonShopping.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

WebDriver rdriver;
	
	public CartPage(WebDriver ldriver){
		rdriver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Proceed to Buy')]")
	WebElement btnBuy;
	
	public void clickToBuy() {
		btnBuy.click();
	}
}
