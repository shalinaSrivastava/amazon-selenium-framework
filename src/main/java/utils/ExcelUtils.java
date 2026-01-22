package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtils {
	@DataProvider
	public Object[][] dataFromExcel() throws EncryptedDocumentException, IOException{
		Object[][] loginCredential = new Object[5][2];
		FileInputStream fis = new FileInputStream("C:\\Users\\sharm\\eclipse-workspace\\Project1\\LoginCredentialExcelSheet\\LoginData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String username = wb.getSheet("login").getRow(1).getCell(0).getStringCellValue();
		String password = wb.getSheet("login").getRow(1).getCell(0).getStringCellValue();
		loginCredential[0][0]=username;
		loginCredential[1][1]=password;
		return loginCredential;
	}
}
