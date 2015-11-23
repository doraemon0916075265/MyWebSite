package database.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import global.value.database.GlobalValueSQL;

public class InsertOracleFakeData {
	static GlobalValueSQL GV = new GlobalValueSQL();
	/** 輸出字串 **/
	private static String EMPTY_WORD = GV.getEMPTY_WORD();
	private static String PRINT_STYLE = GV.getPRINT_STYLE();
	private static String CAN_NOT_WORD = GV.getCAN_NOT_WORD();
	private static String SUCCESS_WORD = GV.getSUCCESS_WORD();
	private static String FAIL_WORD = GV.getFAIL_WORD();
	private static String CAN_DROP_IDENTITY = GV.getCAN_DROP_IDENTITY();
	private static String CAN_CREATE_IDENTITY = GV.getCAN_CREATE_IDENTITY();
	private static String CAN_INSERT_FAKE_DATA = GV.getCAN_INSERT_FAKE_DATA();
	/** SQL 其他字串 **/
	private static String DATABASE_NAME_ORACLE = GV.getDATABASE_NAME_ORACLE();
	private static String FULL_TABLE_NAME = GV.getFULL_TABLE_NAME();
	/** Oracle 連線字串 **/
	private static String ORACLE_CONNURL = GV.getORACLE_CONNURL();
	private static String ORACLE_USER = GV.getORACLE_USER();
	private static String ORACLE_PASSWORD = GV.getORACLE_PASSWORD();
	/** Oracle 流水號 **/
	private static String DROP_IDENTITY = GV.getDROP_IDENTITY();
	private static String CREATE_IDENTITY = GV.getCREATE_IDENTITY();
	/** Oracle SQL 指令 **/
	private static String ORACLE_INSERT_FAKE_DATA = GV.getORACLE_INSERT_FAKE_DATA();

	public static void start() {
		System.out.println(InsertOracleFakeData.class.getSimpleName());
		dropIdentity();
		createIdentity();
		insertFakeData();
	}

	private static void dropIdentity() {
		if (GV.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/** 刪除流水號 **/
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				pstmt = conn.prepareStatement(DROP_IDENTITY);
				try {
					pstmt.executeUpdate();
					System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_DROP_IDENTITY, EMPTY_WORD);
				} catch (Exception e) {
					System.out.printf(PRINT_STYLE, FAIL_WORD, CAN_NOT_WORD + CAN_DROP_IDENTITY, EMPTY_WORD);
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

	private static void createIdentity() {
		if (GV.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/** 建立流水號 **/
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				pstmt = conn.prepareStatement(CREATE_IDENTITY);
				try {
					pstmt.executeUpdate();
					System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_CREATE_IDENTITY, EMPTY_WORD);
				} catch (Exception e) {
					System.out.printf(PRINT_STYLE, FAIL_WORD, CAN_NOT_WORD + CAN_CREATE_IDENTITY, EMPTY_WORD);
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

	private static void insertFakeData() {
		if (GV.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/** 建立資料表 **/
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				pstmt = conn.prepareStatement(ORACLE_INSERT_FAKE_DATA);
				InsertFakeData data = new InsertFakeData();
				int datasize = data.allFakeEmployee(DATABASE_NAME_ORACLE).size();

				try {
					for (int i = 0; i < datasize; i++) {
						String name = data.allFakeEmployee(DATABASE_NAME_ORACLE).get(i);
						int age = (int) (Math.random() * 119) + 1;
						String cellphone = "09" + (int) (Math.random() * 100000000);
						pstmt.setString(1, name);
						pstmt.setInt(2, age);
						pstmt.setString(3, cellphone);
						pstmt.setString(4, name + "@gmail.com");
						pstmt.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));

						try {
							pstmt.executeUpdate();
						} catch (Exception e) {
							System.out.println("新增資料失敗");
						}
					}
					System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_INSERT_FAKE_DATA, FULL_TABLE_NAME);
				} catch (Exception e) {
					System.out.printf(PRINT_STYLE, FAIL_WORD, CAN_NOT_WORD + CAN_INSERT_FAKE_DATA, FULL_TABLE_NAME);
					e.printStackTrace();
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
