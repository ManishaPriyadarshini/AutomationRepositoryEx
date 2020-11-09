package com.aconex.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aconex.DataProvider.AconexDataProvider;
import com.aconex.pages.HomePage;
import com.aconex.pages.LoginPage;

public class DocumentUploadTest extends BaseTest {

	@BeforeTest
    public void beforeTest() {
		launchApplication();
        getInstanceOfWebPages(LoginPage.class).loginApplicationDiffUser();
    }
	
	@Test(dataProviderClass = AconexDataProvider.class, dataProvider= "DocumentUpload")
	public void documentUploadtest(String menu, String subSection,String docNum,String title,String rev,String docType,String status, String discipline,
			String date, String subSection2, String saveTitle) throws InterruptedException
	{
		HomePage homePage = getInstanceOfWebPages(HomePage.class);
		String docNumber = getBasePage().getRandomNumber();
		String newSaveTitle = saveTitle + getBasePage().getRandomNumber();
		homePage.clickOnMenuSubSection(menu, subSection);
		homePage.switchtoFrame();
		boolean status1 = homePage.verifyUploadDocScreen();
		getSoftAssert().assertTrue(status1, "Upload Document screen not opened..");
		homePage.enterDocumentDetails(docNumber,rev,title,docType,status,discipline,date);
		homePage.clickOnUploadBtn();
		homePage.clickOnCloseUploadPopup();
		homePage.switchtoDefaultScreen();
		homePage.clickOnMenuSubSection(menu, subSection2);
		homePage.switchtoFrame();
		homePage.searchDocument(docNumber);
		homePage.clickOnSearchDocBtn();
		homePage.selectDocumentFromSearch(docNumber);
		homePage.enterDetailsInSaveSearchPopup(newSaveTitle, "");
		homePage.clickOnSaveSearchPopUp();
		homePage.openSavedSearchFromlist();
		boolean val = homePage.verifySavedName(newSaveTitle);
		getSoftAssert().assertTrue(val, "Saved Document not presennt!");
		homePage.enterSavedNameInpopup(newSaveTitle);
		homePage.searchDocument(docNumber);
		String actualtitle = homePage.verifyDocumentDetails("Title", docNumber);
		String actualNum = homePage.verifyDocumentDetails("DocNumber", docNumber);
		getSoftAssert().assertEquals(actualtitle, title, "Document title mismatch!");
		getSoftAssert().assertEquals(actualNum, docNumber, "Document number mismatch!");
		getSoftAssert().assertAll();
			
	}

	 @AfterTest
	    public void teardown() {
	        getDriver().quit();
	    }
}
