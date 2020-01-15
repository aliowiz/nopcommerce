package com.nopCommerceAutomation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.nopCommerceAutomation.base.BaseTest;


public class TestUtil extends BaseTest{
	
	public static long PAGELOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 15;
	public static String TESTDATA_SHEET_PATH = "C:\\study-java\\nopcommerceAutomation\\src\\test\\resources\\com\\nopcommerce\\testdata\\testdata1.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			// Excel file hierarchy :  Excel File >> Excel Workbook >> Excel Sheet >> Excel Row >> Excel Column >> Excel Cell 
			// creating connection to excel file using FileInputStream class
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// opening excel workbook
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// opening active work sheet
		sheet = book.getSheet(sheetName);
		// accessing cell data using for loop
		// create two dimensional array using row count and column count
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		//returns two dimensional array object that assigned to reference variable data
		return data;
	}
	
	public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
		
}
