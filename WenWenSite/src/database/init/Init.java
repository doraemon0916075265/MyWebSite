package database.init;

import java.util.Date;

import global.value.database.GlobalValueSQL;

public class Init {
	static GlobalValueSQL GV = new GlobalValueSQL();
	private static String DATABASE_NAME_ORACLE = GV.getDATABASE_NAME_ORACLE();
	private static String DATABASE_NAME_MYSQL = GV.getDATABASE_NAME_MYSQL();

	public static void main(String[] args) {
		Date beginInit = new Date(System.currentTimeMillis());
		/** MySQL 系列 **/
		System.out.println(DATABASE_NAME_MYSQL);
		InsertMySQLDatabaseTable.start();// 建資料庫&資料表
		InsertMySQLFakeData.start();// 建假資料
		/** Oracle 系列 **/
		System.out.println(DATABASE_NAME_ORACLE);
		InsertOracleTable.start();// 建資料表
		InsertOracleFakeData.start();// 建假資料

		Date endInit = new Date(System.currentTimeMillis());
		System.out.println("費時：" + (endInit.getTime() - beginInit.getTime()) + "毫秒");
	}

}
