package com.aconex.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aconex.base.utils.BasePage;

import com.aconex.base.utils.WebDriverFactory;

public class BaseTest {
	private WebDriver driver;
	  private BasePage basePage;
	
	  SoftAssert softAssert;
	  public WebDriver getDriver() {
		    return driver;
		  }
	  public BasePage getBasePage() {
		    if (basePage == null) {
		      basePage = new BasePage(getDriver());
		    }
		    return basePage;
	  }
	  public void launchApplication() {
		  driver = new WebDriverFactory().createBrowser();
		  basePage.log("Launched Application");
			
		}
	  public SoftAssert getSoftAssert() {
		  softAssert=new SoftAssert();
		    return softAssert;
		  }
	  public <TPage extends BasePage> TPage getInstanceOfWebPages(Class<TPage> pageClass) {
		    try {
		      // Initialize the Page with its elements and return it.
		      return PageFactory.initElements(driver, pageClass);
		    } catch (final Exception e) {
		      e.printStackTrace();
		      throw e;
		    }
		  }

	}
