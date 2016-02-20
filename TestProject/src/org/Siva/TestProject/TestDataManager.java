package org.Siva.TestProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Hashtable;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestDataManager {
	
	private String excelFilePath = "D:\\personal\\projects\\Java-Projects\\TestProject\\testData\\testData.xlsx";
	private Hashtable<String, String> excelTestData = new Hashtable<String, String>();
	private XSSFWorkbook wb;
	private HSSFWorkbook wb2;
   
	public Hashtable<String, String> getTestDataFromExcelFile() throws IOException {
		String fileName = this.excelFilePath;
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (fileExtension.equals("xlsx")) {
        	return this.readXLSXFile();
        } else if(fileExtension.equals("xls")){
        	return this.readXLSFile();
        } else {
        	return null;
        }
	}
	public List<String> getTestDataForTestCase(String testCaseId) throws IOException{
		Hashtable<String, String> testData = this.getTestDataFromExcelFile();
		String currentTestCaseData = testData.get(testCaseId);
		List<String> testDataList = new ArrayList<String>(Arrays.asList(currentTestCaseData.split(";")));
		return testDataList;
	}
	
	public Hashtable<String, String> readXLSFile() throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream(this.excelFilePath);
		wb2 = new HSSFWorkbook(ExcelFileToRead);
		HSSFSheet sheet=wb2.getSheetAt(0);
		HSSFRow row; 
		Iterator<Row> rows = sheet.rowIterator();

		while (rows.hasNext())
		{
			row=(HSSFRow) rows.next();
			if(row.getCell(0) != null && row.getCell(1) != null){
				this.excelTestData.put(row.getCell(0).toString(), row.getCell(1).toString());
			}			
		}
		return this.excelTestData;
	
	}
	
	public Hashtable<String, String> readXLSXFile() throws IOException
	{	
		InputStream ExcelFileToRead = new FileInputStream(this.excelFilePath);
		wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		Iterator<Row> rows = sheet.rowIterator();

		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			if(row.getCell(0) != null && row.getCell(1) != null){
				this.excelTestData.put(row.getCell(0).toString(), row.getCell(1).toString());
			}
		}
		return this.excelTestData;
	}

}
