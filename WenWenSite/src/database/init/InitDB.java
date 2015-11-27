package database.init;

import java.util.List;

public class InitDB {

	public static List<String> runInit() {
		return InitDBAgency.start();
	}

}
