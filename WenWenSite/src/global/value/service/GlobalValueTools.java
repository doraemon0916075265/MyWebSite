package global.value.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GlobalValueTools {
	/** 輸出字串 **/
	private final String EMPTY_WORD = "";
	/** Excel **/
	private final String FILE_EXCEL_PATH = "C:/Users/user/Desktop/";
	private final String FILE_EXCEL_NAME = "TimeSheet";
	private final String FILE_EXCEL_NAME_EXTENSION = ".xls";
	private final String FILE_CREATE_EXCEL_FULL_NAME = FILE_EXCEL_PATH + FILE_EXCEL_NAME + FILE_EXCEL_NAME_EXTENSION;
	/** Sheet **/
	private final String EXCEL_SHEET01_NAME = "月曆";
	/** Table **/
	private final String[] EXCEL_SHEET01_TABLE_HEADER = { "月曆" };
	private final int EXCEL_SHEET01_TABLE_HEADER_HEIGHT = 1;
	private final String[] EXCEL_SHEET01_TABLE_TITLE = { "日期", "星期", "備註" };
	private final int EXCEL_SHEET01_TABLE_ABOVE_TITLE_HEIGHT = 8;
	private final int EXCEL_SHEET01_TABLE_TITLE_SIZE = EXCEL_SHEET01_TABLE_TITLE.length;

	/** 輸入年跟月，回傳當月的每一天 **/
	public List<String> turnYearMonthToDay(int year, int month) {
		List<String> result = new ArrayList<String>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E");

		Calendar monthDate = Calendar.getInstance();

		monthDate.set(year, month - 1, 1);

		int maxDate = monthDate.getActualMaximum(Calendar.DATE);

		for (int day = 1; day <= maxDate; day++) {
			monthDate.set(year, month - 1, day);
			Date everyDay = monthDate.getTime();
			result.add(sdf.format(everyDay));
		}

		result.add("" + maxDate);

		return result;
	}

	public String getEMPTY_WORD() {
		return EMPTY_WORD;
	}

	public String getFILE_EXCEL_PATH() {
		return FILE_EXCEL_PATH;
	}

	public String getFILE_EXCEL_NAME() {
		return FILE_EXCEL_NAME;
	}

	public String getFILE_EXCEL_NAME_EXTENSION() {
		return FILE_EXCEL_NAME_EXTENSION;
	}

	public String getFILE_CREATE_EXCEL_FULL_NAME() {
		return FILE_CREATE_EXCEL_FULL_NAME;
	}

	public String getEXCEL_SHEET01_NAME() {
		return EXCEL_SHEET01_NAME;
	}

	public String[] getEXCEL_SHEET01_TABLE_HEADER() {
		return EXCEL_SHEET01_TABLE_HEADER;
	}

	public int getEXCEL_SHEET01_TABLE_HEADER_HEIGHT() {
		return EXCEL_SHEET01_TABLE_HEADER_HEIGHT;
	}

	public String[] getEXCEL_SHEET01_TABLE_TITLE() {
		return EXCEL_SHEET01_TABLE_TITLE;
	}

	public int getEXCEL_SHEET01_TABLE_TITLE_SIZE() {
		return EXCEL_SHEET01_TABLE_TITLE_SIZE;
	}

	public int getEXCEL_SHEET01_TABLE_ABOVE_TITLE_HEIGHT() {
		return EXCEL_SHEET01_TABLE_ABOVE_TITLE_HEIGHT;
	}

}
