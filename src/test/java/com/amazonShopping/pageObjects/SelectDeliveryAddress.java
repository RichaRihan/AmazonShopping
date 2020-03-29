package com.amazonShopping.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectDeliveryAddress {
	
	WebDriver rdriver;
	
	public SelectDeliveryAddress(WebDriver ldriver){
		rdriver=ldriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	@FindBy(xpath="//a[@class='a-declarative a-button-text '][1]")
	WebElement deliverBtn;
	
	public void selectDeliverBtn() {
		deliverBtn.click();
	}

}
