package com.aconex.DataProvider;

import com.aconex.base.utils.ExcelUtilities;
import org.testng.annotations.DataProvider;
import java.io.File;


public class AconexDataProvider {
	
	@DataProvider(name = "EmailValidation")
	public static Object[][] EmailValidation() {
		final Object[][] objReturn = ExcelUtilities.getTableArray(System.getProperty("user.dir") + File.separator
				+ "TestData" + File.separator + "Test_Sheet.xls", "Test1",
				"EmailValidation");
		return objReturn;

	}

	@DataProvider(name = "DocumentUpload")
	public static Object[][] DocumentUpload() {
		final Object[][] objReturn = ExcelUtilities.getTableArray(System.getProperty("user.dir") + File.separator
				+ "TestData" + File.separator + "Test_Sheet.xls", "Test1",
				"DocumentUpload");
		return objReturn;

	}

}

