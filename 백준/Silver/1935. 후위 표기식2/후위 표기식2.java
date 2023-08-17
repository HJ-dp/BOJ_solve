import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('(', 0);
		priority.put('-', 1);
		priority.put('+', 1);
		priority.put('/', 2);
		priority.put('*', 2);

		Map<Character, Integer> abc = new HashMap<>();
		int n = sc.nextInt();
		// 식 입력받기
		String s = sc.next();
		// 만들어질 식
		ArrayList<String> fix = new ArrayList<>();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		// 계산식만큼 반복문
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// + 연산자라면
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				fix.add(Character.toString(c));
			} else {
				int t = (int) c;
				if (abc.get(c) == null) {
					abc.put(c, arr[t - 65]);
					fix.add(Integer.toString(abc.get(c)));
				} else {
					fix.add(Integer.toString(abc.get(c)));
				}
			}
		}
		// 후위표기 계산
		Stack<Double> stack2 = new Stack<>();
		int m = fix.size();
		for (int i = 0; i < m; i++) {
			if (fix.get(i).equals("+")) {
				Double b2 = stack2.pop();
				Double a2 = stack2.pop();
				stack2.add(a2 + b2);
			} else if (fix.get(i).equals("*")) {
				Double b2 = stack2.pop();
				Double a2 = stack2.pop();
				stack2.add(a2 * b2);
			} else if (fix.get(i).equals("-")) {
				Double b2 = stack2.pop();
				Double a2 = stack2.pop();
				stack2.add(a2 - b2);
			} else if (fix.get(i).equals("/")) {
				Double b2 = stack2.pop();
				Double a2 = stack2.pop();
				stack2.add(a2 / b2);
			} else {
				stack2.add(Double.parseDouble(fix.get(i)));
			}
		}
		double answer = stack2.pop();
		System.out.printf("%.2f", answer);
	}

}