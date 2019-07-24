package workflow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MapWorkflow {
	
	public void putDataInExcel(LinkedHashMap<String, LinkedList<String>> completeData) throws IOException{
		String path = System.getProperty("user.dir");
		FileInputStream file = new FileInputStream(path+"\\BriqExcel.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(file);
		Sheet sheet = wb.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		
		for(String heading: completeData.keySet()){
			Row row = sheet.createRow(++lastRow);
			int cellid = 0;
			Cell cell = row.createCell(cellid);
			cell.setCellValue(heading);
			LinkedList<String> list = (LinkedList<String>) completeData.get(heading);
			for(String k: list){
				Cell cell2 = row.createCell(++cellid);
				cell2.setCellValue(k);
			}
		}
		file.close();
		FileOutputStream out = new FileOutputStream(
		         new File("A:\\Study\\BriqExcel.xlsx"));
		
		wb.write(out);
		out.close();      
	}
}
