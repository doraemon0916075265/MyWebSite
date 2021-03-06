//package tools;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Date;
//import java.util.List;
//
//import global.value.service.GlobalValueTools;
//import jxl.Workbook;
//import jxl.write.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//import jxl.write.biff.RowsExceededException;
//
//public class Excel2003TimeSheet {
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
//	public static void writeToExcel() {
//		List<String> listMonth = GVT.turnYearMonthToDay(2015, 2);
//
//		for (String string : listMonth) {
//			System.out.println(string);
//		}
//
//		int monthTurnDay = Integer.parseInt(listMonth.get(listMonth.size() - 1));
//
//		try {
//			WritableWorkbook excel = Workbook.createWorkbook(new File(FILE_CREATE_EXCEL_FULL_NAME));
//			WritableSheet excelSheet = excel.createSheet(EXCEL_SHEET_NAME1, 0);
//			Label tab = new Label(0, 0, null);
//
//			for (int column = 0; column < EXCEL_SHEET_TABLE_TITLE_SIZE; column++) {
//				int row = EXCEL_SHEET_TABLE_ABOVE_TITLE_HEIGHT;
//				tab.setString(EXCEL_SHEET_TABLE_TITLE[column]);
//				excelSheet.addCell(tab.copyTo(column, row));
//			}
//
//			for (int row = EXCEL_SHEET_TABLE_ABOVE_TITLE_HEIGHT + 1; row < EXCEL_SHEET_TABLE_ABOVE_TITLE_HEIGHT + 1 + monthTurnDay; row++) {
//				for (int column = 0; column < EXCEL_SHEET_TABLE_TITLE_SIZE; column++) {
//					String textTable = listMonth.get(row - EXCEL_SHEET_TABLE_ABOVE_TITLE_HEIGHT - 1);
//					if (column == 0) {
//						tab.setString(textTable.substring(0, 10));
//					} else if (column == 1) {
//						tab.setString(textTable.substring(13, textTable.length()));
//					} else if (column == 2) {
//						tab.setString(GET_ON_WORK_TIME);
//					} else if (column == 3) {
//						tab.setString(GET_OFF_WORK_TIME);
//					} else {
//						tab.setString(EMPTY_WORD);
//					}
//					excelSheet.addCell(tab.copyTo(column, row));
//				}
//			}
//			excel.write();
//			excel.close();
//		} catch (RowsExceededException e) {
//			e.printStackTrace();
//		} catch (WriteException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
