package tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		int TYear = 2015;
		int TMonth = 11;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar time = Calendar.getInstance();

		time.set(TYear, TMonth - 1, 1);
		Date begin = time.getTime();

		System.out.println(sdf.format(begin));

		time.set(TYear, TMonth, 0);
		Date end = time.getTime();
		System.out.println(sdf.format(end));

		long onedaytime = 1000 * 3600 * 24; // A day in milliseconds

		System.out.println(((end.getTime() - begin.getTime()) / onedaytime) + 1);

	}

}
