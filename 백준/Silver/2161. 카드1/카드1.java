import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 큐 선언
		Queue<Integer> queue = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		// 1~n 배열 생성
		for (int i = 1; i < n + 1; i++) {
			queue.add(i);
		}
		// 큐의 요소가 하나 남을때까지 팝과 뒤로보내기 반복
		while (queue.size() != 1) {
			System.out.print(queue.poll()+" ");
			int temp = queue.poll();
			queue.add(temp);
		}

		System.out.println(queue.poll());
	}
}