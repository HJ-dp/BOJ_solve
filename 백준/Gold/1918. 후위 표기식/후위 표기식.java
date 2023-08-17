import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 1;

		Map<Character, Integer> priority = new HashMap<>();
		priority.put('(', 0);
		priority.put('-', 1);
		priority.put('+', 1);
		priority.put('/', 2);
		priority.put('*', 2);

		for (int test_case = 1; test_case <= T; test_case++) {
			// 식 입력받기
			String s = sc.next();
			// 만들어질 식
			String fix = "";
			Stack<Character> stack = new Stack<>();
			// 계산식만큼 반복문
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				// + 연산자라면
				if (c == '(') {
					// 무조건 넣는거 아닌ㄴ가?
					stack.push(c);
					// 닫는괄호는 여는 괄호를 만날때까지 팝 하기
				} else if (c == ')') {
					while (!stack.isEmpty() && stack.peek() != '(') {
						fix += stack.pop();
					}
					stack.pop();
				} else if (c == '+') {
					// 스택이 비었으면 넣기
					if (stack.isEmpty() || !(priority.get(stack.peek()) >= priority.get(c))) {
						stack.push(c);
						// 스택 탑의 우선순위가 +와 같거나 높으면
					} else if (priority.get(stack.peek()) >= priority.get(c)) {
						// 스택 탑의 우선순위가 낮을때까지 팝
						while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(c)) {
							fix += stack.pop();
						}
						stack.push(c);
					}
				} else if (c == '-') {
					// 스택이 비었으면 넣기
					if (stack.isEmpty() || !(priority.get(stack.peek()) >= priority.get(c))) {
						stack.push(c);
						// 스택 탑의 우선순위가 -와 같거나 높으면
					} else if (priority.get(stack.peek()) >= priority.get(c)) {
						// 스택 탑의 우선순위가 낮을때까지 팝
						while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(c)) {
							fix += stack.pop();
						}
						stack.push(c);
					}
				} else if (c == '*') {
					// 스택이 비었으면 넣기
					if (stack.isEmpty() || !(priority.get(stack.peek()) >= priority.get(c))) {
						stack.push(c);
						// 스택 탑의 우선순위가 *와 같거나 높으면
					} else if (priority.get(stack.peek()) >= priority.get(c)) {
						// 스택 탑의 우선순위가 낮을때까지 팝
						while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(c)) {
							fix += stack.pop();
						}
						stack.push(c);
					}
				} else if (c == '/') {
					// 스택이 비었으면 넣기
					if (stack.isEmpty() || !(priority.get(stack.peek()) >= priority.get(c))) {
						stack.push(c);
						// 스택 탑의 우선순위가 /와 같거나 높으면
					} else if (priority.get(stack.peek()) >= priority.get(c)) {
						// 스택 탑의 우선순위가 낮을때까지 팝
						while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(c)) {
							fix += stack.pop();
						}
						stack.push(c);
					}
				}else {
					fix += c;
				}
			}
			// 스택에 남은것 까지
			while (!stack.isEmpty()) {
				fix += stack.pop();
			}
			System.out.println(fix);
		}
	}
}
