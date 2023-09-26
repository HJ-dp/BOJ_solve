import java.io.*;
import java.util.*;

public class Main {
	public static int n, m, r;
	public static boolean[] visited;
	public static ArrayList<Integer>[] li;
	public static Queue<Integer> q = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		r = Integer.parseInt(temp[2]);
		li = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; i++) {
			li[i] = new ArrayList<>();
		}
		for (int t = 0; t < m; t++) {
			temp = bf.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			li[a].add(b);
			li[b].add(a);
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(li[i]);
		}
		
		visited = new boolean[n + 1];
		visited[r] = true;
		sb.append(r).append(" ");
		DFS(r);
		sb.append("\n");
		visited = new boolean[n + 1];
		visited[r] = true;
		q.add(r);
		BFS();
		
		System.out.print(sb);
	}

	public static void DFS(int x) {
		for (int i : li[x]) {
			if (!visited[i]) {
				sb.append(i).append(" ");
				visited[i] = true;
				DFS(i);
			}
		}
	}

	public static void BFS() {
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");
			for(int i : li[now]) {
				if(!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
}