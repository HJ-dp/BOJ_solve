import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static ArrayList<Integer>[] graph;
	public static boolean visited[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		graph = new ArrayList[N];
		for(int i=0;i<N;i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			String[] temp = bf.readLine().split(" ");
			for(int j=0;j<N;j++) {
				int a = Integer.parseInt(temp[j]);
				if(a==1) {
					graph[i].add(j);
				}
			}
		} // 입력끝
		
		for(int i=0;i<N;i++) {
			visited = new boolean[N];
			DFS(i);
			for(int j=0;j<N;j++) {
				if(visited[j]) {
					sb.append(1).append(" ");
				} else {
					sb.append(0).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	}
	
	public static void DFS(int x) {
		for(int i : graph[x]) {
			if(!visited[i]) {
				visited[i] = true;
				DFS(i);
			}
		}
	}
}