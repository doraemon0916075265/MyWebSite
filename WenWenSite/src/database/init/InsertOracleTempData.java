package database.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.service.GlobalValueSQL;

public class InsertOracleTempData {
	static GlobalValueSQL GV = new GlobalValueSQL();
	/** 輸出字串 **/
	private static String PRINT_STYLE = GV.getPRINT_STYLE();
	private static String CAN_NOT_WORD = GV.getCAN_NOT_WORD();
	private static String SUCCESS_WORD = GV.getSUCCESS_WORD();
	private static String FAIL_WORD = GV.getFAIL_WORD();
	private static String CAN_INSERT_TEMPLATE_DATA = "建立假資料";
	/** MySQL 連線字串 **/
	private static String MYSQL_DRIVER = GV.getMYSQL_DRIVER();
	private static String DRIVER_NOT_FOUND = GV.getDRIVER_NOT_FOUND();
	private static String MYSQL_CONNURL = GV.getMYSQL_CONNURL();
	private static String MYSQL_USER = GV.getMYSQL_USER();
	private static String MYSQL_PASSWORD = GV.getMYSQL_PASSWORD();
	/** MySQL 資料庫字串 **/
	private static String DATABASE_NAME = GV.getDATABASE_TEMP();
	private static String TABLE_NAME = GV.getTABLE_TEMP();
	private static String FULL_TABLE_NAME = DATABASE_NAME + "." + TABLE_NAME;
	/** MySQL SQL字串 **/
	private static final String INSERT = "insert into " + FULL_TABLE_NAME + " (name,age,cellphone,email,hiredate) values (?,?,?,?,?)";

	public static void start() {
		System.out.println(InsertOracleTempData.class.getName());
		InsertOracleTempData.insertCompanyInfo();
	}

	private static void insertCompanyInfo() {
		try {
			/** 找驅動程式 **/
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(DRIVER_NOT_FOUND);
			e.printStackTrace();
		}

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(MYSQL_CONNURL, MYSQL_USER, MYSQL_PASSWORD);
			pstmt = conn.prepareStatement(INSERT);

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
				System.out.printf(PRINT_STYLE, SUCCESS_WORD, CAN_INSERT_TEMPLATE_DATA, FULL_TABLE_NAME);
			} catch (Exception e) {
				System.out.printf(PRINT_STYLE, FAIL_WORD, CAN_NOT_WORD + CAN_INSERT_TEMPLATE_DATA, FULL_TABLE_NAME);
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
