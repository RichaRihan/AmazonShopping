package com.amazonShopping.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver rdriver;
	
	public LoginPage(WebDriver ldriver){
		rdriver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(name="email")
	WebElement txtUsername;
	
	@FindBy(id="continue")
	WebElement btnContinue;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(id="signInSubmit")
	WebElement btnLogin;
	
	@FindBy(name="mfaSubmit")
	WebElement mfaLogin;
	
	public void setUsername(String uname) {
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickConfirm() {
		btnContinue.click();
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickMfaLogin() {
		mfaLogin.click();
	}
	

}
