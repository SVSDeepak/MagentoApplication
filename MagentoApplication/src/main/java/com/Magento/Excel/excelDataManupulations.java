package com.Magento.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDataManupulations {
	
	/*
	 * Method for reading data in excelfile
	 */
	
	public static List<List<String>> datFromExcel(String excelFilePath,int sheetNo)  {
		List<List<String>> credentials=null;
		try {
		credentials = new ArrayList<>();
		FileInputStream file = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(sheetNo);
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			List<String> rowData = new ArrayList<>();
			if(row!=null) {
				for(int j=0;j<row.getLastCellNum();j++) {
					Cell cell=row.getCell(j);
					if(cell!=null) {
						try {
						rowData.add(cell.getStringCellValue());
						}catch(Exception e)
						{
							rowData.add(String.valueOf((int)cell.getNumericCellValue()));
						}
					}else {
						rowData.add("");
					}
				}
			}
		credentials.add(rowData);
		}
	workbook.close();
	
	}
	catch(Exception E)
	{
		System.out.println("Exception in dataFromExcel method : "+E);
	}
		return credentials;
	}
}
