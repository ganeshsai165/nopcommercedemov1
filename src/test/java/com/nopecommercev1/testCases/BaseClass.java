package com.nopecommercev1.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopecommercev1.utilities.ReadConfig;



public class BaseClass {

	public WebDriver driver;
	ReadConfig rc;
	
	public Logger logger;
	
	
	public String baseURL ;
	public String username ;
	public String password ;
	String screenshotpath ;
	
	@BeforeClass 
	@Parameters("browser")
	public void SetUp(String br)
	{
		logger = LogManager.getLogger(BaseClass.class);
		
		rc = new ReadConfig();
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+rc.Chromepath());
			driver = new ChromeDriver();
			logger.info("Invoking Chrome");
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+rc.Firefoxpath());
			driver = new FirefoxDriver();
			logger.info("invoking Firefox");
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+rc.Edgepath());
			driver = new EdgeDriver();
			logger.info("invoking Egde");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		baseURL = rc.getAppURL(); logger.info("getting base url");
		username = rc.getUserName(); logger.info("getting login email");
		password = rc.getPassword(); logger.info("getting login password");
				
		
	}
	

	@AfterClass
	public void TearDown()
	{
		driver.quit();
		logger.info("Closing Browser/Application");
	}
	
	
	public void CaptureScreen(WebDriver dr ,String fname) throws IOException
	{
		screenshotpath = System.getProperty("user.dir") + rc.Screenshotpath();
		TakesScreenshot ts  = (TakesScreenshot) dr;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(screenshotpath + fname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
		
	}
	
}
