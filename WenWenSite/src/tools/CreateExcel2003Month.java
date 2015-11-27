package tools;

import java.util.Date;

public class CreateExcel2003Month {
	public static void main(String[] args) {
		long startInit = new Date(System.currentTimeMillis()).getTime();
//		CreateExcelAgency.start(2015, 11);
		System.out.println("總共費時：" + (new Date(System.currentTimeMillis()).getTime() - startInit) + "毫秒");
	}

}
