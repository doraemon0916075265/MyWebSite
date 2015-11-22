package database.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.service.GlobalValueSQL;

public class InsertOracleTable {
	static GlobalValueSQL GV = new GlobalValueSQL();
	/** 輸出字串 **/
	private static String PRINT_STYLE = GV.getPRINT_STYLE();
	private static String CAN_NOT_WORD = GV.getCAN_NOT_WORD();
	private static String SUCCESS_WORD = GV.getSUCCESS_WORD();
	private static String FAIL_WORD = GV.getFAIL_WORD();
	private static String CAN_DROP_TABLE = GV.getCAN_DROP_TABLE();
	private static String CAN_CREATE_TABLE = GV.getCAN_CREATE_TABLE();
	/** SQL 其他字串 **/
	private static String DRIVER_NOT_FOUND = GV.getDRIVER_NOT_FOUND();
	private static String FULL_TABLE_NAME = GV.getFULL_TABLE_NAME();
	/** Oracle 連線字串 **/
	private static String ORACLE_CONNURL = GV.getORACLE_CONNURL();
	private static String ORACLE_USER = GV.getORACLE_USER();
	private static String ORACLE_PASSWORD = GV.getORACLE_PASSWORD();
	/** Oracle SQL 指令 **/
	private static String ORACLE_DROP_TABLE = GV.getORACLE_DROP_TABLE();
	private static String ORACLE_CREATE_TABLE = GV.getORACLE_CREATE_TABLE();

	public static void start() {
		System.out.println(InsertOracleTable.class.getSimpleName());
		dropTable();
		createTable();
	}

	private static void dropTable() {
		if (GV.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/** 刪除資料表 **/
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				pstmt = conn.prepareStatement(ORACLE_DROP_TABLE);
				try {
					pstmt.executeUpdate();
					System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_DROP_TABLE, FULL_TABLE_NAME);
				} catch (Exception e) {
					System.out.printf(PRINT_STYLE, FAIL_WORD, CAN_NOT_WORD + CAN_DROP_TABLE, FULL_TABLE_NAME);
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

	private static void createTable() {
		if (GV.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/** 建立資料表 **/
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				pstmt = conn.prepareStatement(ORACLE_CREATE_TABLE);
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

		}
	}
}
