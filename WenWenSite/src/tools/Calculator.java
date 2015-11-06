package tools;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import globalService.GlobalValue;

public class Calculator {

	private static final String ERROR_ENDWITH_NEED = "最後必須輸入等號";
	private static final String ERROR_PARENTHESIS_NOT_PAIR = "括號必須成對出現";
	private static final String ERROR_CHAR_NOT_SUPPORT = "不支援的字元";

	private static ArrayList<String> inputToSequence(String input) throws Exception {

		if (!input.endsWith("=")) {
			throw new Exception(ERROR_ENDWITH_NEED);
		}

		ArrayList<String> list = new ArrayList<String>();
		Stack<String> st = new Stack<String>();
		st.push("=");
		char lastChar, unitChar;
		StringBuffer sb = null;

		for (int i = 0; i < input.length(); i++) {
			unitChar = input.charAt(i);
			switch (unitChar) {
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
				lastChar = st.peek().charAt(0);
				if (lastChar != '(' && (operator(lastChar) > operator(unitChar))) {
					list.add(st.pop());
				}
				st.push("" + unitChar);
				break;
			case '(':
				st.push("(");
				break;
			case ')':
				while (!st.isEmpty() && st.peek().charAt(0) != '(') {
					list.add(st.pop());
				}
				if (st.isEmpty() || st.size() == 1) {
					throw new Exception(ERROR_PARENTHESIS_NOT_PAIR);
				}
				st.pop();
			case '=':
				while (st.size() > 1 && st.peek().charAt(0) != '(') {
					list.add(st.pop());
				}
				if (st.size() > 1) {
					throw new Exception(ERROR_PARENTHESIS_NOT_PAIR);
				}
				break;
			default: {
				if (Character.isDigit(unitChar) || '.' == unitChar) {
					sb = new StringBuffer();
					sb.append(unitChar);
					while (Character.isDigit(input.charAt(i) + 1) || input.charAt(i + 1) == '.') {
						sb.append(input).charAt(++i);
					}
					list.add(sb.toString());
					break;
				} else {

				}
				System.out.println("sb" + sb);
			}
			}
			System.out.println(st);
		}

		System.out.println(st);
		System.out.println(input.length());

		return null;
	}

	private static int operator(char unitChar) {
		switch (unitChar) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
		case '%':
			return 2;
		case '=':
			return 0;
		default:
			return 0;
		}
	}

	// private static String calculate(ArrayList<String> list) {
	// return null;
	// }

	public static void main(String[] args) {
		GlobalValue USE = new GlobalValue();
		Scanner sc = new Scanner(System.in);

		String input;
		String again = "y";

		while (again.toLowerCase().equals("y")) {
			System.out.println("計算機：");
			input = sc.next();
			USE.Demarcation();
			System.out.println("輸入 = " + input);
			try {
				System.out.println("第一階段 = " + Calculator.inputToSequence(input));
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("輸入 Y 繼續，任意鍵離開");
			again = sc.next();
			USE.Demarcation();
			USE.Demarcation();
		}

	}

}