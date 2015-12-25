package global.value.web;

public class GlobalValueWebSite {
	/** 輸出字串 **/
	private static final String LOGINTITLE = "登入";
	private static final String APPNAME = "Hey Men";
	private static final String MATHPLACE = "數學專區";
	private static final String COMPANYNAME = "Company";
	private static final String HOMEPAGE = "首頁";
	private static final String BULLETINBOARD = "佈告欄";
	private static final String INITIALIZE = "初始化";
	private static final String DATABASE = "資料庫";
	private static final String MYSQL = "MySQL";
	private static final String ORACLE = "Oracle";
	private static final String CHECKINGDATA = "檢查中";
	private static final String BROWSER_NOT_SUPPORT = "您的瀏覽器不支援";
	private static final String OPENDATA = "開放資料";
	private static final String SHOW_DATABASE = "查看資料庫";
	/** File 系列 **/
	private static final String FILETYPE_EXCEL = "Excel";
	/** DataType 系列 **/
	private static final String DATATYPE_XML = "xml";
	private static final String DATATYPE_JSON = "json";
	/** Page 系列 **/
	private static final String PAGE_GO_TO_COMPANYCRUD = "/pages/company/CRUD.jsp";
	private static final String PAGE_GO_TO_INDEX = "/index.jsp";

	public String getShowDatabase() {
		return SHOW_DATABASE;
	}

	public String getOpendata() {
		return OPENDATA;
	}

	public String getFiletypeExcel() {
		return FILETYPE_EXCEL;
	}

	public String getDatatypeXml() {
		return DATATYPE_XML;
	}

	public String getDatatypeJson() {
		return DATATYPE_JSON;
	}

	public String getBrowserNotSupport() {
		return BROWSER_NOT_SUPPORT;
	}

	public String getCheckingdata() {
		return CHECKINGDATA;
	}

	public String getInitialize() {
		return INITIALIZE;
	}

	public String getDatabase() {
		return DATABASE;
	}

	public String getPageGoToCompanycrud() {
		return PAGE_GO_TO_COMPANYCRUD;
	}

	public static String getPageGoToIndex() {
		return PAGE_GO_TO_INDEX;
	}

	public String getBulletinBoard() {
		return BULLETINBOARD;
	}

	public String getLoginTitle() {
		return LOGINTITLE;
	}

	public String getAppName() {
		return APPNAME;
	}

	public String getMathPlace() {
		return MATHPLACE;
	}

	public String getCompanyName() {
		return COMPANYNAME;
	}

	public String getHomePage() {
		return HOMEPAGE;
	}

	public String getMysql() {
		return MYSQL;
	}

	public String getOracle() {
		return ORACLE;
	}

}
