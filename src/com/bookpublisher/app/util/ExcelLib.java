package com.bookpublisher.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bookpublisher.app.dto.FilePropertiseDTO;

public class ExcelLib implements Constants {
	public void writeToExcel(List<FilePropertiseDTO> list) {
		// Blank workbook
		System.out.println("// Blank workbook   :)");
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet(Constants.sheetName);
		// This data needs to be written (Object[])
		int key = 1;
		Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
		for (FilePropertiseDTO filePropertise : list) {
			if (key <=1) {
				data.put(0, new Object[] { "filePropertise ID", "CREATE AT DATE","File Name", "File Location", "FILE SIZE" });
				data.put(key, new Object[] { filePropertise.getId(), filePropertise.getFdate(),filePropertise.getFname(), filePropertise.getFlocation(), filePropertise.getFsize()});
				key++;
			} else {
				data.put(key, new Object[] { filePropertise.getId(), filePropertise.getFdate(),filePropertise.getFname(), filePropertise.getFlocation(), filePropertise.getFsize()});
				key++;
			}
		}
		// Iterate over data and write to sheet
		Set<Integer> keyset = data.keySet(); 
		int rownum = 0;
		for (Integer key1 : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key1);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		
		try {
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File("E://SERVERLOC//"+fileName + ".xlsx"));
			workbook.write(out);
			out.close();
			System.out.println(Constants.fileName + ".xlsx written successfully Create Prroject ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
