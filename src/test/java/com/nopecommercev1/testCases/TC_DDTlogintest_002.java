package com.nopecommercev1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopecommercev1.pageObjects.loginPage_admin;
import com.nopecommercev1.utilities.XLUtils;

public class TC_DDTlogintest_002 extends BaseClass {

	
	
	
	
	@Test (dataProvider = "login_data")
	void loginTest(String uname , String pwd) throws InterruptedException
	{
		driver.navigate().to(baseURL);
		
		loginPage_admin lp = new loginPage_admin(driver);
		
		lp.cleartxtfields();
		
		lp.sendUserName(uname);
		lp.sendPassword(pwd);
		lp.clicklogin();
		
		Thread.sleep(2000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true); // TC Pass	
			lp.clickLogout();
			
		}
		else
		{
			try {
				CaptureScreen(driver,"TC_DDTlogintest_002");		
				System.out.println("Screenshot captured");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Assert.assertTrue(false); // TC Fail
		}
		
	}
	
	@DataProvider(name="login_data")
	String[][] DDT_dataProvider() throws IOException
	{
		String filepath = System.getProperty("user.dir")+"\\testData\\TestData.xlsx";
		System.out.println(filepath);
		
		int rows = XLUtils.getRowCount(filepath, "Sheet1");
		int columns = XLUtils.getCellCount(filepath, "Sheet1", 1);
		
		String [][] data = new String[rows][columns] ;
		
		for(int r=1;r<=rows;r++)
		{
			for(int c=0;c<columns;c++)
			{
				data[r-1][c] = XLUtils.getCellData(filepath, "Sheet1", r, c); 
			}
		}
		
		return data;
	}
	
}
