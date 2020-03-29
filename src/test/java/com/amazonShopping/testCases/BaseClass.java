package com.amazonShopping.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.amazonShopping.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig rc=new ReadConfig();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	public String baseUrl=rc.getApplicationUrl();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	
	@BeforeClass
	public void setup(String br) {
		
		logger=Logger.getLogger("eshopping");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
		//System.setProperty("WebDriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		System.setProperty("WebDriver.chrome.driver",rc.getChromepath());
		driver=new ChromeDriver();
		}
		
		else if(br.equals("firefoox")) {
			
		}
		else if(br.equals("ie")) {
			
		}
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	}
	
	@AfterClass
	public void tearDown() {
		//driver.close();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
}
