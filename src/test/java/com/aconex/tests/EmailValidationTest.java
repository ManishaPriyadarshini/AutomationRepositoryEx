package com.aconex.tests;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.SystemUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.asserts.Assertion;

import com.aconex.DataProvider.AconexDataProvider;
import com.aconex.pages.HomePage;
import com.aconex.pages.LoginPage;

public class EmailValidationTest extends BaseTest{
	
	@BeforeTest
    public void beforeTest() {
		launchApplication();
        getInstanceOfWebPages(LoginPage.class).loginApplication();
    }
	
	@Test(dataProviderClass = AconexDataProvider.class, dataProvider= "EmailValidation")
	public void emailtest(String menu, String subSection,String mailType,String groupName,String	familyName,String subject,String attribute1, String attribute2,String attributeVal1,String attributeVal2,
			String attributeType1,String attributeType2,String field1,String field2,String field3) throws InterruptedException
	{
		HomePage homePage = getInstanceOfWebPages(HomePage.class);
		homePage.clickOnMenuSubSection(menu, subSection);
		getBasePage().waitForPage(200);
		homePage.switchtoFrame();
		homePage.selectMailTypeValues(mailType);
		homePage.clickOnToDirectory();
		
		homePage.clickOnGlobalTab();
		homePage.enterGroupName(groupName);
		homePage.enterFamilyName(familyName);
		homePage.clickOnSearch();
		homePage.selectReceipient("Kenton", "Tillman");
		
		homePage.clickOnRecipientOk();
		homePage.typeSubject(subject);
		homePage.clickOnAttribute(attribute1);
		homePage.selectAttributeValue(attribute1,attributeVal1);
		homePage.clickOnAddAttribute(attributeType1);
		homePage.selectAttributeValue(attribute2, attributeVal2);
		homePage.clickOnAddAttribute(attributeType2);
		homePage.clickOnOkBtn();
		homePage.clickOnSend();
		String receiver = homePage.verifyMailDetails(field1);
		String mailType1 = homePage.verifyMailDetails(field2);
		String sub = homePage.verifyMailDetails(field3);
		getSoftAssert().assertEquals(sub, subject, "Incorrect subject");
		getSoftAssert().assertEquals(mailType1, mailType, "Incorrect subject");
		getSoftAssert().assertTrue(receiver.contains("Kenton Tillman"), "Incorrect recipient");
		
		getSoftAssert().assertAll();
		
	}
	
	 @AfterTest
	    public void teardown() {
	        getDriver().quit();
	    }
}
