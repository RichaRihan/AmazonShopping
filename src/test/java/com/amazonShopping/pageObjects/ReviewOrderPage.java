package com.amazonShopping.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewOrderPage {

	WebDriver rdriver;
	
	public ReviewOrderPage(WebDriver ldriver) {
		rdriver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(name="placeYourOrder1")
	WebElement placeOrder;
	
	public void clickPlaceOrder() {
		placeOrder.click();
	}
}
