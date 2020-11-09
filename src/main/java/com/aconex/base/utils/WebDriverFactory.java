package com.aconex.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory extends BasePage{
	WebDriver driver;

	

	public WebDriver createBrowser() {
		try {
			String browserName = initAutomationProperties().getProperty("Browser");
			String windowType = initAutomationProperties().getProperty("OperatingSystem");
			if (browserName.equalsIgnoreCase("chrome") && (windowType.equalsIgnoreCase("window"))) {
				final ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-web-security");
				options.addArguments("--allow-running-insecure-content");
				options.addArguments("--disable-extensions");
				options.addArguments("test-type");
				options.addArguments("--start-maximized");
				options.addArguments("--disable-web-security");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);

			}

		} catch (final Exception e) {
			System.out.println(" Caught Exception in the launching Firefox browser" + e);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(initAutomationProperties().getProperty("Url"));
		
		return driver;
	}
}
