package database.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import global.value.database.GlobalValueSQL;

public class InsertOracleTable {
	static GlobalValueSQL GVSQL = new GlobalValueSQL();
	/** 輸出字串 WORD **/
	private static String WORD_SUCCESS = GVSQL.getWORD_SUCCESS();
	private static String WORD_FAIL = GVSQL.getWORD_FAIL();
	private static String WORD_CAN_NOT = GVSQL.getWORD_CAN_NOT();
	/** 輸出字串 CAN **/
	private static String CAN_DROP_TABLE = GVSQL.getCAN_DROP_TABLE();
	private static String CAN_CREATE_TABLE = GVSQL.getCAN_CREATE_TABLE();
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
	/** Oracle SQL指令 - table **/
	private static final String ORACLE_DROP_TABLE = "drop table " + NAME_TABLE;
	private static final String ORACLE_TABLE_COLUMN = "ID NUMBER primary key not null, NAME NVARCHAR2(50),AGE NUMBER(5),CELLPHONE NVARCHAR2(10),EMAIL NVARCHAR2(50),HIREDATE timestamp";
	private static final String ORACLE_CREATE_TABLE = "create table " + NAME_TABLE + "(" + ORACLE_TABLE_COLUMN + ")";
	/** 結果 List **/
	static List<String> result = new ArrayList<String>();

	public static List<String> start() {
		System.out.println(InsertOracleTable.class.getSimpleName());
		result.clear();
		dropTable();
		createTable();
		return result;
	}

	private static void dropTable() {
		if (GVSQL.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/** 刪除資料表 **/
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				pstmt = conn.prepareStatement(ORACLE_DROP_TABLE);
				try {
					pstmt.executeUpdate();
					System.out.printf(STYLE_PRINT_CONSOLE_SUCCESS, CAN_DROP_TABLE, NAME_FULL_TABLE);
					result.add(WORD_SUCCESS + "\t" + CAN_DROP_TABLE);
				} catch (Exception e) {
					System.out.printf(STYLE_PRINT_CONSOLE_FAIL, WORD_CAN_NOT + CAN_DROP_TABLE, NAME_FULL_TABLE);
					result.add(WORD_FAIL + "\t" + WORD_CAN_NOT + CAN_DROP_TABLE);
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

	private static void createTable() {
		if (GVSQL.isUsefulOracleDriver()) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/** 建立資料表 **/
				conn = DriverManager.getConnection(ORACLE_CONNURL, ORACLE_USER, ORACLE_PASSWORD);
				pstmt = conn.prepareStatement(ORACLE_CREATE_TABLE);
				try {
					pstmt.executeUpdate();
					System.out.printf(STYLE_PRINT_CONSOLE_SUCCESS, CAN_CREATE_TABLE, NAME_FULL_TABLE);
					result.add(WORD_SUCCESS + "\t" + CAN_CREATE_TABLE);
				} catch (Exception e) {
					System.out.printf(STYLE_PRINT_CONSOLE_FAIL, WORD_CAN_NOT + CAN_CREATE_TABLE, NAME_FULL_TABLE);
					result.add(WORD_FAIL + "\t" + WORD_CAN_NOT + CAN_CREATE_TABLE);
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
