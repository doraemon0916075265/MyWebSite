package database.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import global.value.database.GlobalValueSQL;

public class InsertOracleFakeData {
	static GlobalValueSQL GVSQL = new GlobalValueSQL();
	/** 輸出字串 WORD **/
	private static String WORD_EMPTY = GVSQL.getWORD_EMPTY();
	private static String WORD_SUCCESS = GVSQL.getWORD_SUCCESS();
	private static String WORD_FAIL = GVSQL.getWORD_FAIL();
	private static String WORD_CAN_NOT = GVSQL.getWORD_CAN_NOT();
	private static String WORD_DATABASE_NAME_ORACLE = GVSQL.getWORD_DATABASE_NAME_ORACLE();
	/** 輸出字串 CAN **/
	private static String CAN_DROP_IDENTITY = GVSQL.getCAN_DROP_IDENTITY();
	private static String CAN_CREATE_IDENTITY = GVSQL.getCAN_CREATE_IDENTITY();
	private static String CAN_INSERT_FAKE_DATA = GVSQL.getCAN_INSERT_FAKE_DATA();
	/** 輸出字串 STYLE **/
	private static String STYLE_PRINT_CONSOLE_SUCCESS = GVSQL.getSTYLE_PRINT_CONSOLE_SUCCESS();
	private static String STYLE_PRINT_CONSOLE_FAIL = GVSQL.getSTYLE_PRINT_CONSOLE_FAIL();
	/** SQL 其他字串 **/
	private static String NAME_TABLE = GVSQL.getNAME_TABLE();
	private static String NAME_FULL_TABLE = GVSQL.getNAME_FULL_TABLE();
	/** Oracle 連線字串 **/
	private static String ORACLE_CONNURL = GVSQL.getORACLE_CONNURL();
	private static String ORACLE_USER = GVSQL.getORACLE_USER();
	private static String ORACLE_PASSWORD = GVSQL.getORACLE_PASSWORD();
	/** Oracle 流水號 **/
	private static final String IDENTITY_VARIABLE = "seq_employeeid";
	private static final String DROP_IDENTITY = "drop sequence " + IDENTITY_VARIABLE;
	private static final String CREATE_IDENTITY = "CREATE SEQUENCE " + IDENTITY_VARIABLE + " MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1";
	/** ORACLE SQL指令 - data **/
	private static final String ORACLE_INSERT_FAKE_DATA = "insert into " + NAME_TABLE + " (ID,NAME,AGE,CELLPHONE,EMAIL,HIREDATE) values (seq_employeeid.NEXTVAL,?,?,?,?,?)";

	/** 結果 **/
	static List<String> result = new ArrayList<String>();

	public static List<String> start() {
		System.out.println(InsertOracleFakeData.class.getSimpleName());
		result.clear();
		dropIdentity();
		createIdentity();
		insertFakeData();
		return result;
	}

	private static void dropIdentity() {
		if (GVSQL.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/** 刪除流水號 **/
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				pstmt = conn.prepareStatement(DROP_IDENTITY);
				try {
					pstmt.executeUpdate();
					System.out.printf(STYLE_PRINT_CONSOLE_SUCCESS, CAN_DROP_IDENTITY, WORD_EMPTY);
					result.add(WORD_SUCCESS + "\t" + CAN_DROP_IDENTITY);
				} catch (Exception e) {
					System.out.printf(STYLE_PRINT_CONSOLE_FAIL, WORD_CAN_NOT + CAN_DROP_IDENTITY, WORD_EMPTY);
					result.add(WORD_FAIL + "\t" + WORD_CAN_NOT + CAN_DROP_IDENTITY);
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
		if (GVSQL.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/** 建立流水號 **/
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				pstmt = conn.prepareStatement(CREATE_IDENTITY);
				try {
					pstmt.executeUpdate();
					System.out.printf(STYLE_PRINT_CONSOLE_SUCCESS, CAN_CREATE_IDENTITY, WORD_EMPTY);
					result.add(WORD_SUCCESS + "\t" + CAN_CREATE_IDENTITY);
				} catch (Exception e) {
					System.out.printf(STYLE_PRINT_CONSOLE_FAIL, WORD_CAN_NOT + CAN_CREATE_IDENTITY, WORD_EMPTY);
					result.add(WORD_FAIL + "\t" + WORD_CAN_NOT + CAN_CREATE_IDENTITY);
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
		if (GVSQL.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/** 建立資料表 **/
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				pstmt = conn.prepareStatement(ORACLE_INSERT_FAKE_DATA);
				InsertFakeData data = new InsertFakeData();
				int datasize = data.allFakeEmployee(WORD_DATABASE_NAME_ORACLE).size();

				try {
					for (int i = 0; i < datasize; i++) {
						String name = data.allFakeEmployee(WORD_DATABASE_NAME_ORACLE).get(i);
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
