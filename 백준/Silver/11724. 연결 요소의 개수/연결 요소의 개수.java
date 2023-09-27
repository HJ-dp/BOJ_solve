import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, cnt, max;
	public static ArrayList<Integer>[] graph;
	public static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		graph = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];

		for (int i = 0; i < M; i++) {
			temp = bf.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			graph[a].add(b);
			graph[b].add(a);
		} // 입력끝

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				DFS(i);
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	public static void DFS(int x) {
		visited[x] = true;
		for (int i : graph[x]) {
			if (!visited[i]) {
				DFS(i);
			}
		}

	}

}