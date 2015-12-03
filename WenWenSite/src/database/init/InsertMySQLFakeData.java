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
	/** 輸出字串 WORD **/
	private static String WORD_SUCCESS = GVSQL.getWORD_SUCCESS();
	private static String WORD_FAIL = GVSQL.getWORD_FAIL();
	private static String WORD_CAN_NOT = GVSQL.getWORD_CAN_NOT();
	/** 輸出字串 CAN **/
	private static String CAN_INSERT_FAKE_DATA = GVSQL.getCAN_INSERT_FAKE_DATA();
	/** 輸出字串 STYLE **/
	private static String STYLE_PRINT_CONSOLE_SUCCESS = GVSQL.getSTYLE_PRINT_CONSOLE_SUCCESS();
	private static String STYLE_PRINT_CONSOLE_FAIL = GVSQL.getSTYLE_PRINT_CONSOLE_FAIL();
	/** SQL 其他字串 **/
	private static String WORD_DATABASE_NAME_MYSQL = GVSQL.getWORD_DATABASE_NAME_MYSQL();
	private static String NAME_FULL_TABLE = GVSQL.getNAME_FULL_TABLE();
	/** MySQL 連線字串 **/
	private static String MYSQL_CONNURL = GVSQL.getMYSQL_CONNURL();
	private static String MYSQL_USER = GVSQL.getMYSQL_USER();
	private static String MYSQL_PASSWORD = GVSQL.getMYSQL_PASSWORD();
	/** MySQL SQL指令 - data **/
	private static final String MYSQL_INSERT_FAKE_DATA = "insert into " + NAME_FULL_TABLE + " (name,age,cellphone,email,hiredate) values (?,?,?,?,?)";

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
				int datasize = data.allFakeEmployee(WORD_DATABASE_NAME_MYSQL).size();

				try {
					for (int i = 0; i < datasize; i++) {
						String name = data.allFakeEmployee(WORD_DATABASE_NAME_MYSQL).get(i);
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
					System.out.printf(STYLE_PRINT_CONSOLE_SUCCESS, CAN_INSERT_FAKE_DATA, NAME_FULL_TABLE);
					result.add(WORD_SUCCESS + "\t" + CAN_INSERT_FAKE_DATA);
				} catch (Exception e) {
					System.out.printf(STYLE_PRINT_CONSOLE_FAIL, WORD_CAN_NOT + CAN_INSERT_FAKE_DATA, NAME_FULL_TABLE);
					result.add(WORD_FAIL + "\t" + WORD_CAN_NOT + CAN_INSERT_FAKE_DATA);
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
