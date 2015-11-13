package web.init;

import java.util.Date;

public class Init {

	public static void main(String[] args) {
		Date start = new Date(System.currentTimeMillis());
		
		
		for (int i = 0; i < 50000; i++) {
			System.out.println("haha");
		}
		Date end = new Date(System.currentTimeMillis());
		System.out.println("費時:" + (end.getTime() - start.getTime()) + "ms");
	}

}
