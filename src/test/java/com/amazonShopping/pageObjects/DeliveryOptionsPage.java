package com.amazonShopping.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryOptionsPage {
	
	WebDriver rdriver;
	
	public DeliveryOptionsPage(WebDriver ldriver) {
		rdriver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	@FindBy(xpath="//form[@id='shippingOptionFormId']/div/div[2]/div/span/span/input")
	WebElement contDelivery;
	
	public void clickContinueDelivery(){
		contDelivery.click();
	}

}
