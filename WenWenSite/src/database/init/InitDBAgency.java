package database.init;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import global.value.database.GlobalValueSQL;

public class InitDBAgency {
	static GlobalValueSQL GVSQL = new GlobalValueSQL();
	/** 輸出字串 WORD **/
	private static String WORD_DATABASE_NAME_MYSQL = GVSQL.getWORD_DATABASE_NAME_MYSQL();
	private static String WORD_DATABASE_NAME_ORACLE = GVSQL.getWORD_DATABASE_NAME_ORACLE();
	private static String WORD_FAIL = GVSQL.getWORD_FAIL();
	/** 輸出字串 CAN **/
	private static String CAN_NOT_FOUND_DRIVER = GVSQL.getCAN_NOT_FOUND_DRIVER();
	private static String CAN_USELESS_TO_DO = GVSQL.getCAN_USELESS_TO_DO();

	public static List<String> start() {
		long startInit = new Date(System.currentTimeMillis()).getTime();
		List<String> result = new ArrayList<String>();
		/** MySQL 系列 **/
		System.out.println(WORD_DATABASE_NAME_MYSQL);
		result.add(WORD_DATABASE_NAME_MYSQL);
		if (GVSQL.isUsefulMySQLDriver()) {
			if (InsertMySQLDatabaseTable.start().isEmpty() || InsertMySQLFakeData.start().isEmpty()) {
				result.add(CAN_USELESS_TO_DO);
			} else {
				result.addAll(InsertMySQLDatabaseTable.start());// 建資料庫&資料表
				result.addAll(InsertMySQLFakeData.start());// 建假資料
			}
		} else {
			result.add(WORD_FAIL + "\t" + CAN_NOT_FOUND_DRIVER);
		}

		/** Oracle 系列 **/
		System.out.println(WORD_DATABASE_NAME_ORACLE);
		result.add(WORD_DATABASE_NAME_ORACLE);
		if (GVSQL.isUsefulOracleDriver()) {
			if (InsertOracleTable.start().isEmpty() || InsertOracleFakeData.start().isEmpty()) {
				result.add(CAN_USELESS_TO_DO);
			} else {
				result.addAll(InsertOracleTable.start());// 建資料表
				result.addAll(InsertOracleFakeData.start());// 建假資料
			}
		} else {
			result.add(WORD_FAIL + "\t" + CAN_NOT_FOUND_DRIVER);
		}

		System.out.println("費時：" + ((new Date(System.currentTimeMillis()).getTime()) - startInit) + "毫秒");
		return result;
	}
}
