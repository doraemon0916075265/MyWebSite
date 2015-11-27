package database.init;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import global.value.database.GlobalValueSQL;

public class InitDBAgency {
	static GlobalValueSQL GVSQL = new GlobalValueSQL();
	private static String DATABASE_NAME_ORACLE = GVSQL.getDATABASE_NAME_ORACLE();
	private static String DATABASE_NAME_MYSQL = GVSQL.getDATABASE_NAME_MYSQL();
	private static String FAIL_WORD = GVSQL.getFAIL_WORD();
	private static String DRIVER_NOT_FOUND = GVSQL.getDRIVER_NOT_FOUND();
	private static String CAN_NOT_DO_THIS = GVSQL.getCAN_NOT_DO_THIS();

	public static List<String> start() {
		long startInit = new Date(System.currentTimeMillis()).getTime();
		List<String> result = new ArrayList<String>();
		/** MySQL 系列 **/
		System.out.println(DATABASE_NAME_MYSQL);
		result.add(DATABASE_NAME_MYSQL);
		if (GVSQL.isUsefulMySQLDriver()) {
			if (InsertMySQLDatabaseTable.start().isEmpty() || InsertMySQLFakeData.start().isEmpty()) {
				result.add(CAN_NOT_DO_THIS);
			} else {
				result.addAll(InsertMySQLDatabaseTable.start());// 建資料庫&資料表
				result.addAll(InsertMySQLFakeData.start());// 建假資料
			}
		} else {
			result.add(FAIL_WORD + "\t" + DRIVER_NOT_FOUND);
		}

		/** Oracle 系列 **/
		System.out.println(DATABASE_NAME_ORACLE);
		result.add(DATABASE_NAME_ORACLE);
		if (GVSQL.isUsefulOracleDriver()) {
			if (InsertOracleTable.start().isEmpty() || InsertOracleFakeData.start().isEmpty()) {
				result.add(CAN_NOT_DO_THIS);
			} else {
				result.addAll(InsertOracleTable.start());// 建資料表
				result.addAll(InsertOracleFakeData.start());// 建假資料
			}
		} else {
			result.add(FAIL_WORD + "\t" + DRIVER_NOT_FOUND);
		}

		System.out.println("費時：" + ((new Date(System.currentTimeMillis()).getTime()) - startInit) + "毫秒");
		return result;
	}
}
