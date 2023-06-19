package com.selenium.automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//class for configuring excel file
public class Excel {
	public static String[] userData=new String[7];
    
    public static String[] readExcelData(String fileName) throws IOException{ 
    int i;
    FileInputStream file = new FileInputStream(fileName);
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet  = workbook.getSheetAt(0);
    
    for(i=0;i<7;i++){
        userData[i] = String.valueOf(sheet.getRow(1).getCell(i));
    }
    return userData;


    }
    public static String getExcelPath()  {
        String cwd = new File(System.getProperty("user.dir") + "ExcelData.xlsx").getAbsolutePath();
        return cwd;

	} 
	
}