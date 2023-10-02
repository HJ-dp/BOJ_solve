import java.io.*;
import java.util.*;

public class Main {
	public static final int INF = Integer.MAX_VALUE;
	public static int N, M, P, max;
	public static ArrayList<Edge>[] arr;
	public static PriorityQueue<Edge> q = new PriorityQueue<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		P = Integer.parseInt(temp[2]);
		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int t = 0; t < M; t++) {
			temp = bf.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);
			arr[a].add(new Edge(b, c));
		}
        for(int i=1;i<=N;i++){
            int a = iks(i,P) + iks(P,i);
            max = Math.max(a,max);
        }
        System.out.println(max);
	}

	public static int iks(int x, int y) {
		int[] ans = new int[N + 1];
		q.add(new Edge(x, 0));
		Arrays.fill(ans, INF);
		ans[x] = 0;
		while (!q.isEmpty()) {
			Edge now = q.poll();
			for (Edge i : arr[now.x]) {
				if (ans[i.x] > i.y + ans[now.x]) {
					ans[i.x] = i.y + ans[now.x];
					q.add(new Edge(i.x,ans[i.x]));
				}
			}
		}
		return ans[y];
	}

	static class Edge implements Comparable<Edge>{
		int x, y;

		public Edge(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Edge o) {
			return this.y - o.y;
		}
	}
}