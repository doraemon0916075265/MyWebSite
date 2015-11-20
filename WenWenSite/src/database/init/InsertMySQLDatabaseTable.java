package database.init;
//package web.init;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import database.GlobalValueDB;
//
//public class InsertMySQLDatabaseTable {
//	static GlobalValueDB GV = new GlobalValueDB();
//
//	/** MySQL 連線字串 **/
//	private static String MYSQL_DRIVER = GV.getMYSQL_DRIVER();
//	private static String MYSQL_CONNURL = GV.getMYSQL_CONNURL();
//	private static String MYSQL_USER = GV.getMYSQL_USER();
//	private static String MYSQL_PASSWORD = GV.getMYSQL_PASSWORD();
//	/** 資料庫字串 **/
//	private static String FULL_TABLE_NAME = GV.getFULL_TABLE_NAME();
//	/** SQL字串 **/
//	private static String MYSQL_CREATE_DATABASE = GV.getMYSQL_CREATE_DATABASE();
//	private static String MYSQL_DROP_DATABASE = GV.getMYSQL_DROP_DATABASE();
//	private static String MYSQL_CREATE_TABLE = GV.getMYSQL_CREATE_TABLE();
//
//	/** 輸出字串 **/
//	private static String PRINT_STYLE = GV.getPRINT_STYLE();
//	private static String CAN_NOT_WORD = GV.getCAN_NOT_WORD();
//	private static String SUCCESS_WORD = GV.getSUCCESS_WORD();
//	private static String FAIL_WORD = GV.getFAIL_WORD();
//	private static String CAN_DROP_DATABASE = "刪除資料庫";
//	private static String CAN_CREATE_DATABASE = "創建資料庫";
//	private static String CAN_CREATE_TABLE = "建立表格　";
//
//	public static void start() {
//		System.out.println(InsertMySQLDatabaseTable.class.getName());
//		dropDatabase();
//		createDatabase();
//		createTable();
//	}
//
//	private static void dropDatabase() {
//		try {
//			/** 找驅動程式 **/
//			Class.forName(MYSQL_DRIVER);
//		} catch (ClassNotFoundException e) {
//			System.out.println(DRIVER_NOT_FOUND);
//			e.printStackTrace();
//		}
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			/** 刪除資料庫 **/
//			conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
//			pstmt = conn.prepareStatement(DROP_DATABASE);
//			try {
//				pstmt.executeUpdate();
//				System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_DROP_DATABASE, DATABASE_NAME);
//			} catch (Exception e) {
//				System.out.printf(PRINT_STYLE, FAIL_WORD, ERROR_WORD + CAN_DROP_DATABASE, DATABASE_NAME);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//	}
//
//	private static void createDatabase() {
//		try {
//			/** 找驅動程式 **/
//			Class.forName(MYSQL_DRIVER);
//		} catch (ClassNotFoundException e) {
//			System.out.println(DRIVER_NOT_FOUND);
//			e.printStackTrace();
//		}
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			/** 創建資料庫 **/
//			conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
//			pstmt = conn.prepareStatement(CREATE_DATABASE);
//			try {
//				pstmt.executeUpdate();
//				System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_CREATE_DATABASE, FULL_TABLE_NAME);
//			} catch (Exception e) {
//				System.out.printf(PRINT_STYLE, FAIL_WORD, CAN_CREATE_DATABASE, FULL_TABLE_NAME);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
//	public static void createTable() {
//		try {
//			/** 找驅動程式 **/
//			Class.forName(MYSQL_DRIVER);
//		} catch (ClassNotFoundException e) {
//			System.out.println(DRIVER_NOT_FOUND);
//			e.printStackTrace();
//		}
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			/** 建立表格 **/
//			conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
//			pstmt = conn.prepareStatement(CREATE_TABLE);
//			try {
//				pstmt.executeUpdate();
//				System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_CREATE_TABLE, FULL_TABLE_NAME);
//			} catch (Exception e) {
//				System.out.printf(PRINT_STYLE, FAIL_WORD, ERROR_WORD + CAN_CREATE_TABLE, FULL_TABLE_NAME);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//	}
//
//}
