package global.value.database;

public class GlobalValueSQL {
	/** 輸出字串 WORD **/
	private final String WORD_EMPTY = "";
	private final String WORD_SUCCESS = "✓";
	private final String WORD_FAIL = "✗";
	private final String WORD_DO_NOT = "不";
	private final String WORD_CAN_NOT = "無法";
	private final String WORD_USELESS = "無效的";
	private final String WORD_DATABASE_NAME_MYSQL = "MySQL";
	private final String WORD_DATABASE_NAME_ORACLE = "Oracle";
	/** 輸出字串 CAN **/
	private final String CAN_USE_USERNAME = "可用的帳號";
	private final String CAN_NOT_USERNAME = WORD_DO_NOT + CAN_USE_USERNAME;
	private final String CAN_USELESS_TO_DO = WORD_USELESS + "操作";
	private final String CAN_DROP_DATABASE = "刪除資料庫";
	private final String CAN_CREATE_DATABASE = "創建資料庫";
	private final String CAN_DROP_TABLE = "刪除資料表";
	private final String CAN_CREATE_TABLE = "建立資料表";
	private final String CAN_DROP_IDENTITY = "刪除流水號";
	private final String CAN_CREATE_IDENTITY = "建立流水號";
	private final String CAN_INSERT_FAKE_DATA = "建立假資料";
	/** 輸出字串 STYLE **/
	private final String STYLE_PRINT_CONSOLE_SUCCESS = WORD_SUCCESS + "\t%s\t%s\n";
	private final String STYLE_PRINT_CONSOLE_FAIL = WORD_FAIL + "\t%s\t%s\n";
	// -------------------------------------------------------------------
	/** SQL 其他字串 **/
	private final String CAN_NOT_FOUND_DRIVER = WORD_USELESS + " Driver";
	private final String CAN_USELESS_MYSQL_USER_OR_PASSWORD = WORD_USELESS + "帳號或密碼";
	private final String NAME_DATABASE = "company";// 資料庫名稱
	private final String NAME_TABLE = "employeeinfo";// 表格名稱
	private final String NAME_FULL_TABLE = NAME_DATABASE + "." + NAME_TABLE;
	// -------------------------------------------------------------------
	/** MySQL 驅動字串 **/
	private final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	/** MySQL 連線字串 **/
	private final String MYSQL_CONNURL = "jdbc:mysql://localhost:3306/student";
	private final String MYSQL_USER = "root";// MySQL 帳號
	private final String MYSQL_PASSWORD = "root";// MySQL 密碼
	// -------------------------------------------------------------------
	/** Oracle 驅動字串 **/
	private final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	/** Oracle 連線字串 **/
	private final String ORACLE_CONNURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String ORACLE_USER = "doraemon";// Oracle 帳號
	private final String ORACLE_PASSWORD = "doraemon";// Oracle 密碼
	// -------------------------------------------------------------------

	public boolean isUsefulMySQLDriver() {
		boolean result = false;
		try {
			/** 找 MySQL 驅動程式 **/
			Class.forName(MYSQL_DRIVER);
			result = true;
		} catch (ClassNotFoundException e) {
			System.out.printf(STYLE_PRINT_CONSOLE_FAIL, CAN_NOT_FOUND_DRIVER, WORD_EMPTY);
		}
		return result;
	}

	// -------------------------------------------------------------------
	public boolean isUsefulOracleDriver() {
		boolean result = false;
		try {
			/** 找 Oracle 驅動程式 **/
			Class.forName(ORACLE_DRIVER);
			result = true;
		} catch (ClassNotFoundException e) {
			System.out.printf(STYLE_PRINT_CONSOLE_FAIL, CAN_NOT_FOUND_DRIVER, WORD_EMPTY);
		}
		return result;
	}
	// -------------------------------------------------------------------

	public String getWORD_EMPTY() {
		return WORD_EMPTY;
	}

	public String getWORD_SUCCESS() {
		return WORD_SUCCESS;
	}

	public String getWORD_FAIL() {
		return WORD_FAIL;
	}

	public String getWORD_DO_NOT() {
		return WORD_DO_NOT;
	}

	public String getWORD_CAN_NOT() {
		return WORD_CAN_NOT;
	}

	public String getWORD_USELESS() {
		return WORD_USELESS;
	}

	public String getWORD_DATABASE_NAME_MYSQL() {
		return WORD_DATABASE_NAME_MYSQL;
	}

	public String getWORD_DATABASE_NAME_ORACLE() {
		return WORD_DATABASE_NAME_ORACLE;
	}

	public String getCAN_USE_USERNAME() {
		return CAN_USE_USERNAME;
	}

	public String getCAN_NOT_USERNAME() {
		return CAN_NOT_USERNAME;
	}

	public String getCAN_USELESS_TO_DO() {
		return CAN_USELESS_TO_DO;
	}

	public String getCAN_DROP_DATABASE() {
		return CAN_DROP_DATABASE;
	}

	public String getCAN_CREATE_DATABASE() {
		return CAN_CREATE_DATABASE;
	}

	public String getCAN_DROP_TABLE() {
		return CAN_DROP_TABLE;
	}

	public String getCAN_CREATE_TABLE() {
		return CAN_CREATE_TABLE;
	}

	public String getCAN_DROP_IDENTITY() {
		return CAN_DROP_IDENTITY;
	}

	public String getCAN_CREATE_IDENTITY() {
		return CAN_CREATE_IDENTITY;
	}

	public String getCAN_INSERT_FAKE_DATA() {
		return CAN_INSERT_FAKE_DATA;
	}

	public String getSTYLE_PRINT_CONSOLE_SUCCESS() {
		return STYLE_PRINT_CONSOLE_SUCCESS;
	}

	public String getSTYLE_PRINT_CONSOLE_FAIL() {
		return STYLE_PRINT_CONSOLE_FAIL;
	}

	public String getCAN_NOT_FOUND_DRIVER() {
		return CAN_NOT_FOUND_DRIVER;
	}

	public String getCAN_USELESS_MYSQL_USER_OR_PASSWORD() {
		return CAN_USELESS_MYSQL_USER_OR_PASSWORD;
	}

	public String getNAME_DATABASE() {
		return NAME_DATABASE;
	}

	public String getNAME_TABLE() {
		return NAME_TABLE;
	}

	public String getNAME_FULL_TABLE() {
		return NAME_FULL_TABLE;
	}

	public String getMYSQL_DRIVER() {
		return MYSQL_DRIVER;
	}

	public String getMYSQL_CONNURL() {
		return MYSQL_CONNURL;
	}

	public String getMYSQL_USER() {
		return MYSQL_USER;
	}

	public String getMYSQL_PASSWORD() {
		return MYSQL_PASSWORD;
	}

	public String getORACLE_DRIVER() {
		return ORACLE_DRIVER;
	}

	public String getORACLE_CONNURL() {
		return ORACLE_CONNURL;
	}

	public String getORACLE_USER() {
		return ORACLE_USER;
	}

	public String getORACLE_PASSWORD() {
		return ORACLE_PASSWORD;
	}

}
