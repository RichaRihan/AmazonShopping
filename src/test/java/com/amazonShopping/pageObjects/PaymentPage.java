package com.amazonShopping.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
	
	WebDriver rdriver;
	
	public PaymentPage(WebDriver ldriver){
		rdriver=ldriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath="//input[@value='instrumentId=NetBanking&isExpired=false&paymentMethod=NB&tfxEligible=false']")
	WebElement pmntOption;
	
	@FindBy(name="ppw-bankSelection_dropdown")
	WebElement bnkOption;
	
	@FindBy(xpath="//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent' and @type='submit'][1]")
	WebElement ctnBtn;
	
	@FindBy(xpath="//span[contains(text(),'Choose an Option')]")
	WebElement dropDown;
	
	@FindBy(xpath="//a[@data-value='ICI DIRECT']")
	WebElement iciciOptn;

	
	public void selectPaymentMethod() {
		pmntOption.click();
	}
	
	public void selectBank() {
		//WebDriverWait wait=new WebDriverWait(rdriver, 10);
		//wait.until(ExpectedConditions.visibilityOf(bnkOption));
		
		//Select s= new Select(bnkOption);
		//s.selectByVisibleText("ICICI Bank");
		dropDown.click();
		iciciOptn.click();
	}
	
	public void clickContinue() {
		ctnBtn.click();
	}
}
