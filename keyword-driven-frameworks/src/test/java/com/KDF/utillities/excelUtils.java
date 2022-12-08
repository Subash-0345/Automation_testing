package com.KDF.utillities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excelUtils {
	HSSFSheet sheet;
	FileInputStream file;
	HSSFWorkbook workbook;
	HSSFCell cell;
	public static String locatorColVal, locatorName, locatorValue;
	public static String keyWordColVal;
	public static String dataColVal;
	public static int lastRowVal;

	public void readFile(String location) throws IOException {
		file = new FileInputStream(location);
		workbook = new HSSFWorkbook(file);
		sheet = workbook.getSheetAt(0);
		lastRowVal = sheet.getLastRowNum();
	}

	public void getLocKeyAndData(int row, int locatorCol, int keyWordCol, int dataCol) {

		locatorColVal = sheet.getRow(row).getCell(locatorCol).toString().trim();

		if (!locatorColVal.contains("NA")) {
			locatorName = locatorColVal.split("=")[0].toString().trim();
			locatorValue = locatorColVal.split("=")[1].toString().trim();
		} else {
			locatorName = "NA";
			locatorValue = "NA";
		}

		keyWordColVal = sheet.getRow(row).getCell(keyWordCol).toString().trim();
		dataColVal = sheet.getRow(row).getCell(dataCol).toString().trim();
		System.out.println(locatorName + "  :  " + locatorValue + " : " + keyWordColVal + " : " + dataColVal);

	}

}
