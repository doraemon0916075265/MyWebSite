package global.value.database;

public class GlobalValueSQL {
	/** 輸出字串 WORD **/
	private final String WORD_EMPTY = "";
	private final String WORD_SUCCESS = "✓";
	private final String WORD_FAIL = "✗";
	private final String WORD_DO_NOT = "不";
	private final String WORD_EFFECTIVE = "有效的";
	private final String WORD_EXIST = "已存在";
	private final String WORD_NOT_EXIST = "不存在";
	private final String WORD_REPEAT = "重複的";
	private final String WORD_CAN_NOT = "無法";
	private final String WORD_USELESS = "無效的";
	private final String WORD_USERNAME = "帳號";
	private final String WORD_OPERATE = "操作";
	private final String WORD_DATABASE_NAME_MYSQL = "MySQL";
	private final String WORD_DATABASE_NAME_ORACLE = "Oracle";
	private final String WORD_CREATE = "建立";
	private final String WORD_INSERT = "匯入";
	private final String WORD_DELETE = "刪除";
	private final String WORD_DATABASE = "資料庫";
	private final String WORD_TABLE = "資料表";
	private final String WORD_IDENTITY = "流水號";
	private final String WORD_FAKE_DATA = "假資料";
	/** 輸出字串 CAN **/
	private final String CAN_USERNAME_NOT_EXIST = WORD_USERNAME + WORD_NOT_EXIST;
	private final String CAN_USERNAME_EXIST = WORD_USERNAME + WORD_EXIST;
	private final String CAN_USELESS_TO_DO = WORD_USELESS + WORD_OPERATE;
	private final String CAN_DROP_DATABASE = WORD_DELETE + WORD_DATABASE;
	private final String CAN_CREATE_DATABASE = WORD_CREATE + WORD_DATABASE;
	private final String CAN_DROP_TABLE = WORD_DELETE + WORD_TABLE;
	private final String CAN_CREATE_TABLE = WORD_CREATE + WORD_TABLE;
	private final String CAN_DROP_IDENTITY = WORD_DELETE + WORD_IDENTITY;
	private final String CAN_CREATE_IDENTITY = WORD_CREATE + WORD_IDENTITY;
	private final String CAN_INSERT_FAKE_DATA = WORD_INSERT + WORD_FAKE_DATA;
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

	public String getWORD_EFFECTIVE() {
		return WORD_EFFECTIVE;
	}

	public String getWORD_EXIST() {
		return WORD_EXIST;
	}

	public String getWORD_NOT_EXIST() {
		return WORD_NOT_EXIST;
	}

	public String getWORD_REPEAT() {
		return WORD_REPEAT;
	}

	public String getWORD_CAN_NOT() {
		return WORD_CAN_NOT;
	}

	public String getWORD_USELESS() {
		return WORD_USELESS;
	}

	public String getWORD_USERNAME() {
		return WORD_USERNAME;
	}

	public String getWORD_OPERATE() {
		return WORD_OPERATE;
	}

	public String getWORD_DATABASE_NAME_MYSQL() {
		return WORD_DATABASE_NAME_MYSQL;
	}

	public String getWORD_DATABASE_NAME_ORACLE() {
		return WORD_DATABASE_NAME_ORACLE;
	}

	public String getWORD_CREATE() {
		return WORD_CREATE;
	}

	public String getWORD_INSERT() {
		return WORD_INSERT;
	}

	public String getWORD_DELETE() {
		return WORD_DELETE;
	}

	public String getWORD_DATABASE() {
		return WORD_DATABASE;
	}

	public String getWORD_TABLE() {
		return WORD_TABLE;
	}

	public String getWORD_IDENTITY() {
		return WORD_IDENTITY;
	}

	public String getWORD_FAKE_DATA() {
		return WORD_FAKE_DATA;
	}

	public String getCAN_USERNAME_NOT_EXIST() {
		return CAN_USERNAME_NOT_EXIST;
	}

	public String getCAN_USERNAME_EXIST() {
		return CAN_USERNAME_EXIST;
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
