package database.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.service.GlobalValueSQL;

public class InsertMySQLDatabaseTable {
	static GlobalValueSQL GV = new GlobalValueSQL();
	/** 輸出字串 **/
	private static String SUCCESS_WORD = GV.getSUCCESS_WORD();
	private static String FAIL_WORD = GV.getFAIL_WORD();
	private static String PRINT_STYLE = GV.getPRINT_STYLE();
	private static String CAN_NOT_WORD = GV.getCAN_NOT_WORD();
	private static String CAN_DROP_DATABASE = GV.getCAN_DROP_DATABASE();
	private static String CAN_CREATE_DATABASE = GV.getCAN_CREATE_DATABASE();
	private static String CAN_CREATE_TABLE = GV.getCAN_CREATE_TABLE();
	/** SQL 其他字串 **/
	private static String DRIVER_NOT_FOUND = GV.getDRIVER_NOT_FOUND();
	private static String DATABASE_NAME = GV.getDATABASE_NAME();
	private static String FULL_TABLE_NAME = GV.getFULL_TABLE_NAME();
	/** MySQL 連線字串 **/
	private static String MYSQL_CONNURL = GV.getMYSQL_CONNURL();
	private static String MYSQL_USER = GV.getMYSQL_USER();
	private static String MYSQL_PASSWORD = GV.getMYSQL_PASSWORD();
	/** MySQL SQL指令 **/
	private static String MYSQL_CREATE_DATABASE = GV.getMYSQL_CREATE_DATABASE();
	private static String MYSQL_DROP_DATABASE = GV.getMYSQL_DROP_DATABASE();
	private static String MYSQL_CREATE_TABLE = GV.getMYSQL_CREATE_TABLE();

	public static void start() {
		System.out.println(InsertMySQLDatabaseTable.class.getName());
		dropDatabase();
		createDatabase();
		createTable();
	}

	private static void dropDatabase() {
		if (GV.isUsefulMySQLDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/** 刪除資料庫 **/
				conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
				pstmt = conn.prepareStatement(MYSQL_DROP_DATABASE);
				try {
					pstmt.executeUpdate();
					System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_DROP_DATABASE, DATABASE_NAME);
				} catch (Exception e) {
					System.out.printf(PRINT_STYLE, FAIL_WORD, CAN_NOT_WORD + CAN_DROP_DATABASE, DATABASE_NAME);
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
		} else {
			System.out.println(DRIVER_NOT_FOUND);
		}

	}

	private static void createDatabase() {
		if (GV.isUsefulMySQLDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				/** 創建資料庫 **/
				conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
				pstmt = conn.prepareStatement(MYSQL_CREATE_DATABASE);
				try {
					pstmt.executeUpdate();
					System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_CREATE_DATABASE, FULL_TABLE_NAME);
				} catch (Exception e) {
					System.out.printf(PRINT_STYLE, FAIL_WORD, CAN_CREATE_DATABASE, FULL_TABLE_NAME);
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
		} else {
			System.out.println(DRIVER_NOT_FOUND);
		}

	}

	public static void createTable() {
		if (GV.isUsefulMySQLDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				/** 建立資料表 **/
				conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
				pstmt = conn.prepareStatement(MYSQL_CREATE_TABLE);
				try {
					pstmt.executeUpdate();
					System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_CREATE_TABLE, FULL_TABLE_NAME);
				} catch (Exception e) {
					System.out.printf(PRINT_STYLE, FAIL_WORD, CAN_NOT_WORD + CAN_CREATE_TABLE, FULL_TABLE_NAME);
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

		} else {
			System.out.println(DRIVER_NOT_FOUND);
		}

	}

}
