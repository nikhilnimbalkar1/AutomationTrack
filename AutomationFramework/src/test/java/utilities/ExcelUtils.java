package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseFrameWork.Base;
import config.ConstantsFile;

public class ExcelUtils extends Base{
	
	Sheet testSheet;
	Workbook wb;
	public ExcelUtils() {
		
		try {
			FileInputStream fip = new FileInputStream(readProperty(ConstantsFile.TestDataPath));
			wb = new XSSFWorkbook(fip);
			testSheet = wb.getSheetAt(0);
		} catch (FileNotFoundException e) {
			System.out.println("Could Not Find TestData-"+e.getMessage());
		} catch (IOException e) {
			System.out.println("Could Not Load TestData-"+e.getMessage());
		}
	}
}
	

