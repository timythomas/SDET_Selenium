package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	
	
	public static String readExcelData(int rowVal, int cellVal) throws IOException {
	File src=new File(System.getProperty("user.dir")+"\\src\\main\\resources\\util\\Data.xlsx");
	FileInputStream fis=new FileInputStream(src);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sh1= wb.getSheetAt(0);
	String val=new DataFormatter().formatCellValue(sh1.getRow(rowVal).getCell(cellVal));
	return val;
	 }
}
