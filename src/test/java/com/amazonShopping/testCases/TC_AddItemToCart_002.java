package com.amazonShopping.testCases;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazonShopping.pageObjects.CartPage;
import com.amazonShopping.pageObjects.DeliveryOptionsPage;
import com.amazonShopping.pageObjects.HomePage;
import com.amazonShopping.pageObjects.ItemDetailsPage;
import com.amazonShopping.pageObjects.LoginPage;
import com.amazonShopping.pageObjects.PaymentPage;
import com.amazonShopping.pageObjects.ReviewOrderPage;
import com.amazonShopping.pageObjects.SearchResultsPage;
import com.amazonShopping.pageObjects.SelectDeliveryAddress;

public class TC_AddItemToCart_002 extends BaseClass {
	
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
		Thread.sleep(15000);
		lp.clickMfaLogin();
	
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
		
		hp.enterItem("Tata Tea Agni");
		hp.hitSearch();
		logger.info("Search results displayed successfully");
		
		SearchResultsPage sp=new SearchResultsPage(driver);
		sp.selectItem();
		logger.info("Item selected successfully");
		

		Set<String> winHandles= driver.getWindowHandles();
		for(String handle : winHandles) {
		driver.switchTo().window(handle);
		}
		
		ItemDetailsPage ip=new ItemDetailsPage(driver);
		String itemFeature=ip.validateVegText();
		if(itemFeature.contains("Vegetarian")) {
			Assert.assertTrue(true);
			logger.info("Product validation passed successfully");
		}
		else {
			Assert.assertTrue(false);
			logger.info("Product validation failed");
		}
		
		ip.addItemToCart();
		logger.info("Items added to cart successfully");
		
		CartPage cp=new CartPage(driver);
		cp.clickToBuy();
		
		SelectDeliveryAddress sda=new SelectDeliveryAddress(driver);
		sda.selectDeliverBtn();
		logger.info("Delivery Address selected succesfully");
		
		DeliveryOptionsPage dop=new DeliveryOptionsPage(driver);
		dop.clickContinueDelivery();
		logger.info("Delivery continued");
		
		PaymentPage pp=new PaymentPage(driver);
		pp.selectPaymentMethod();
		pp.selectBank();
		logger.info("Payment method selected successfully");
		pp.clickContinue();
		
		ReviewOrderPage rop= new ReviewOrderPage(driver);
		rop.clickPlaceOrder();
		logger.info("Items order placed succefully");
		
		Thread.sleep(15000);
		
		if(driver.getTitle().equals("Log in to Internet Banking")) {
			Assert.assertTrue(true);
			logger.info("Online Banking site working fine");
		}
		
		else {
			Assert.assertTrue(false);
			logger.info("Online Banking is not up");
		}

	}
	
	
}
