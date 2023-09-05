import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int[] stack;
	public static int size;

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 실행횟수
		int T = Integer.parseInt(bf.readLine());
		stack = new int[T];
		size = 0;
		StringBuilder sb = new StringBuilder();
		// 명령 실행
		for (int i = 0; i < T; i++) {
			String[] input = bf.readLine().split(" ");
			int c = Integer.parseInt(input[0]);
			switch (c) {
			case 1:
				push(Integer.parseInt(input[1]));
				break;
			case 2:
				int a = pop();
				sb.append(a).append("\n");
				break;
			case 3:
				sb.append(size).append("\n");
				break;
			case 4:
				sb.append(isEmpty()).append("\n");
				break;
			case 5:
				sb.append(peek()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

	public static void push(int n) {
		stack[size++] = n;
	}

	public static int pop() {
		if (size > 0) {
			return stack[size-- - 1];
		}
		return -1;
	}

	public static int isEmpty() {
		if (size > 0) {
			return 0;
		}
		return 1;
	}

	public static int peek() {
		if (isEmpty()==1) {
			return -1;
		}
		return stack[size - 1];
	}
}