package database.init;

import java.util.Date;

public class Init {

	public static void main(String[] args) {
		Date begin = new Date(System.currentTimeMillis());

		/** MySQL 系列 **/
		InsertMySQLDatabaseTable.start();// 建資料庫&資料表
		InsertMySQLFakeData.start();// 建假資料
		/** Oracle 系列 **/
		InsertOracleTable.start();// 建資料表
		// InsertOracleTempData.start();// 建假資料

		Date end = new Date(System.currentTimeMillis());
		System.out.println("費時：" + (end.getTime() - begin.getTime()) + "毫秒");
	}

}
