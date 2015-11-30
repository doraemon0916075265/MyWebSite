package tools;

import java.io.File;
import java.io.IOException;
import java.util.List;

import global.value.service.GlobalValueTools;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class CreateExcelAgency {
	static GlobalValueTools GVT = new GlobalValueTools();
	/** 輸出字串 **/
	private static String EMPTY_WORD = GVT.getEMPTY_WORD();
	/** Excel **/
	private static String FILE_EXCEL_PATH = GVT.getFILE_EXCEL_PATH();
	private static String FILE_EXCEL_NAME_EXTENSION = GVT.getFILE_EXCEL_NAME_EXTENSION();
	/** Sheet **/
	private static String EXCEL_SHEET01_NAME = GVT.getEXCEL_SHEET01_NAME();
	/** Table **/
	private static String[] EXCEL_SHEET01_TABLE_HEADER = GVT.getEXCEL_SHEET01_TABLE_HEADER();
	private static int EXCEL_SHEET01_TABLE_HEADER_HEIGHT = GVT.getEXCEL_SHEET01_TABLE_HEADER_HEIGHT();
	private static String[] EXCEL_SHEET01_TABLE_TITLE = GVT.getEXCEL_SHEET01_TABLE_TITLE();
	private static int EXCEL_SHEET01_TABLE_ABOVE_TITLE_HEIGHT = GVT.getEXCEL_SHEET01_TABLE_ABOVE_TITLE_HEIGHT();
	private static int EXCEL_SHEET01_TABLE_TITLE_SIZE = GVT.getEXCEL_SHEET01_TABLE_TITLE_SIZE();

	public static void writeToExcel(String fileName, int year, int month) {

		try {
			List<String> thisMonth = GVT.turnYearMonthToDay(year, month);
			int thisMonthSize = thisMonth.size();

			String FILE_CREATE_EXCEL_FULL_NAME = FILE_EXCEL_PATH + fileName + FILE_EXCEL_NAME_EXTENSION;
			WritableWorkbook excel = Workbook.createWorkbook(new File(FILE_CREATE_EXCEL_FULL_NAME));
			WritableSheet excelSheet = excel.createSheet(EXCEL_SHEET01_NAME, 0);
			Label tab = new Label(0, 0, null);

			tab.setString(EXCEL_SHEET01_TABLE_HEADER[0]);
			excelSheet.addCell(tab.copyTo((int) (EXCEL_SHEET01_TABLE_TITLE_SIZE / 2), 0));

			for (int row = EXCEL_SHEET01_TABLE_ABOVE_TITLE_HEIGHT; row < EXCEL_SHEET01_TABLE_ABOVE_TITLE_HEIGHT + thisMonthSize; row++) {
				for (int column = 0; column < EXCEL_SHEET01_TABLE_TITLE_SIZE; column++) {
					// 寫日期
					String textTable = thisMonth.get(row - EXCEL_SHEET01_TABLE_ABOVE_TITLE_HEIGHT);
					if (column == 0) {
						tab.setString(textTable.substring(0, 10));
					} else if (column == 1) {
						tab.setString(textTable.substring(13, textTable.length()));
					} else {
						tab.setString(EMPTY_WORD);
					}
					excelSheet.addCell(tab.copyTo(column, row));
				}
			}
			excel.write();
			excel.close();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void start(String fileName, int year, int month) {
		List<String> thisMonth = GVT.turnYearMonthToDay(year, month);
		for (String string : thisMonth) {
			System.out.println(string);
		}
		writeToExcel(fileName, year, month);
	}
}
