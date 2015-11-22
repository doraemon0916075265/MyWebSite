package database.init;

import java.util.ArrayList;
import java.util.List;

public class InsertFakeData {

	public List<String> allFakeEmployee(String database) {
		List<String> result = new ArrayList<String>();
		String databaseFix = database.trim().toLowerCase();
		if (databaseFix == "mysql") {
			result.add("Mysql");
		} else if (database == "oracle") {
			result.add("Orcle");
		} else {
			result.add("other database");
		}
		result.add("Hello kitty");
		result.add("Snoopy");
		result.add("Doraemon");
		result.add("Amane misa");
		result.add("Spongebob Squarepants");
		result.add("Pikachu");
		result.add("Naruto");
		result.add("Rockman");
		result.add("Mario");
		result.add("Tower of Saviors");
		result.add("Tom and Jerry");
		return result;
	}

}
