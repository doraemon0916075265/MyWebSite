package database.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.service.GlobalValueSQL;

public class InsertOracleFakeData {
	static GlobalValueSQL GV = new GlobalValueSQL();
	/** 輸出字串 **/
	private static String PRINT_STYLE = GV.getPRINT_STYLE();
	private static String CAN_NOT_WORD = GV.getCAN_NOT_WORD();
	private static String SUCCESS_WORD = GV.getSUCCESS_WORD();
	private static String FAIL_WORD = GV.getFAIL_WORD();
	private static String CAN_DROP_TABLE = GV.getCAN_DROP_TABLE();
	private static String CAN_INSERT_FAKE_DATA = GV.getCAN_INSERT_FAKE_DATA();
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
	private static String ORACLE_INSERT_FAKE_DATA = GV.getORACLE_INSERT_FAKE_DATA();

	public static void start() {
		System.out.println(InsertOracleFakeData.class.getName());
	}

	private static void insertTable() {
		if (GV.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/** 建立資料表 **/
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				pstmt = conn.prepareStatement(ORACLE_CREATE_TABLE);

				int datasize = NameOfEmployee.allTemplateEmployee().size();

				try {
					for (int i = 0; i < datasize; i++) {
						String name = NameOfEmployee.allTemplateEmployee().get(i);
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
