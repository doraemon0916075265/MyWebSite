package web.init;

public class InitGlobalValue {
	/** 驅動字串 **/
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	/** 連線字串 **/
	private static final String CONNURL = "jdbc:mysql://localhost:3306/student";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	/** SQL指令 **/
	private static final String DATABASE01 = "company1";// 資料庫名稱
	private static final String CREATE_DATABASE = "create database " + DATABASE01;
	private static final String DROP_COMPANY = "drop database " + DATABASE01;
	private static final String TABLE01 = "employeeinfo";
	private static final String CREATE_TABLE = "create table " + DATABASE01 + "." + TABLE01;

	public String getDriver() {
		return DRIVER;
	}

	public String getConnurl() {
		return CONNURL;
	}

	public String getUser() {
		return USER;
	}

	public String getPassword() {
		return PASSWORD;
	}

	public String getCreateDatabase() {
		return CREATE_DATABASE;
	}

	public String getDropCompany() {
		return DROP_COMPANY;
	}

	public String getCreateTable() {
		return CREATE_TABLE;
	}

}
