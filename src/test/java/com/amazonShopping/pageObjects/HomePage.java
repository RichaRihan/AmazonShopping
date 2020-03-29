package com.amazonShopping.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver rdriver;
	
	public HomePage(WebDriver ldriver) {
		rdriver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	WebElement signIn;
	
	@FindBy(name="field-keywords")
	WebElement searchBar;
	
	@FindBy(xpath="//input[@value='Go']")
	WebElement search;
	
	public void clickSignIn(){
		signIn.click();
	}
	
	public void enterItem(String iname) {
		searchBar.sendKeys(iname);
	}
	
	public void hitSearch() {
		search.click();
	}
	
}
