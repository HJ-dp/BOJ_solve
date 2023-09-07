import java.util.*;

public class Main {

	public static int N = 0;
	public static int M = 0;
	public static int[] arr;
	public static int[] answer;
	public static boolean[] visited;
	public static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		answer = new int[M];
		visited = new boolean[N];
		dfs(0);
		System.out.println(sb);
	}

	public static void dfs(int k) {
		if (k == M) {
			print();
			return;
		}
		for (int i = 0; i < N; i++) {
			answer[k] = arr[i];
			dfs(k + 1);
		}
	}

	public static void print() {
		for (int i = 0; i < answer.length; i++) {
			sb.append(answer[i]).append(" ");
		}
		sb.append("\n");
	}

}