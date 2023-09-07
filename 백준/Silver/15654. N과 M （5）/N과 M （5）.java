import java.util.*;

public class Main {

	public static int N = 0;
	public static int M = 0;
	public static int[] arr;
	public static int[] answer;
	public static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		answer = new int[M];
		visited = new boolean[N];
		dfs(0,0);
		
	}
	
	public static void dfs(int x,int depth) {
		if (depth == M) {
			print();
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
			answer[x] = arr[i];
			visited[i] = true;
			dfs(x+1,depth+1);
			visited[i] = false;
			}
		}
	}

	public static void print() {
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		System.out.println();
	}

}