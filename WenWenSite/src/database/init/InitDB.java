package database.init;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import global.value.database.GlobalValueSQL;

public class InitDB {
	static GlobalValueSQL GV = new GlobalValueSQL();
	private static String DATABASE_NAME_ORACLE = GV.getDATABASE_NAME_ORACLE();
	private static String DATABASE_NAME_MYSQL = GV.getDATABASE_NAME_MYSQL();

	public static List<String> runInit() {
		Date beginInit = new Date(System.currentTimeMillis());
		List<String> result = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		/** MySQL 系列 **/
		System.out.println(DATABASE_NAME_MYSQL);
		result.add(DATABASE_NAME_MYSQL);
		temp = InsertMySQLDatabaseTable.start();// 建資料庫&資料表
		result.addAll(temp);
		temp = InsertMySQLFakeData.start();// 建假資料
		result.addAll(temp);
		/** Oracle 系列 **/
		System.out.println(DATABASE_NAME_ORACLE);
		result.add(DATABASE_NAME_ORACLE);
		temp = InsertOracleTable.start();// 建資料表
		result.addAll(temp);
		temp = InsertOracleFakeData.start();// 建假資料
		result.addAll(temp);
		Date endInit = new Date(System.currentTimeMillis());

		System.out.println("費時：" + (endInit.getTime() - beginInit.getTime()) + "毫秒");
		return result;
	}

	public static void main(String[] args) {
		runInit();
	}

}
