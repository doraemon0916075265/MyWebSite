//package tools;
//
//import java.io.File;
//import java.util.List;
//
//import global.value.service.GlobalValueTools;
//import jxl.Workbook;
//import jxl.write.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//
//public class CreateExcelAgency {
//	static GlobalValueTools GVT = new GlobalValueTools();
//	/** 輸出字串 **/
//	private static String EMPTY_WORD = GVT.getEMPTY_WORD();
//	/** Excel **/
//	private static String FILE_CREATE_EXCEL_FULL_NAME = GVT.getFILE_CREATE_EXCEL_FULL_NAME();
//	/** Sheet **/
//	private static String EXCEL_SHEET01_NAME = GVT.getEXCEL_SHEET01_NAME();
//	/** Table **/
//	private static String[] EXCEL_SHEET01_TABLE_HEADER = GVT.getEXCEL_SHEET01_TABLE_HEADER();
//	private static int EXCEL_SHEET01_TABLE_HEADER_HEIGHT = GVT.getEXCEL_SHEET01_TABLE_HEADER_HEIGHT();
//	private static String[] EXCEL_SHEET01_TABLE_TITLE = GVT.getEXCEL_SHEET01_TABLE_TITLE();
//	private static int EXCEL_SHEET01_TABLE_ABOVE_TITLE_HEIGHT = GVT.getEXCEL_SHEET01_TABLE_ABOVE_TITLE_HEIGHT();
//	private static int EXCEL_SHEET01_TABLE_TITLE_SIZE = GVT.getEXCEL_SHEET01_TABLE_TITLE_SIZE();
//
//	public static void writeToExcel(int year, int month) {
//
//		List<String> thisMonth = GVT.turnYearMonthToDay(year, month);
//		int thisMonthSize = thisMonth.size();
//		WritableWorkbook excel = Workbook.createWorkbook(new File(FILE_CREATE_EXCEL_FULL_NAME));
//		WritableSheet excelSheet = excel.createSheet(EXCEL_SHEET01_NAME, 0);
//		Label tab = new Label(0, 0, null);
//
//		for (int row = EXCEL_SHEET01_TABLE_ABOVE_TITLE_HEIGHT + 1; row < EXCEL_SHEET01_TABLE_ABOVE_TITLE_HEIGHT + 1 + monthTurnDay; row++) {
//			for (int column = 0; column < EXCEL_SHEET01_TABLE_TITLE_SIZE; column++) {
//				String textTable = thisMonth.get(row - EXCEL_SHEET_TABLE_ABOVE_TITLE_HEIGHT - 1);
//				if (column == 0) {
//					tab.setString(textTable.substring(0, 10));
//				} else if (column == 1) {
//					tab.setString(textTable.substring(13, textTable.length()));
//				} else {
//					tab.setString(EMPTY_WORD);
//				}
//				excelSheet.addCell(tab.copyTo(column, row));
//			}
//		}
//
//	}
//
//	public static void start(int year, int month) {
//		List<String> thisMonth = GVT.turnYearMonthToDay(year, month);
//		for (String string : thisMonth) {
//			System.out.println(string);
//		}
//
//		writeToExcel(year, month);
//
//	}
//}
