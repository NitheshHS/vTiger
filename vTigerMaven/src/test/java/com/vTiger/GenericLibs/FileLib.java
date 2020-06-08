package com.vTiger.GenericLibs;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String getCommonKeyValue(String value)
	{
		Properties prop = null;
		try {
			FileInputStream fi=new FileInputStream("./src\\test\\java\\commondata\\commondata.properties");
			prop=new Properties();
			prop.load(fi);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(value);
	}
	
	public String readDataInExcel(String sheetname, int rowNum, int cellnum) {
		Sheet sh = null;
		try {
			FileInputStream file =new FileInputStream("./src\\test\\java\\commondata\\ContactTest.xlsx");
			Workbook wb=WorkbookFactory.create(file);
			sh=wb.getSheet(sheetname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sh.getRow(rowNum).getCell(cellnum).getStringCellValue();
	}
	
	public Object[][] readAllDataFromExcel(String sheetName){
		Object[][] data=null;
		try {
			
			FileInputStream fil=new FileInputStream("./src\\test\\java\\commondata\\ContactTest.xlsx");
			Workbook wb=WorkbookFactory.create(fil);
			Sheet sh=wb.getSheet(sheetName);
			int rowCount=sh.getLastRowNum();
			int cellCount=sh.getRow(0).getLastCellNum();
			data=new Object[rowCount][cellCount];
			for(int i=0;i<rowCount;i++)
			{
				for(int j=0;j<cellCount;j++)
				{
					data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
		
	}
	
	
	}

