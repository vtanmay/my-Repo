package com.automation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.base.WebDriverBaseTestpage;

public class DemoTestNGUtil extends WebDriverBaseTestpage {

	public DemoTestNGUtil() {
	}

	/*
	 * Accepts webelement, wait for element to visible and click on the element
	 */
	public void clickOnElement(WebElement element) {
		waitForPresent(element);
		element.click();
	}

	/*
	 * Accepts webelement and wait until the element is visible
	 */
	public void waitForPresent(WebElement element) {
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public DemoTestNGUtil getCommonUtilInstance() {
		DemoTestNGUtil commonUtil = new DemoTestNGUtil();
		return commonUtil;
	}

	public Object[][] getDateFromExcel() {
		HSSFWorkbook hssfWorkbook = null;
		HSSFSheet hssfSheet = null;
		HSSFRow row = null;
		HSSFCell cell = null;
		String[][] dataToReturn = null;
		String path = "./testData/getLodinCreds.xls";

		try {
			hssfWorkbook = new HSSFWorkbook(new FileInputStream(new File(path)));
			hssfSheet = hssfWorkbook.getSheetAt(0);
			System.out.println(hssfSheet.getSheetName());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(hssfSheet.getLastRowNum());
		
		dataToReturn = new String[hssfSheet.getLastRowNum()][2];
		
		for(int i=1;i<=hssfSheet.getLastRowNum();i++) {
			System.out.println(hssfSheet.getRow(i).getCell(0) +" "+ hssfSheet.getRow(i).getCell(1));
			dataToReturn[i-1][0] = hssfSheet.getRow(i).getCell(0).getStringCellValue();
			dataToReturn[i-1][1] = hssfSheet.getRow(i).getCell(1).getStringCellValue();
			
		}
		return dataToReturn;
		

		
	}
	
	public static void main(String[] args) {
		Object[][] test =  new DemoTestNGUtil().getDateFromExcel();
		System.out.println(test);
	}

}
