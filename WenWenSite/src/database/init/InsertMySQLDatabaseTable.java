package database.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import global.value.database.GlobalValueSQL;

public class InsertMySQLDatabaseTable {
	static GlobalValueSQL GVSQL = new GlobalValueSQL();
	/** 輸出字串 WORD **/
	private static String WORD_SUCCESS = GVSQL.getWORD_SUCCESS();
	private static String WORD_FAIL = GVSQL.getWORD_FAIL();
	private static String WORD_CAN_NOT = GVSQL.getWORD_CAN_NOT();
	/** 輸出字串 CAN **/
	private static String CAN_DROP_DATABASE = GVSQL.getCAN_DROP_DATABASE();
	private static String CAN_CREATE_DATABASE = GVSQL.getCAN_CREATE_DATABASE();
	private static String CAN_CREATE_TABLE = GVSQL.getCAN_CREATE_TABLE();
	/** 輸出字串 STYLE **/
	private static String STYLE_PRINT_CONSOLE_SUCCESS = GVSQL.getSTYLE_PRINT_CONSOLE_SUCCESS();
	private static String STYLE_PRINT_CONSOLE_FAIL = GVSQL.getSTYLE_PRINT_CONSOLE_FAIL();
	/** SQL 其他字串 **/
	private static String NAME_DATABASE = GVSQL.getNAME_DATABASE();
	private static String NAME_TABLE = GVSQL.getNAME_TABLE();
	private static String NAME_FULL_TABLE = GVSQL.getNAME_FULL_TABLE();
	/** MySQL 連線字串 **/
	private static String MYSQL_CONNURL = GVSQL.getMYSQL_CONNURL();
	private static String MYSQL_USER = GVSQL.getMYSQL_USER();
	private static String MYSQL_PASSWORD = GVSQL.getMYSQL_PASSWORD();
	/** MySQL SQL指令 - database **/
	private static final String MYSQL_CREATE_DATABASE = "create database " + NAME_DATABASE;
	private static final String MYSQL_DROP_DATABASE = "drop database " + NAME_DATABASE;
	/** MySQL SQL指令 - table **/
	private static final String MYSQL_TABLE_TEMP_COLUMN = "id int auto_increment,primary key(id),name varchar(50),age int,cellphone varchar(10),email varchar(50),hiredate datetime";
	private static final String MYSQL_CREATE_TABLE = "create table " + NAME_DATABASE + "." + NAME_TABLE + "(" + MYSQL_TABLE_TEMP_COLUMN + ")";
	/** 結果 LIST **/
	static List<String> result = new ArrayList<String>();

	public static List<String> start() {
		System.out.println(InsertMySQLDatabaseTable.class.getSimpleName());
		result.clear();
		dropDatabase();
		createDatabase();
		createTable();
		return result;
	}

	private static List<String> dropDatabase() {
		if (GVSQL.isUsefulMySQLDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/** 刪除資料庫 **/
				conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
				pstmt = conn.prepareStatement(MYSQL_DROP_DATABASE);
				try {
					pstmt.executeUpdate();
					System.out.printf(STYLE_PRINT_CONSOLE_SUCCESS, CAN_DROP_DATABASE, NAME_DATABASE);
					result.add(WORD_SUCCESS + "\t" + CAN_DROP_DATABASE);
				} catch (Exception e) {
					System.out.printf(STYLE_PRINT_CONSOLE_FAIL, WORD_CAN_NOT + CAN_DROP_DATABASE, NAME_DATABASE);
					result.add(WORD_FAIL + "\t" + WORD_CAN_NOT + CAN_DROP_DATABASE);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return result;

	}

	private static void createDatabase() {
		if (GVSQL.isUsefulMySQLDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				/** 創建資料庫 **/
				conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
				pstmt = conn.prepareStatement(MYSQL_CREATE_DATABASE);
				try {
					pstmt.executeUpdate();
					System.out.printf(STYLE_PRINT_CONSOLE_SUCCESS, CAN_CREATE_DATABASE, NAME_FULL_TABLE);
					result.add(WORD_SUCCESS + "\t" + CAN_CREATE_DATABASE);
				} catch (Exception e) {
					System.out.printf(STYLE_PRINT_CONSOLE_FAIL, CAN_CREATE_DATABASE, NAME_FULL_TABLE);
					result.add(WORD_FAIL + "\t" + WORD_CAN_NOT + CAN_CREATE_DATABASE);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	public static void createTable() {
		if (GVSQL.isUsefulMySQLDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				/** 建立資料表 **/
				conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
				pstmt = conn.prepareStatement(MYSQL_CREATE_TABLE);
				try {
					pstmt.executeUpdate();
					System.out.printf(STYLE_PRINT_CONSOLE_SUCCESS, CAN_CREATE_TABLE, NAME_FULL_TABLE);
					result.add(WORD_SUCCESS + "\t" + CAN_CREATE_TABLE);
				} catch (Exception e) {
					System.out.printf(STYLE_PRINT_CONSOLE_FAIL, WORD_CAN_NOT + CAN_CREATE_TABLE, NAME_FULL_TABLE);
					result.add(WORD_FAIL + "\t" + WORD_CAN_NOT + CAN_CREATE_TABLE);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

		}

	}

}
