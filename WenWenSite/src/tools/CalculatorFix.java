package tools;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import javax.smartcardio.Card;

import globalService.GlobalValue;

public class CalculatorFix {

	// private final static String ERROR_ENDWITH_NEED = "最後必須輸入等號";
	// private final static String ERROR_PARENTHESIS_NOT_PAIR = "括號必須成對出現";
	// private final static String ERROR_CHAR_NOT_SUPPORT = "不支援的字元";

	private static boolean isLegalExpression(String expression) throws Exception {
		boolean result = true;
		int expressionSize = expression.length();
		int parenthesisLeft = 0;
		int parenthesisRight = 0;

		if (result) {// 判斷一：能出現的字元 0-9 + - * / ( )
			boolean leastANumber = expression.matches("[0-9]{1,}");
			System.out.println("至少一個數字\t" + leastANumber);
			boolean isLegalUnit = (expression.matches("[0-9\\+\\-\\*\\/\\(\\)]{1,}") && (true));
			if (!isLegalUnit) {
				System.out.println("！！！\t含錯誤字元\t！！！");
				result = false;
			}
		}

		if (result) {// 判斷二：括號必須成對出現
			for (int i = 0; i < expressionSize; i++) {
				char unitChar = expression.charAt(i);
				switch (unitChar) {
				case '(': {
					parenthesisLeft++;
					break;
				}
				case ')': {
					parenthesisRight++;
					break;
				}
				}
			}
			if (parenthesisLeft != parenthesisRight) {
				System.out.println("！！！\t括號數量錯誤\t！！！");
				result = false;
			}

		}

		return result;
	}

	private static ArrayList<String> xxx(String expression) {
		int expressionSize = expression.length();
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < expressionSize; i++) {
			char unitChar = expression.charAt(i);
			String unitString = "" + unitChar;
			stack.push(unitString);
		}
		System.out.println(stack);
		return null;
	}

	public static void main(String[] args) {
		GlobalValue USE = new GlobalValue();
		Scanner sc = new Scanner(System.in);

		String input;
		String again = "y";

		while (again.toLowerCase().equals("y")) {
			System.out.println("計算機：");
			input = sc.next();
			// input = "19+(27-(7+8+(5*9)+23)-55+6)*5";

			System.out.println("輸入：\t\t" + input);

			try {
				System.out.println("是否合法：\t" + CalculatorFix.isLegalExpression(input));
				System.out.println("是否合法：\t" + CalculatorFix.xxx(input));
			} catch (Exception e) {
				e.printStackTrace();
			}

			USE.Demarcation();
			USE.Demarcation();
			System.out.println("輸入 Y 繼續，任意鍵離開");
			again = sc.next();
			USE.Demarcation();
		}

	}

}