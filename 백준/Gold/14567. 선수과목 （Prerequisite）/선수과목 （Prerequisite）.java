import java.io.*;
import java.util.*;

public class Main {
	// 정점 기록
	public static ArrayList<Integer>[] edges;
	// 위상정렬 순서 기록 큐
	public static Queue<Integer> q = new LinkedList<>();
	public static int indegree[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		// 정점 기록
		edges = new ArrayList[n + 1];
		// 진입차수 기록
		indegree = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			// 정점별 간선 기록
			edges[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			temp = bf.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			// a정점에서 이어지는 정점
			edges[a].add(b);
			// b정점의 진입차수 더하기
			indegree[b]++;
		}
		int sum = 1;
		int[] answer = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			if (indegree[i] == 0) {
				q.add(i);
				answer[i] = sum;
			}
		}
		while (!q.isEmpty()) {
			int t = q.poll();
			for (int i = 0; i < edges[t].size(); i++) {
				// 현재 정점에서 갈 수 있는 애들의 진입차수 빼기
				int y = edges[t].get(i);
				indegree[y]--;
				if (indegree[y] == 0) {
					answer[y] = answer[t]+1;
					q.add(y);
				}
			} // 연결끊는 작업
		}

		for (int i = 1; i < n + 1; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.print(sb);
	}
}