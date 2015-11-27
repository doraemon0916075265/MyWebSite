package tools;

import java.util.List;

import global.value.service.GlobalValueTools;

public class CreateExcelAgency {
	static GlobalValueTools GVT = new GlobalValueTools();
	/** 輸出字串 **/
	private static String EMPTY_WORD = GVT.getEMPTY_WORD();
	/** Excel **/
	private static String FILE_CREATE_EXCEL_FULL_NAME = GVT.getFILE_CREATE_EXCEL_FULL_NAME();
	/** Sheet **/
	private static String EXCEL_SHEET01_NAME = GVT.getEXCEL_SHEET01_NAME();
	/** Table **/
	private static String[] EXCEL_SHEET01_TABLE_HEADER = GVT.getEXCEL_SHEET01_TABLE_HEADER();
	private static int EXCEL_SHEET01_TABLE_HEADER_HEIGHT = GVT.getEXCEL_SHEET01_TABLE_HEADER_HEIGHT();
	private static String[] EXCEL_SHEET01_TABLE_TITLE = GVT.getEXCEL_SHEET01_TABLE_TITLE();
	private static int EXCEL_SHEET01_TABLE_ABOVE_TITLE_HEIGHT = GVT.getEXCEL_SHEET01_TABLE_ABOVE_TITLE_HEIGHT();
	private static int EXCEL_SHEET01_TABLE_TITLE_SIZE = GVT.getEXCEL_SHEET01_TABLE_TITLE_SIZE();

	public static void writeToExcel() {
	}

	public static void start(int year, int month) {
		List<String> listMonth = GVT.turnYearMonthToDay(year, month);
		for (String string : listMonth) {
			System.out.println(string);
		}
		writeToExcel();
	}
}
