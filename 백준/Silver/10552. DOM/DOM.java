import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, K, cnt;
	public static ArrayList<Integer>[] graph;
	public static boolean visited[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		K = Integer.parseInt(temp[2]);
		graph = new ArrayList[M+1];
		visited = new boolean[M+1];
		for(int i=1;i<=M;i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			temp = bf.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			graph[b].add(a);
		} // 입력끝
		DFS(K);
	}
	
	public static void DFS(int x) {
		if(!visited[x]) {
			if(graph[x].size()==0){
				System.out.println(cnt);
				return;
			}
			visited[x] = true;
			cnt++;
			DFS(graph[x].get(0));
		} else {
			System.out.println(-1);
			return;
		}
	}
}