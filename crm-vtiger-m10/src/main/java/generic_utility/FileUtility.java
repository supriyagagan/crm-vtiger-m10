package generic_utility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {
	public static String getDataFromJsonFile(String key) throws IOException, ParseException {
	FileReader Fr = new FileReader("./src/test/resources/cd.json");
	JSONParser parser = new JSONParser();
	Object obj = parser.parse(Fr);
	JSONObject jObj = (JSONObject) obj;
	String value = jObj.get(key).toString();
	return value;
	}
	
	public static String getDataFromExcelFile(String sheetName, int rowIndex, int cellIndex ) throws IOException, ParseException {
	
		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData (1).xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row =  sh.getRow(3);
		Cell cell = row.getCell(0);
		String value = cell.getStringCellValue();
		return value;
	

}
}
