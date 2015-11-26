package global.value.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GlobalValueTools {
	private final String FILE_EXCEL_PATH = "C:/Users/user/Desktop/";
	private final String FILE_EXCEL_NAME = "TimeSheet";
	private final String FILE_EXCEL_NAME_EXTENSION = ".xls";
	private final String FILE_CREATE_EXCEL_FULL_NAME = FILE_EXCEL_PATH + FILE_EXCEL_NAME + FILE_EXCEL_NAME_EXTENSION;
	private final String EXCEL_SHEET_NAME = "FIRST SHEET";
	private final String EMPTY_WORD = "";
	private final String[] EXCEL_SHEET_TABLE_ABOVE_TITLE = { "公司名稱：緯德科技股份有限公司", "資料月份：", "姓名：" };
	private final String[] EXCEL_SHEET_TABLE_TITLE = { "出勤日期", "星期", "上班時間", "下班時間", "加班時數", "請假時數", "說明 (假日, 特休, 病假, 事假, 其他)" };
	private final int EXCEL_SHEET_TABLE_TITLE_SIZE = EXCEL_SHEET_TABLE_TITLE.length;
	private final int EXCEL_SHEET_TABLE_ABOVE_TITLE_HEIGHT = 8;
	private final String GET_ON_WORK_TIME = "9:00";
	private final String GET_OFF_WORK_TIME = "6:30";

	/** 測試用 **/
	private final int WRITE_YEAR = 2015;
	private final int WRITE_MONTH = 11;

	public List<String> turnYearMonthToDay(int year, int month) {
		List<String> result = new ArrayList<String>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E");

		Calendar monthDate = Calendar.getInstance();

		monthDate.set(year, month - 1, 1);
		Date startMonthDate = monthDate.getTime();
		// result.add(sdf.format(startMonthDate));
		long startMonth = startMonthDate.getTime();

		monthDate.set(year, month, 0);
		Date endMonthDate = monthDate.getTime();
		// result.add(sdf.format(endMonthDate));
		long endMonth = endMonthDate.getTime();

		long oneDayTime = 1000 * 3600 * 24; // A day in milliseconds

		int monthTurnDay = (int) (((endMonth - startMonth) / oneDayTime) + 1);

		for (int day = 1; day <= monthTurnDay; day++) {
			monthDate.set(year, month - 1, day);
			Date everyDay = monthDate.getTime();
			result.add(sdf.format(everyDay));
		}

		result.add("" + monthTurnDay);

		return result;
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

	public String getEXCEL_SHEET_NAME() {
		return EXCEL_SHEET_NAME;
	}

	public int getWRITE_YEAR() {
		return WRITE_YEAR;
	}

	public int getWRITE_MONTH() {
		return WRITE_MONTH;
	}

	public String getEMPTY_WORD() {
		return EMPTY_WORD;
	}

	public String[] getEXCEL_SHEET_TABLE_ABOVE_TITLE() {
		return EXCEL_SHEET_TABLE_ABOVE_TITLE;
	}

	public String[] getEXCEL_SHEET_TABLE_TITLE() {
		return EXCEL_SHEET_TABLE_TITLE;
	}

	public int getEXCEL_SHEET_TABLE_TITLE_SIZE() {
		return EXCEL_SHEET_TABLE_TITLE_SIZE;
	}

	public int getEXCEL_SHEET_TABLE_ABOVE_TITLE_HEIGHT() {
		return EXCEL_SHEET_TABLE_ABOVE_TITLE_HEIGHT;
	}

	public String getGET_ON_WORK_TIME() {
		return GET_ON_WORK_TIME;
	}

	public String getGET_OFF_WORK_TIME() {
		return GET_OFF_WORK_TIME;
	}

}
