package com.abc.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import com.abc.model.Tutorial;
@Component
public class ExcelHelper {

	public static String type = "application/vnd.ms-excel";
	public String[] headers = { "id", "title", "description", "published" };
	static String sheet = "Turorial";

	public static List<Tutorial> excelToTutorial(InputStream inputStream) throws IOException {

		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);

		XSSFSheet sheet1 = xssfWorkbook.getSheet(sheet);

		Iterator<Row> rows = sheet1.iterator();

		ArrayList<Tutorial> tutorials = new ArrayList<>();

		int rowNum = 0;
		while (rows.hasNext()) {
			Row currentRow = rows.next();

			if (rowNum == 0) {
				rowNum++;
				continue;
			}

			Iterator<Cell> cellRow = currentRow.iterator();

			Tutorial tutorial = new Tutorial();

			int cellIndex = 0;

			while (cellRow.hasNext()) {
				Cell cell = (Cell) cellRow.next();

				switch (cellIndex) {
				case 0:
					tutorial.setId((int) cell.getNumericCellValue());
					break;

				case 1:
					tutorial.setTitle(cell.getStringCellValue());
					break;
				case 2:
					tutorial.setDescription(cell.getStringCellValue());
					break;
				case 3:
					tutorial.setPublished(cell.getBooleanCellValue());
					break;

				default:
					break;
				}
				cellIndex++;

			}
			tutorials.add(tutorial);
		}
		xssfWorkbook.close();

		return tutorials;

	}
}
