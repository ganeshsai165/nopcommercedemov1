package com.nopecommercev1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage_admin {

	WebDriver ldriver;
	
	// Constructor
	public loginPage_admin(WebDriver rdriver)
	{
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	@CacheLookup
	WebElement btnlogout;
	
	public void cleartxtfields()
	{
		txtemail.clear();
		txtpassword.clear();
	}
	
	public void sendUserName(String uname)
	{
		txtemail.sendKeys(uname);
	}
	
	public void sendPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clicklogin()
	{
		btnlogin.click();
	}
	
	public void clickLogout()
	{
		btnlogout.click();
	}
	
}
