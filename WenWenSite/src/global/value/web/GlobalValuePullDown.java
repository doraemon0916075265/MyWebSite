package global.value.web;

public class GlobalValuePullDown {
	private static final String[] PD_DATA_SOURCE = { "臺北市政府資料開放平台", "政府資料開放平臺" };
	private static final String[] PD_LANGUAGE = { "中文", "English" };
	private static final String[] PD_ITEM = { "景點", "住宿", "旅館民宿" };

	public String[] getPdDataSource() {
		return PD_DATA_SOURCE;
	}

	public String[] getPdLanguage() {
		return PD_LANGUAGE;
	}

	public String[] getPdItem() {
		return PD_ITEM;
	}

}
