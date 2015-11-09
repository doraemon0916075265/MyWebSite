package tools;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import globalService.GlobalValue;

public class CalculatorFix2 {

	private final static String ERROR_LEAST_A_NUMBER = "！\t至少要有一個數字\t！";
	private final static String ERROR_PARENTHESIS_NEED_PAIR = "！\t括號必須成對出現\t！";
	private final static String ERROR_ILLEGAL_CHAR = "！\t含錯誤字元\t！";

	private static boolean isLegalExpression(String expression) throws Exception {
		boolean result = true;
		int expressionSize = expression.length();
		int parenthesisLeft = 0;
		int parenthesisRight = 0;

		if (result) {

			/** 至少一個數字 **/
			boolean leastANumber = expression.matches("^(?=.*\\d).+$");
			if (!leastANumber) {
				System.out.println(ERROR_LEAST_A_NUMBER);
			}

			/** 判斷：能出現的字元0-9*+-/() **/
			boolean isLegalUnit = expression.matches("[0-9\\+\\-\\*\\/\\(\\)]{1,}");
			if (!isLegalUnit) {
				System.out.println(ERROR_ILLEGAL_CHAR);
			}
			if (!leastANumber || !isLegalUnit) {
				result = false;
			}
		}

		if (result) {
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
			/** 括號必須成對出現 **/
			if (parenthesisLeft != parenthesisRight) {
				System.out.println(ERROR_PARENTHESIS_NEED_PAIR);
				result = false;
			}

		}

		return result;
	}

	private static ArrayList<String> expressionToFixSequence(String expression) {
		int expressionSize = expression.length();
		ArrayList<String> list = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();

		stack.push("=");
		char unitChar, lastChar;
		String unitString;
		int beginIndex = 0;
		int endIndex;

		for (int i = 0; i < expressionSize; i++) {
			unitChar = expression.charAt(i);
			endIndex = i;
			if (unitChar != '*' && unitChar != '+' && unitChar != '-' && unitChar != '/' && unitChar != '(' && unitChar != ')') {
				if (endIndex == expressionSize - 1) {
					endIndex = expressionSize - 1;
					unitString = expression.substring(beginIndex, expressionSize);
					if (!unitString.equals("")) {
						list.add(unitString);
					}
				}
			} else {
				switch (unitChar) {
				case '+':
				case '-':
				case '*':
				case '/':
					lastChar = stack.peek().charAt(0);
					if (lastChar != '(' && operatorPriority(lastChar) >= operatorPriority(unitChar))
						list.add(stack.pop());
					stack.push("" + unitChar);
					System.out.println(unitChar + "\t" + lastChar);
					break;
				case '(':
					stack.push("(");
					break;
				case ')':
					while (!stack.isEmpty() && stack.peek().charAt(0) != '(')
						list.add(stack.pop());
					if (stack.isEmpty() || stack.size() == 1)
						stack.pop();
					break;
				case '=':
					while (stack.size() > 1 && stack.peek().charAt(0) != '(')
						list.add(stack.pop());
					if (stack.size() > 1)
						break;

				}
			}

		}

		System.out.println("list：" + list + "\nstack：" + stack);
		return list;
	}

	private static int operatorPriority(char unitChar) {
		switch (unitChar) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		GlobalValue USE = new GlobalValue();
		Scanner sc = new Scanner(System.in);

		String input;
		String again = "y";

		while (again.toLowerCase().equals("y")) {
			System.out.println("計算機：");
			// input = sc.next();
			input = "20+(25-(7*8+24)-55)*5";

			System.out.println("輸入：\t\t" + input);

			try {
				System.out.println("是否合法：\t" + CalculatorFix2.isLegalExpression(input));
				System.out.println("結果：\t" + CalculatorFix2.expressionToFixSequence(input));

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