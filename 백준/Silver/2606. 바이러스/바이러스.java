import java.io.*;
import java.util.*;

public class Main {
	public static int n, m, cnt, map[][];
	public static boolean[] visited;
	public static List<Integer>[] li;
	public static Queue<Integer> q = new LinkedList<>();

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());
		li = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			li[i] = new ArrayList<>();
		}
		visited = new boolean[n+1];
		for (int i = 0; i < m; i++) {
			String[] temp = bf.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			li[a].add(b);
			li[b].add(a);
		}
		q.add(1);
		visited[1] = true;
		BFS();

		System.out.print(cnt);
	}

	public static void BFS() {
		while (!q.isEmpty()) {
			int n = q.poll();
			for(int i : li[n]) {
				if(!visited[i]) {
					cnt++;
					visited[i]= true;
					q.add(i);
				}
			}
		}
	}
}