package com.aconex.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BasePage {
	protected WebDriver driver;
	public BasePage() {

	}

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	@SuppressWarnings("unused")
	public static Properties initAutomationProperties() {
		Properties properties = null;
		try {
			final File file = new File(System.getProperty("user.dir") + File.separator + "Env_Config" + File.separator
					+ "config.Properties");
			if (file == null) {
				throw new FileNotFoundException();
			}
			final FileInputStream fileInput = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInput);

			fileInput.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

	public WebDriver getWebdriver() {
		return driver;

}
	public static void log(String message) {
		Reporter.log(message, true);
	}
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void clear(By locator) {
		driver.findElement(locator).clear();
	}

	public void type(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public String getAttribute(By locator, String Attribute) {
		return driver.findElement(locator).getAttribute(Attribute);
	}
	
	public void waitForElementPresence(By locator) {
		
		final WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForElementPresence(By locator, int sec) {
		waitForPage(60);
		final WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void threadSleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}
	public Actions getActions() {
		return new Actions(this.driver);
	}
	public Select selectDD(By locator) {
		return new Select(driver.findElement(locator));
	}

	public void safeClick(By locator) {
		try {
			final WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
		} catch (final WebDriverException e) {
			final Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(locator)).perform();
			action.click().perform();
		}
	}
	public void clickElementUsingJavaScript(By locator) {
		final WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		final JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(locator));
	}

	public void safeType(By locator, String value) {
		final WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
	}

	public void safeClear(By locator) {
		final WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).clear();
	}

	public void doubleClick(By locator) {
		getActions().doubleClick(driver.findElement(locator)).build().perform();
		log("Double Clicked on Element");

	}
	public void waitForPage(int sec) {
		final JavascriptExecutor je = (JavascriptExecutor) driver;
		final int waitTime = sec * 1000;
		int counter = 0;
		counter = 0;
		Long ajaxCount = (long) -1;
		do {
			try {
				Thread.sleep(1000);
			} catch (final InterruptedException e1) {
				e1.printStackTrace();
			}
			counter += 1000;
			try {
				ajaxCount = (Long) ((je)).executeScript("return window.dwr.engine._batchesLength");
			} catch (final WebDriverException e) {

			}
		} while (ajaxCount.intValue() > 0 && counter < waitTime);
	}
	public boolean isElementPresent(By by) {
		boolean value;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		try {
			driver.findElement(by).isDisplayed();
			value = true;
		} catch (final NoSuchElementException e) {
			value = false;
		} finally {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		return value;
	}
	public boolean isDisplayed(By locater) {
		final boolean i = getWebdriver().findElement(locater).isDisplayed();
		return i;
	}
	public BasePage switchToIframe(By locator)
	{
		driver.switchTo().frame(getWebdriver().findElement(locator));
		return this;
	}

	public String getRandomNumber() {
		final String chars = "3456789";
		String ret = "";
		final int length = chars.length();
		for (int i = 0; i < length; i++) {
			ret += chars.split("")[(int) (Math.random() * (length - 1))];
		}
		return ret;
	}
	public void tabOutFromField(By locator) {
		driver.findElement(locator).sendKeys(Keys.TAB);
	}
	public BasePage switchToDefault()
	{
		driver.switchTo().defaultContent();
		return this;
	}
	public void scrollIntoView(By by) {
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		final WebElement element = driver.findElement(by);
		jse.executeScript("arguments[0].scrollIntoView();", element);
		waitForPage(10);
	}

}
