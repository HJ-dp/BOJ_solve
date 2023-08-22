import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int num = 1;
		Stack<Integer> stack = new Stack<>();
		// 배열 입력받기
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i =0;i<n;i++) {
			if(num == arr[i]) {
				num++;
			}
			if (!stack.isEmpty() && stack.peek()==num) {
				while(!stack.isEmpty()) {
					if (stack.peek()!=num) {break;}
					  stack.pop();
					  num++;
					  
				}
			} else if (arr[i] >= num){
				stack.add(arr[i]);
			}
		}
		
		String answer = (stack.isEmpty()) ? "Nice" : "Sad";
		System.out.println(answer);
	}
}
