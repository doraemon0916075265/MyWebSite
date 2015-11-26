package database.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import global.value.database.GlobalValueSQL;

public class InsertMySQLFakeData {
	static GlobalValueSQL GVSQL = new GlobalValueSQL();
	/** 輸出字串 **/
	private static String SUCCESS_WORD = GVSQL.getSUCCESS_WORD();
	private static String FAIL_WORD = GVSQL.getFAIL_WORD();
	private static String PRINT_STYLE = GVSQL.getPRINT_STYLE();
	private static String CAN_NOT_WORD = GVSQL.getCAN_NOT_WORD();
	private static String CAN_INSERT_FAKE_DATA = GVSQL.getCAN_INSERT_FAKE_DATA();
	/** SQL 其他字串 **/
	private static String DATABASE_NAME_MYSQL = GVSQL.getDATABASE_NAME_MYSQL();
	private static String FULL_TABLE_NAME = GVSQL.getFULL_TABLE_NAME();
	/** MySQL 連線字串 **/
	private static String MYSQL_CONNURL = GVSQL.getMYSQL_CONNURL();
	private static String MYSQL_USER = GVSQL.getMYSQL_USER();
	private static String MYSQL_PASSWORD = GVSQL.getMYSQL_PASSWORD();
	/** MySQL SQL 指令 **/
	private static String MYSQL_INSERT_FAKE_DATA = GVSQL.getMYSQL_INSERT_FAKE_DATA();

	/** 結果 **/
	static List<String> result = new ArrayList<String>();

	public static List<String> start() {
		System.out.println(InsertMySQLFakeData.class.getSimpleName());
		result.clear();
		insertFakeData();
		return result;
	}

	private static void insertFakeData() {
		if (GVSQL.isUsefulMySQLDriver()) {

			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
				pstmt = conn.prepareStatement(MYSQL_INSERT_FAKE_DATA);
				InsertFakeData data = new InsertFakeData();
				int datasize = data.allFakeEmployee(DATABASE_NAME_MYSQL).size();

				try {
					for (int i = 0; i < datasize; i++) {
						String name = data.allFakeEmployee(DATABASE_NAME_MYSQL).get(i);
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
					result.add(SUCCESS_WORD + "\t" + CAN_INSERT_FAKE_DATA);
				} catch (Exception e) {
					System.out.printf(PRINT_STYLE, FAIL_WORD, CAN_NOT_WORD + CAN_INSERT_FAKE_DATA, FULL_TABLE_NAME);
					result.add(FAIL_WORD + "\t" + CAN_NOT_WORD + CAN_INSERT_FAKE_DATA);
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
