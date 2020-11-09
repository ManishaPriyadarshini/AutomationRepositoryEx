package com.aconex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.aconex.base.utils.BasePage;


public class LoginPage extends BasePage{
	
	//WebDriver driver;

	  By userName = By.xpath("//input[@id='userName']");
	  By password = By.xpath("//input[@id='password']");
	  By loginBtn = By.xpath("//button[@id='login']");
	 
	  public LoginPage(WebDriver driver) {
	    super(driver);
	   }
	
	  public LoginPage loginApplication()
	  {
		  waitForElementPresence(userName);
		  safeType(userName, initAutomationProperties().getProperty("username1"));
		  waitForElementPresence(password);
		  safeType(password, initAutomationProperties().getProperty("password1"));
		  waitForElementPresence(loginBtn);
		  safeClick(loginBtn);
		  return this;
	  }
	  
	  public LoginPage loginApplicationDiffUser()
	  {
		  waitForElementPresence(userName);
		  safeType(userName, initAutomationProperties().getProperty("username2"));
		  waitForElementPresence(password);
		  safeType(password, initAutomationProperties().getProperty("password2"));
		  waitForElementPresence(loginBtn);
		  safeClick(loginBtn);
		  return this;
	  }
	 

}
