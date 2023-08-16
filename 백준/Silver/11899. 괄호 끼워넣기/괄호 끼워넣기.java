import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		// 스택선언
		String[] stack = new String[50];
		int size = 0;
		// 입력받기
		String s = sc.next();
		String[] arr = s.split("");
		for (int i = 0; i < arr.length; i++) {
			if (size == 0) {
				stack[size++] = arr[i];
			} else if (stack[size-1].equals("(") && arr[i].equals(")")) {
				size--;
			} else {
				stack[size++] = arr[i];
			}
		}
		System.out.print(size);
	}
}