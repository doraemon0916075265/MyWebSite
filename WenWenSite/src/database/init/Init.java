package database.init;

import java.util.Date;

public class Init {

	public static void main(String[] args) {
		Date begin = new Date(System.currentTimeMillis());

//		InsertMySQLDatabaseTable.start();// 建 Database & Table
		InsertMySQLTemplateData.start();// 建假資料

		Date end = new Date(System.currentTimeMillis());
		System.out.println("費時：" + (end.getTime() - begin.getTime()) + "毫秒");
	}

}
