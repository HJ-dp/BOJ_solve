import java.util.*;

public class Main {

	public static int N = 0;
	public static int M = 0;
	public static int[] arr;
	public static int[] answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		answer = new int[M];
		let(0, 0);
	}

	public static void let(int a, int d) {
		if (d == M) {
			print();
			return;
		} else if(a == N)
			return;
		answer[d] = arr[a];
		let(a,d+1);
		let(a+1,d);
	}

	public static void print() {
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		System.out.println();
	}

}