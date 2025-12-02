package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static FileInputStream f; // in-built class to read data from the file
	static XSSFWorkbook wb; // in-built class to read data from the workbook
	static XSSFSheet sh; // in-built class to read data from the sheet

	public static String getStringData(int a, int b, String sheet) throws IOException {
		f = new FileInputStream(
				"C:\\Users\\VISMAYA ARAVIND\\eclipse-workspace\\GrocceryApplication1\\src\\test\\resources\\TextData.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		XSSFRow r = sh.getRow(a);
		XSSFCell c = r.getCell(b);
		return c.getStringCellValue();

	}

	public static String getFloatData(int a, int b, String sheet) throws IOException {
		f = new FileInputStream(
				"C:\\Users\\VISMAYA ARAVIND\\eclipse-workspace\\GrocceryApplication1\\src\\test\\resources\\TextData.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		XSSFRow r = sh.getRow(a);
		XSSFCell c = r.getCell(b);
		float x = (float) c.getNumericCellValue(); // to get the number from the cell
		return String.valueOf(x);
	}

	public static String getIntegerData(int a, int b, String sheet) throws IOException {
		f = new FileInputStream(
				"C:\\Users\\VISMAYA ARAVIND\\eclipse-workspace\\GrocceryApplication1\\src\\test\\resources\\TextData.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		XSSFRow r = sh.getRow(a);
		XSSFCell c = r.getCell(b);
		int x = (int) c.getNumericCellValue(); // to get the number from the cell // int koduthekkunne type casting ahnn
		return String.valueOf(x); // it is a type convertion like one datatype to String
	}

	public static String getStringDetails(int a, int b, String sheet) throws IOException {
		f = new FileInputStream(
				"C:\\Users\\VISMAYA ARAVIND\\eclipse-workspace\\GrocceryApplication1\\src\\test\\resources\\TextData.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		XSSFRow r = sh.getRow(a);
		XSSFCell c = r.getCell(b);
		return c.getStringCellValue();

		// TODO Auto-generated method stub
	}
}
