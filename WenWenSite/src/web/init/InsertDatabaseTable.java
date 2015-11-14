package web.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDatabaseTable {
	static InitGlobalValue GV = new InitGlobalValue();
	/** 連線字串 **/
	private static String DRIVER = GV.getDRIVER();
	private static String DRIVER_NOT_FOUND = GV.getDRIVER_NOT_FOUND();
	private static String CONNURL = GV.getCONNURL();
	private static String USER = GV.getUSER();
	private static String PASSWORD = GV.getPASSWORD();
	/** 資料庫字串 **/
	private static String DATABASE_NAME = GV.getDATABASE01();
	private static String TABLE_NAME = GV.getTABLE01();
	private static String FULL_TABLE_NAME = DATABASE_NAME + "." + TABLE_NAME;
	/** SQL字串 **/
	private static String DROP_DATABASE = GV.getDROP_DATABASE();
	private static String CREATE_DATABASE = GV.getCREATE_DATABASE();
	private static String CREATE_TABLE = GV.getCREATE_TABLE();

	/** 輸出字串 **/
	private static String PRINT_STYLE = "%s\t%s\t%s\n";
	private static String ERROR_WORD = "無法";
	private static String SUCCESS_WORD = GV.getSUCCESS_WORD();
	private static String FAIL_WORD = GV.getFAIL_WORD();
	private static String CAN_DROP_DATABASE = "刪除資料庫";
	private static String CAN_CREATE_DATABASE = "創建資料庫";
	private static String CAN_CREATE_TABLE = "建立表格　";

	public static void start() {
		System.out.println(InsertDatabaseTable.class.getName());
		dropDatabase();
		createDatabase();
		createTable();
	}

	private static void dropDatabase() {
		try {
			/** 找驅動程式 **/
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(DRIVER_NOT_FOUND);
			e.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			/** 刪除資料庫 **/
			conn = DriverManager.getConnection(CONNURL, USER, PASSWORD);
			pstmt = conn.prepareStatement(DROP_DATABASE);
			try {
				pstmt.executeUpdate();
				System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_DROP_DATABASE, DATABASE_NAME);
			} catch (Exception e) {
				System.out.printf(PRINT_STYLE, FAIL_WORD, ERROR_WORD + CAN_DROP_DATABASE, DATABASE_NAME);
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

	private static void createDatabase() {
		try {
			/** 找驅動程式 **/
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(DRIVER_NOT_FOUND);
			e.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			/** 創建資料庫 **/
			conn = DriverManager.getConnection(CONNURL, USER, PASSWORD);
			pstmt = conn.prepareStatement(CREATE_DATABASE);
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
	}

	public static void createTable() {
		try {
			/** 找驅動程式 **/
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(DRIVER_NOT_FOUND);
			e.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			/** 建立表格 **/
			conn = DriverManager.getConnection(CONNURL, USER, PASSWORD);
			pstmt = conn.prepareStatement(CREATE_TABLE);
			try {
				pstmt.executeUpdate();
				System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_CREATE_TABLE, FULL_TABLE_NAME);
			} catch (Exception e) {
				System.out.printf(PRINT_STYLE, FAIL_WORD, ERROR_WORD + CAN_CREATE_TABLE, FULL_TABLE_NAME);
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
