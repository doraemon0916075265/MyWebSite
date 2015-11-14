package web.init;

public class InitGlobalValue {
	/** 其他字串 **/
	private String SUCCESS_WORD = "✓";
	private String FAIL_WORD = "✗";
	/** 驅動字串 **/
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String DRIVER_NOT_FOUND = "找不到 Driver";
	/** 連線字串 **/
	private final String CONNURL = "jdbc:mysql://localhost:3306/student";
	private final String USER = "root";
	private final String PASSWORD = "root";
	/** SQL指令 **/
	private final String DATABASE01 = "company";// 資料庫名稱
	private final String CREATE_DATABASE = "create database " + DATABASE01;
	private final String DROP_DATABASE = "drop database " + DATABASE01;

	private final String TABLE01 = "employeeinfo";// 表格名稱
	private final String TABLE01_COLUMN = "id int auto_increment,primary key(id),name varchar(50),age int,cellphone varchar(10),email varchar(50),hiredate datetime";
	private final String CREATE_TABLE = "create table " + DATABASE01 + "." + TABLE01 + "(" + TABLE01_COLUMN + ")";

	public String getSUCCESS_WORD() {
		return SUCCESS_WORD;
	}

	public void setSUCCESS_WORD(String sUCCESS_WORD) {
		SUCCESS_WORD = sUCCESS_WORD;
	}

	public String getFAIL_WORD() {
		return FAIL_WORD;
	}

	public void setFAIL_WORD(String fAIL_WORD) {
		FAIL_WORD = fAIL_WORD;
	}

	public String getDRIVER() {
		return DRIVER;
	}

	public String getDRIVER_NOT_FOUND() {
		return DRIVER_NOT_FOUND;
	}

	public String getCONNURL() {
		return CONNURL;
	}

	public String getUSER() {
		return USER;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public String getDATABASE01() {
		return DATABASE01;
	}

	public String getCREATE_DATABASE() {
		return CREATE_DATABASE;
	}

	public String getDROP_DATABASE() {
		return DROP_DATABASE;
	}

	public String getTABLE01() {
		return TABLE01;
	}

	public String getTABLE01_COLUMN() {
		return TABLE01_COLUMN;
	}

	public String getCREATE_TABLE() {
		return CREATE_TABLE;
	}

}
