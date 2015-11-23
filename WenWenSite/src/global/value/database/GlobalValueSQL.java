package global.value.database;

public class GlobalValueSQL {
	/** 輸出字串 **/
	private final String EMPTY_WORD = "";
	private final String SUCCESS_WORD = "✓";
	private final String FAIL_WORD = "✗";
	private final String PRINT_STYLE = "%s\t%s\t%s\n";
	private final String CAN_NOT_WORD = "無法";
	private final String CAN_DROP_DATABASE = "刪除資料庫";
	private final String CAN_CREATE_DATABASE = "創建資料庫";
	private final String CAN_DROP_TABLE = "刪除資料表";
	private final String CAN_CREATE_TABLE = "建立資料表";
	private final String CAN_DROP_IDENTITY = "刪除流水號";
	private final String CAN_CREATE_IDENTITY = "建立流水號";
	private final String CAN_INSERT_FAKE_DATA = "建立假資料";
	// -------------------------------------------------------------------
	/** SQL 其他字串 **/
	private final String DATABASE_NAME_MYSQL = "MySQL";
	private final String DATABASE_NAME_ORACLE = "Oracle";
	private final String DRIVER_NOT_FOUND = "無效的 Driver";
	private final String DATABASE_NAME = "company";// 資料庫名稱
	private final String TABLE_NAME = "employeeinfo";// 表格名稱
	private final String FULL_TABLE_NAME = DATABASE_NAME + "." + TABLE_NAME;
	// -------------------------------------------------------------------
	/** MySQL 驅動字串 **/
	private final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	/** MySQL 連線字串 **/
	private final String MYSQL_CONNURL = "jdbc:mysql://localhost:3306/student";
	private final String MYSQL_USER = "root";// MySQL 帳號
	private final String MYSQL_PASSWORD = "root";// MySQL 密碼
	/** MySQL SQL指令 - database **/
	private final String MYSQL_CREATE_DATABASE = "create database " + DATABASE_NAME;
	private final String MYSQL_DROP_DATABASE = "drop database " + DATABASE_NAME;
	/** MySQL SQL指令 - table **/
	private final String MYSQL_TABLE_TEMP_COLUMN = "id int auto_increment,primary key(id),name varchar(50),age int,cellphone varchar(10),email varchar(50),hiredate datetime";
	private final String MYSQL_CREATE_TABLE = "create table " + DATABASE_NAME + "." + TABLE_NAME + "(" + MYSQL_TABLE_TEMP_COLUMN + ")";
	/** MySQL SQL指令 - data **/
	private final String MYSQL_INSERT_FAKE_DATA = "insert into " + FULL_TABLE_NAME + " (name,age,cellphone,email,hiredate) values (?,?,?,?,?)";
	// -------------------------------------------------------------------
	/** Oracle 驅動字串 **/
	private final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	/** Oracle 連線字串 **/
	private final String ORACLE_CONNURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String ORACLE_USER = "doraemon";// Oracle 帳號
	private final String ORACLE_PASSWORD = "doraemon";// Oracle 密碼
	/** Oracle 流水號 **/
	private final String IDENTITY_VARIABLE = "seq_employeeid";
	private final String DROP_IDENTITY = "drop sequence " + IDENTITY_VARIABLE;
	private final String CREATE_IDENTITY = "CREATE SEQUENCE " + IDENTITY_VARIABLE + " MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1";
	/** Oracle SQL指令 - table **/
	private final String ORACLE_DROP_TABLE = "drop table " + TABLE_NAME;
	private final String ORACLE_TABLE_COLUMN = "ID NUMBER primary key not null, NAME NVARCHAR2(50),AGE NUMBER(5),CELLPHONE NVARCHAR2(10),EMAIL NVARCHAR2(50),HIREDATE timestamp";
	private final String ORACLE_CREATE_TABLE = "create table " + TABLE_NAME + "(" + ORACLE_TABLE_COLUMN + ")";
	/** ORACLE SQL指令 - data **/
	private final String ORACLE_INSERT_FAKE_DATA = "insert into " + TABLE_NAME + " (ID,NAME,AGE,CELLPHONE,EMAIL,HIREDATE) values (seq_employeeid.NEXTVAL,?,?,?,?,?)";

	// -------------------------------------------------------------------
	public boolean isUsefulMySQLDriver() {
		boolean result = false;
		try {
			/** 找 MySQL 驅動程式 **/
			Class.forName(MYSQL_DRIVER);
			result = true;
		} catch (ClassNotFoundException e) {
			System.out.printf(PRINT_STYLE, FAIL_WORD, DRIVER_NOT_FOUND, EMPTY_WORD);
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
			System.out.printf(PRINT_STYLE, FAIL_WORD, DRIVER_NOT_FOUND, EMPTY_WORD);
		}
		return result;
	}
	// -------------------------------------------------------------------

	public String getEMPTY_WORD() {
		return EMPTY_WORD;
	}

	public String getSUCCESS_WORD() {
		return SUCCESS_WORD;
	}

	public String getFAIL_WORD() {
		return FAIL_WORD;
	}

	public String getPRINT_STYLE() {
		return PRINT_STYLE;
	}

	public String getCAN_NOT_WORD() {
		return CAN_NOT_WORD;
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

	public String getDATABASE_NAME_ORACLE() {
		return DATABASE_NAME_ORACLE;
	}

	public String getDATABASE_NAME_MYSQL() {
		return DATABASE_NAME_MYSQL;
	}

	public String getDRIVER_NOT_FOUND() {
		return DRIVER_NOT_FOUND;
	}

	public String getDATABASE_NAME() {
		return DATABASE_NAME;
	}

	public String getTABLE_NAME() {
		return TABLE_NAME;
	}

	public String getFULL_TABLE_NAME() {
		return FULL_TABLE_NAME;
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

	public String getMYSQL_CREATE_DATABASE() {
		return MYSQL_CREATE_DATABASE;
	}

	public String getMYSQL_DROP_DATABASE() {
		return MYSQL_DROP_DATABASE;
	}

	public String getMYSQL_TABLE_TEMP_COLUMN() {
		return MYSQL_TABLE_TEMP_COLUMN;
	}

	public String getMYSQL_CREATE_TABLE() {
		return MYSQL_CREATE_TABLE;
	}

	public String getMYSQL_INSERT_FAKE_DATA() {
		return MYSQL_INSERT_FAKE_DATA;
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

	public String getIDENTITY_VARIABLE() {
		return IDENTITY_VARIABLE;
	}

	public String getDROP_IDENTITY() {
		return DROP_IDENTITY;
	}

	public String getCREATE_IDENTITY() {
		return CREATE_IDENTITY;
	}

	public String getORACLE_DROP_TABLE() {
		return ORACLE_DROP_TABLE;
	}

	public String getORACLE_TABLE_COLUMN() {
		return ORACLE_TABLE_COLUMN;
	}

	public String getORACLE_CREATE_TABLE() {
		return ORACLE_CREATE_TABLE;
	}

	public String getORACLE_INSERT_FAKE_DATA() {
		return ORACLE_INSERT_FAKE_DATA;
	}

}
