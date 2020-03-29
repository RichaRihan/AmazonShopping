package com.amazonShopping.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDetailsPage {
	
	WebDriver rdriver;
	
	public ItemDetailsPage(WebDriver ldriver) {
		rdriver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(id="text-veg")
	WebElement vegMsg;
	
	@FindBy(name="submit.add-to-cart")
	WebElement btnCart;
	
	public String validateVegText() {
		return vegMsg.getText();
	}
	
	public void addItemToCart() {
		btnCart.click();
	}

}
