import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static int n, m, r, cnt = 1, answer[];
	public static boolean[] visited;
	public static ArrayList<Integer>[] li;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		r = Integer.parseInt(temp[2]);
		li = new ArrayList[n + 1];
		answer = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			li[i] = new ArrayList<>();
		}
		visited = new boolean[n + 1];
		for (int t = 0; t < m; t++) {
			temp = bf.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			li[a].add(b);
			li[b].add(a);
		}
		visited[r] = true;
		answer[r] = cnt++;
		DFS(r);

		for (int i = 1; i < n + 1; i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.print(sb);
	}

	public static void DFS(int x) {
		Collections.sort(li[x]);
		Collections.reverse(li[x]);
		for (int i : li[x]) {
			if (!visited[i]) {
				visited[i] = true;
				answer[i] = cnt++;
				DFS(i);
			}
		}
	}

}