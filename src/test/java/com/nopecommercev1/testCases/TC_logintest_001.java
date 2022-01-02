package com.nopecommercev1.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopecommercev1.pageObjects.loginPage_admin;

public class TC_logintest_001 extends BaseClass {

	
	@Test
	void LoginTest() throws InterruptedException
	{
		logger = LogManager.getLogger(TC_logintest_001.class);
		
		
		driver.navigate().to(baseURL);
		
		loginPage_admin lp = new loginPage_admin(driver);
		
		lp.cleartxtfields();
		
		lp.sendUserName(username);
		logger.info("Username Provided");
		lp.sendPassword(password);
		logger.info("Password Provided");
		lp.clicklogin();
		logger.info("clicked login Button");
		Thread.sleep(2000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true); // TC Pass
			logger.info("Test Passed");
			lp.clickLogout();
			logger.info("clicking logout button");
		}
		else
		{
			try {
				CaptureScreen(driver,"TC_logintest_001");
				logger.info("Screenshot captured");
				System.out.println("Screenshot captured");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Assert.assertTrue(false); // TC Fail
			logger.info("Test Failed");
			
		}
		
	}
	
	
}
