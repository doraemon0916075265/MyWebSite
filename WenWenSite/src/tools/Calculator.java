package tools;

import java.util.Scanner;

import globalService.GlobalValue;

public class Calculator {

	public static void main(String[] args) {
		GlobalValue USE = new GlobalValue();
		Scanner sc = new Scanner(System.in);

		System.out.println("計算機：");
		String input = sc.next();
		USE.Demarcation();
		System.out.println(input);
		
	}

}
