package com.nopecommercev1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	public ReadConfig()
	{
		File scr = new File(System.getProperty("user.dir")+"\\Configuration\\config.properties");
		try 
		{
			FileInputStream fis = new FileInputStream(scr);
			pro = new Properties();
			pro.load(fis);
		}
		catch (Exception e)
		{
			System.out.println("Exception found as :" + e.getMessage());
		}
	}	
	public String getAppURL()
	{
		return pro.getProperty("baseURL");
	}
	public String getUserName()
	{
		return pro.getProperty("useremail");
	}	
	public String getPassword()
	{
		return pro.getProperty("password");
	}
	public String Chromepath()
	{
		return pro.getProperty("chromepath");
	}
	public String Firefoxpath()
	{
		return pro.getProperty("firefoxpath");
	}
	public String Edgepath()
	{
		return pro.getProperty("edgepath");
	}
	public String Screenshotpath()
	{
		return pro.getProperty("Screenshotpath");
	}
}
