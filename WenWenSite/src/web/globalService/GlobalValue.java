package web.globalService;

public class GlobalValue {
	
	// 判斷輸入資料轉成數字有無錯誤
	public static int convertInt(String data) {
		int result;

		try {
			result = Integer.parseInt(data);
		} catch (NumberFormatException e) {
			result = -1000;
			e.printStackTrace();
		}
		return result;
	}

	
	
}
