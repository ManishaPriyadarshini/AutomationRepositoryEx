package com.aconex.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aconex.base.utils.BasePage;

public class HomePage extends BasePage {

	private final By mailTypeDD = By.xpath(
			"//table[@id='typeSection']//tbody//descendant::tr//td[2]//select[contains(@id,'correspondenceTypeID')]");
	By mailFrame = By.xpath("//iframe[@id='frameMain']");
	By toDirectory = By.xpath("//*[@id='lblTo']//..//following-sibling::td//div[contains(text(),'Directory')]");
	By attributePopuplabel = By.xpath("//span[contains(text(),'Select Attributes')]");
	By okBtnAttribute = By.xpath("//button[@id='attributePanel-commit']");
	By globalTab = By.xpath("//*[@id='ACONEX_list']");
	By groupName = By.xpath("//*[@id='FIRST_NAME']");
	By familyName = By.xpath("//*[@id='LAST_NAME']");
	By searchBtn = By.xpath("//div[@class='uiButton-label' and contains(text(),'Search')]");
	By toRecipientntn = By.xpath("//div[@id='searchResultsToolbar']//button[@id='btnAddTo_page']");
	By clickOnOkRecipient = By.xpath("//div[contains(@class,'uiButton-label') and contains(text(),'OK')]");
	By uploadDocText = By.xpath("//div//h1[contains(text(),'Upload Document')]");
	By revisionNumtxtbox = By.xpath("//input[@name='revision_0']");
	By sendBtn = By.xpath("//button[@id='btnSend']");
	By documentNumTxtbox = By.xpath("//input[@id='docno_0']");
	By titleTxtbox = By.xpath("//input[@name='title_0']");
	By docTypeDD = By.xpath("//*[@id='doctype_0']");
	By docStatusDD = By.xpath("//*[@id='docstatus_0']");
	By docDisciplineDD = By.xpath("//*[@id='discipline_0']");
	By selectCalendar = By.xpath("//*[@id='revisiondate_0_da']");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage clickOnMenus(String menu) {
		String uniqueXpath = "//div[@class='navBar']";
		switch (menu) {
		case "TASK":
			waitForElementPresence(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			safeClick(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			waitForPage(20);
			log("Clicked on Task menu");
			break;
		case "DOC":
			waitForElementPresence(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			safeClick(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			waitForPage(20);
			log("Clicked on Document menu");
			break;
		case "CORRESPONDENCE":
			waitForElementPresence(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			safeClick(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			waitForPage(20);
			log("Clicked on Mail menu");
			break;
		case "TENDERS":
			waitForElementPresence(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			safeClick(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));

			waitForPage(20);
			log("Clicked on Tenders menu");
			break;
		case "WORKFLOW":
			waitForElementPresence(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			safeClick(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			waitForPage(20);
			log("Clicked on Workflow menu");
			break;

		case "SUPPLIERDOCS":
			waitForElementPresence(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			safeClick(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			waitForPage(20);
			log("Clicked on Supplier doc menu");
			break;
		case "DIR":
			waitForElementPresence(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			safeClick(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			waitForPage(20);
			log("Clicked on Directory menu");
			break;
		case "REPORTING":
			waitForElementPresence(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			safeClick(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			waitForPage(20);
			log("Clicked on Reporting menu");
			break;
		case "SETUP":
			waitForElementPresence(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			safeClick(By.xpath(uniqueXpath + "//button[contains(@id,'" + menu + "')]"));
			waitForPage(20);
			log("Clicked on Setup menu");
			break;
		}
		return this;
	}

	public HomePage clickOnMenuSubSection(String menu, String subSection) {
		clickOnMenus(menu);
		if (menu.equals("CORRESPONDENCE")) {
			switch (subSection) {
			case "CREATEMAIL":
				waitForElementPresence(
						By.xpath("//div[contains(@class,'navBarPanel')]//div[contains(@id,'" + subSection + "')]"));
				safeClick(By.xpath("//div[contains(@class,'navBarPanel')]//div[contains(@id,'" + subSection + "')]"));
				log("Clicked on blank mail ");
				waitForPage(10);
				break;

			}
		} else if (menu.equals("DOC")) {
			switch (subSection) {
			case "DOC-SEARCH":
				waitForElementPresence(
						By.xpath("//div[contains(@class,'navBarPanel')]//div[contains(@id,'" + subSection + "')]"));
				safeClick(By.xpath("//div[contains(@class,'navBarPanel')]//div[contains(@id,'" + subSection + "')]"));
				log("Clicked on Document Register ");
				waitForPage(10);
				break;

			case "DOC-NEW":
				waitForElementPresence(
						By.xpath("//div[contains(@class,'navBarPanel')]//div[contains(@id,'" + subSection + "')]"));
				safeClick(By.xpath("//div[contains(@class,'navBarPanel')]//div[contains(@id,'" + subSection + "')]"));
				log("Clicked on Upload Document ");
				waitForPage(10);
				break;
			}
		}

		return this;
	}

	public HomePage selectMailTypeValues(String type) {
		log("selecting mail type.");
		selectDD(mailTypeDD).selectByVisibleText(type);
		waitForPage(30);
		log("selected mail type");

		return this;
	}

	public List<String> getListOfMailTypes()

	{
		log("Getting mail type list from dropdown..");
		List<String> val = new ArrayList<String>();
		List<WebElement> mailTypeList = selectDD(mailTypeDD).getOptions();
		for (WebElement el : mailTypeList) {
			val.add(el.getText());
		}
		return val;

	}

	public HomePage switchtoFrame() {
		switchToIframe(mailFrame);
		return this;
	}

	public HomePage clickOnAttribute(String attribute) {
		log("Clicking on Attribute");
		By attributeDD = By.xpath("//*[@id='attributesBody']//label[contains(text(),'" + attribute
				+ "')]//..//following-sibling::td//div[contains(@class,'ic-multiselect')]");
		safeClick(attributeDD);
		return this;
	}

	public boolean verifyAttributePopup() {
		log("verifying attribute pop is opened or not.");
		return (isElementPresent(attributePopuplabel));

	}

	public HomePage selectAttributeValue(String attribute, String val) {

		log("selecting attribute");
		By searchBox = By.xpath("//span[contains(text(),'" + attribute
				+ "')]//..//following-sibling::div//input[contains(@class,'uiTextField-input')]");

		safeType(searchBox, val);
		By selectAttr = By.xpath("//span[contains(text(),'" + attribute
				+ "')]//..//following-sibling::select//option[@value='" + val + "']");
		safeClick(selectAttr);
		return this;
	}

	public HomePage clickOnAddAttribute(String type) {
		switch (type) {
		case "PRIMARY":
			safeClick(By.xpath("//button[contains(@id,'PRIMARY_ATTRIBUTE_add')]"));
			log("clicked on primary add");
			break;
		case "SECONDARY":
			safeClick(By.xpath("//button[contains(@id,'SECONDARY_ATTRIBUTE_add')]"));
			log("clicked on secondary add");
			break;
		case "THIRD":
			safeClick(By.xpath("//button[contains(@id,'THIRD_ATTRIBUTE_add')]"));
			log("clicked on third add");
			break;
		case "FOURTH":
			safeClick(By.xpath("//button[contains(@id,'PRIMARY_ATTRIBUTE_add')]"));
			log("clicked on fourth add");
			break;

		}
		return this;
	}

	public HomePage clickOnOkBtn() {
		waitForElementPresence(okBtnAttribute);
		click(okBtnAttribute);
		log("Clicked on OK button");
		waitForPage(10);
		return this;
	}

	public HomePage typeSubject(String text) {
		log("Entering subject name");
		By textbox = By.xpath("//input[@id='Correspondence_subject']");
		safeType(textbox, text);
		waitForPage(10);
		return this;
	}

	public HomePage clickOnGlobalTab() {
		log("clicking on global tab");
		waitForElementPresence(globalTab, 10);
		click(globalTab);
		log("clicked on global tab");
		return this;
	}

	public HomePage enterGroupName(String grpName) {
		log("Entering on group name");
		safeType(groupName, grpName);
		return this;
	}

	public HomePage enterFamilyName(String famName) {
		log("Entering on family name");
		safeType(familyName, famName);
		return this;
	}

	public HomePage clickOnSearch() {
		waitForElementPresence(searchBtn, 10);
		click(searchBtn);
		waitForPage(20);
		return this;
	}

	public HomePage selectReceipient(String grpName, String famName) {
		log("selecting the recipient");
		By checkbox = By.xpath("//a[contains(text(),'" + grpName + "') and contains(text(),'" + famName
				+ "')]//..//preceding-sibling::td//input[@type='checkbox']");
		safeClick(checkbox);
		clickOnToRecipient();
		return this;
	}

	public HomePage clickOnToRecipient() {
		safeClick(toRecipientntn);
		return this;
	}

	public HomePage clickOnRecipientOk() {
		safeClick(clickOnOkRecipient);
		waitForPage(20);
		return this;
	}

	public HomePage clickOnSend() {
		safeClick(sendBtn);
		waitForPage(20);
		return this;
	}

	public String verifyMailDetails(String field) {
		log("Verifying mail details");
		String res = null;
		switch (field) {
		case "To":
			log("Getting Recipient's Name..");
			res = (driver.findElement(By.xpath("//*[@user='recipient.user']//span//span")).getText().trim());
			break;
		case "Subject":
			log("Getting Subject..");
			res = (driver.findElement(By.xpath("//*[@class='mailHeader-subject']//span")).getText().trim());
			break;

		case "MailType":
			log("Getting Mail Type..");
			res = (driver.findElement(By.xpath("//*[@class='mailHeader-value']//span")).getText().trim());
			break;

		}
		return res;
	}

	public HomePage clickOnToDirectory() {
		safeClick(toDirectory);
		waitForPage(20);
		return this;
	}

	public boolean verifyUploadDocScreen() {
		return isElementPresent(uploadDocText);
	}

	public HomePage enterDocNumber(String num) {
		safeType(documentNumTxtbox, num);
		waitForPage(10);
		log("Entered Document Number.");
		return this;
	}

	public HomePage enterRevisionNumber(String revnum) {
		safeType(revisionNumtxtbox, revnum);
		waitForPage(10);
		log("Entered Revision Number.");
		return this;
	}

	public HomePage enterTitle(String title) {
		safeType(titleTxtbox, title);
		waitForPage(10);
		log("Entered Title.");
		return this;
	}

	public HomePage selectDocType(String doctype)

	{
		selectDD(docTypeDD).selectByVisibleText(doctype);
		waitForPage(30);
		log("selected Document type.");

		return this;
	}

	public HomePage selectDocStatus(String docstat)

	{
		selectDD(docStatusDD).selectByVisibleText(docstat);
		waitForPage(30);
		log("selected Document Status.");

		return this;
	}

	public HomePage selectDocDiscipline(String disc)

	{
		selectDD(docDisciplineDD).selectByVisibleText(disc);
		waitForPage(30);
		log("selected Document Discipline.");

		return this;
	}

	public HomePage enterCalendar(String date)

	{
		safeType(selectCalendar, date);
		tabOutFromField(selectCalendar);
		log("entered dates.");

		return this;
	}

	public HomePage clickOnUploadBtn() {
		safeClick(By.xpath("//*[@id='btnUploadDocument']"));
		waitForPage(10);
		log("Clicked on Upload button..");
		return this;
	}

	public boolean verifyUploadSuccess() {

		return isElementPresent(By.xpath("Uploaded Successfully"));

	}

	public HomePage clickOnCloseUploadPopup() {
		safeClick(By.xpath("//button[@id='regSuccessPanel-cancel']"));
		waitForPage(20);
		log("Pop up closed");
		return this;
	}

	public HomePage switchtoDefaultScreen() {
		switchToDefault();
		return this;
	}

	public HomePage searchDocument(String searchtxt) {
		By searchDoc = By.xpath("//input[@id='search-keywords-id']");
		safeClear(searchDoc);
		safeType(searchDoc, searchtxt);
		return this;
	}

	public HomePage clickOnSearchDocBtn() {

		safeClick(By.xpath("//div[@id='search-keywords']//following-sibling::div//*[@ng-click='search()']"));
		waitForPage(30);
		log("Clicked on Search button.");
		return this;
	}

	public HomePage clickOnSaveSearchDocBtn() {

		safeClick(By.xpath(
				"//div[@id='search-keywords']//following-sibling::div//*[contains(@title,'Save the current search')]"));
		waitForPage(10);
		log("Clicked on Save Search button.");
		return this;
	}

	public HomePage selectDocumentFromSearch(String docName) {
		By checkbox = By.xpath("//div[contains(@class,'resultsGrid')]//div[contains(text(),'" + docName
				+ "')]//..//parent::div//span[contains(@class,'checkbox-unchecked')]");
		scrollIntoView(checkbox);
		safeClick(checkbox);
		clickOnSaveSearchDocBtn();
		return this;
	}

	public HomePage enterDetailsInSaveSearchPopup(String name, String desc) {
		log("Entering details of name to search");
		if (name != null) {
			By namebox = By.xpath("//*[contains(@id,'create-saved-search')]//div//input[@ng-model='details.title']");
			safeType(namebox, name);
		}
		if (desc != null) {
			By descBox = By.xpath("//*[contains(@id,'create-saved-search')]//div//*[@ng-model='details.description']");
			safeType(descBox, desc);
		}
		return this;
	}

	public HomePage clickOnSaveSearchPopUp() {
		By saveBtnpop = By.xpath("//*[contains(@id,'create-saved-search')]//div//input[@type='submit']");
		waitForElementPresence(saveBtnpop);
		safeClick(saveBtnpop);
		return this;
	}

	public HomePage openSavedSearchFromlist() {
		By savedList = By.xpath("//div[@id='angularSavedSearch']//*[@id='savedSearchButton']");
		waitForElementPresence(savedList);
		click(savedList);
		log("opened saved name");
		return this;
	}

	public HomePage enterSavedNameInpopup(String name) {
		log("Entering saved name");
		By searchtxt = By.xpath("//div[@id='angularSavedSearch']//*[@ng-model='savedSearchListItem.name']");
		safeType(searchtxt, name);
		By clickItm = By.xpath(
				"//div[@id='angularSavedSearch']//*[@ng-bind='savedSearchListItem.name' and text()='" + name + "']");
		safeClick(clickItm);
		waitForPage(20);
		return this;

	}

	public boolean verifySavedName(String name) {
		By searchtxt = By.xpath("//div[@id='angularSavedSearch']//*[@ng-model='savedSearchListItem.name']");
		safeType(searchtxt, name);
		By clickItm = By.xpath(
				"//div[@id='angularSavedSearch']//*[@ng-bind='savedSearchListItem.name' and text()='" + name + "']");
		return isElementPresent(clickItm);

	}

	public String verifyDocumentDetails(String field, String docNum) {
		log("verifying document details");
		String res = null;
		switch (field) {
		case "Title":
			log("Getting Document Name..");
			res = (driver.findElement(By.xpath("//div[contains(@class,'resultsGrid')]//div[contains(text(),'" + docNum
					+ "')]//ancestor::div//div[@ref='eCenterContainer']//div//a")).getText().trim());
			break;
		case "DocNumber":
			log("Getting Cocument Number..");
			res = (driver.findElement(By.xpath("//div[contains(@class,'resultsGrid')]//div[contains(text(),'" + docNum
					+ "')]//..//parent::div//*[@col-id='docno']")).getText().trim());
			break;

		}
		return res;
	}

	public HomePage enterDocumentDetails(String num, String revnum, String title, String doctype, String docstat,
			String disc, String date) {
		log("Entering details of document..");
		if (num != null) {
			enterDocNumber(num);
			waitForPage(10);
		}
		if (revnum != null) {
			enterRevisionNumber(revnum);
			waitForPage(10);
		}

		if (title != null) {
			enterTitle(title);
			waitForPage(10);
		}
		if (doctype != null) {
			selectDocType(doctype);
			waitForPage(10);
		}
		if (docstat != null) {
			selectDocStatus(docstat);
			waitForPage(10);
		}
		if (disc != null) {
			selectDocDiscipline(disc);
			waitForPage(10);
		}
		if (date != null) {
			enterCalendar(date);
			waitForPage(10);
		}
		return this;
	}

}
