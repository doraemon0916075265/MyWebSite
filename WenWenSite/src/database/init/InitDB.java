package database.init;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import global.value.database.GlobalValueSQL;

public class InitDB {
	static GlobalValueSQL GV = new GlobalValueSQL();
	private static String DATABASE_NAME_ORACLE = GV.getDATABASE_NAME_ORACLE();
	private static String DATABASE_NAME_MYSQL = GV.getDATABASE_NAME_MYSQL();
	private static String FAIL_WORD = GV.getFAIL_WORD();
	private static String DRIVER_NOT_FOUND = GV.getDRIVER_NOT_FOUND();
	private static String CAN_NOT_DO_THIS = GV.getCAN_NOT_DO_THIS();

	public static List<String> runInit() {
		Date beginInit = new Date(System.currentTimeMillis());
		List<String> result = new ArrayList<String>();
		/** MySQL 系列 **/
		System.out.println(DATABASE_NAME_MYSQL);
		result.add(DATABASE_NAME_MYSQL);
		if (GV.isUsefulMySQLDriver()) {
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
		if (GV.isUsefulOracleDriver()) {
			if (InsertOracleTable.start().isEmpty() || InsertOracleFakeData.start().isEmpty()) {
				result.add(CAN_NOT_DO_THIS);
			} else {
				result.addAll(InsertOracleTable.start());// 建資料表
				result.addAll(InsertOracleFakeData.start());// 建假資料
			}
		} else {
			result.add(FAIL_WORD + "\t" + DRIVER_NOT_FOUND);
		}

		Date endInit = new Date(System.currentTimeMillis());
		System.out.println("費時：" + (endInit.getTime() - beginInit.getTime()) + "毫秒");
		return result;
	}

	public static void main(String[] args) {
		runInit();
	}

}
