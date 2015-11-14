package web.init;

import java.util.Date;

public class Init {

	public static void main(String[] args) {
		Date start = new Date(System.currentTimeMillis());

		InsertDatabaseTable.start();

		Date end = new Date(System.currentTimeMillis());
		System.out.println("費時:" + (end.getTime() - start.getTime()) + "ms");
	}

}
