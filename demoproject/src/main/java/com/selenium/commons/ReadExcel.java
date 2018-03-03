package com.selenium.commons;

import java.io.File;

import jxl.BooleanCell;
import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {

	public String readData(String searchString) {

		Cell cell = null;
		String str = null;
		Sheet s = null;
		

		try {

			String filename = System.getProperty("user.dir") + "/src/test/resources/InputReader.xls";

			Workbook workbook = Workbook.getWorkbook(new File(filename));

			if (System.getProperty("EnvType") == null) {
				s = workbook.getSheet(0);

			} else if (System.getProperty("EnvType").equalsIgnoreCase("qa")) {
				s = workbook.getSheet(0);

			} else if (System.getProperty("EnvType").equalsIgnoreCase("dev")) {
				s = workbook.getSheet(1);

			}

			// confirms to look at sheet 0

			LabelCell lc = s.findLabelCell(searchString);
			int col = lc.getColumn();
			int row = lc.getRow();

			cell = s.getCell(++col, row);

			if (cell.getType() == CellType.LABEL) {

				LabelCell labelCell = (LabelCell) cell;
				str = labelCell.getContents();

			}

			else if (cell.getType() == CellType.NUMBER) {

				NumberCell numCell = (NumberCell) cell;
				str = numCell.getContents();

			}

			else if (cell.getType() == CellType.BOOLEAN) {

				BooleanCell boolcell = (BooleanCell) cell;
				str = boolcell.getContents();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return str;
	}

}