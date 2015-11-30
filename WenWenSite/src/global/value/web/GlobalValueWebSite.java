package global.value.web;

public class GlobalValueWebSite {
	private static final String GO_TO_COMPANYCRUD_PAGE = "/pages/company/CRUD.jsp";
	private static final String GO_TO_INDEX_PAGE = "/index.jsp";
	private static final String LOGINTITLE = "登入";
	private static final String APPNAME = "Learn On-Line";
	private static final String FILEEXCEL = "Excel";
	private static final String MATHPLACE = "數學專區";
	private static final String COMPANYNAME = "Company";
	private static final String HOMEPAGE = "首頁";
	private static final String BULLETINBOARD = "佈告欄";
	private static final String INITIALIZE = "初始化";
	private static final String DATABASE = "資料庫";
	private static final String MYSQL = "MySQL";
	private static final String ORACLE = "Oracle";

	public String getInitialize() {
		return INITIALIZE;
	}

	public String getDatabase() {
		return DATABASE;
	}

	public String getFileExcel() {
		return FILEEXCEL;
	}

	public String getGoToCompanycrudPage() {
		return GO_TO_COMPANYCRUD_PAGE;
	}

	public String getGoToIndexPage() {
		return GO_TO_INDEX_PAGE;
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
