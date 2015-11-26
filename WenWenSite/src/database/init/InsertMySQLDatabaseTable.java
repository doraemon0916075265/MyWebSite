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

	/** 輸出字串 **/
	private static String SUCCESS_WORD = GVSQL.getSUCCESS_WORD();
	private static String FAIL_WORD = GVSQL.getFAIL_WORD();
	private static String PRINT_STYLE = GVSQL.getPRINT_STYLE();
	private static String CAN_NOT_WORD = GVSQL.getCAN_NOT_WORD();
	private static String CAN_DROP_DATABASE = GVSQL.getCAN_DROP_DATABASE();
	private static String CAN_CREATE_DATABASE = GVSQL.getCAN_CREATE_DATABASE();
	private static String CAN_CREATE_TABLE = GVSQL.getCAN_CREATE_TABLE();
	/** SQL 其他字串 **/
	private static String DATABASE_NAME = GVSQL.getDATABASE_NAME();
	private static String FULL_TABLE_NAME = GVSQL.getFULL_TABLE_NAME();
	/** MySQL 連線字串 **/
	private static String MYSQL_CONNURL = GVSQL.getMYSQL_CONNURL();
	private static String MYSQL_USER = GVSQL.getMYSQL_USER();
	private static String MYSQL_PASSWORD = GVSQL.getMYSQL_PASSWORD();
	/** MySQL SQL指令 **/
	private static String MYSQL_CREATE_DATABASE = GVSQL.getMYSQL_CREATE_DATABASE();
	private static String MYSQL_DROP_DATABASE = GVSQL.getMYSQL_DROP_DATABASE();
	private static String MYSQL_CREATE_TABLE = GVSQL.getMYSQL_CREATE_TABLE();

	/** 結果 **/
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
					System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_DROP_DATABASE, DATABASE_NAME);
					result.add(SUCCESS_WORD + "\t" + CAN_DROP_DATABASE);
				} catch (Exception e) {
					System.out.printf(PRINT_STYLE, FAIL_WORD, CAN_NOT_WORD + CAN_DROP_DATABASE, DATABASE_NAME);
					result.add(FAIL_WORD + "\t" + CAN_NOT_WORD + CAN_DROP_DATABASE);
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
					System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_CREATE_DATABASE, FULL_TABLE_NAME);
					result.add(SUCCESS_WORD + "\t" + CAN_CREATE_DATABASE);
				} catch (Exception e) {
					System.out.printf(PRINT_STYLE, FAIL_WORD, CAN_CREATE_DATABASE, FULL_TABLE_NAME);
					result.add(FAIL_WORD + "\t" + CAN_NOT_WORD + CAN_CREATE_DATABASE);
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
					System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_CREATE_TABLE, FULL_TABLE_NAME);
					result.add(SUCCESS_WORD + "\t" + CAN_CREATE_TABLE);
				} catch (Exception e) {
					System.out.printf(PRINT_STYLE, FAIL_WORD, CAN_NOT_WORD + CAN_CREATE_TABLE, FULL_TABLE_NAME);
					result.add(FAIL_WORD + "\t" + CAN_NOT_WORD + CAN_CREATE_TABLE);
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
