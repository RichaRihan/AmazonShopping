package com.amazonShopping.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazonShopping.pageObjects.HomePage;
import com.amazonShopping.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		

		logger.info("URL opened successfully");
		HomePage hp=new HomePage(driver);
		hp.clickSignIn();
		logger.info("Sign in page launched succesfully");
		LoginPage lp=new LoginPage(driver);
		//driver.wait(10000);
		lp.setUsername(username);
		lp.clickConfirm();
		logger.info("Username confirmed successfully");
		//driver.wait(10000);
		lp.setPassword(password);
		lp.clickLogin();
		logger.info("Logged in successfully");
		
		if(driver.getTitle().contains("Online Shopping site in India")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		
		else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
		
	}

}
