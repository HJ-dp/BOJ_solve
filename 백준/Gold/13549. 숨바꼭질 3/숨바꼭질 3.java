import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, cnt, arr[] = new int[100001];
	public static boolean[] visited = new boolean[100001];
	public static Queue<Integer> q = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		push(N);
		BFS();
		System.out.println(sb);
	}

	public static void BFS(){
		while(!q.isEmpty()){
			int now = q.poll();
			if(now==M){
				sb.append(arr[now]);
				return;
			}
			int nowX = 2 * now;
			if(canGo(nowX)){
				push(nowX);
				arr[nowX] = arr[now];
			}
			int[] dr = {-1,1};
			for(int d=0;d<2;d++){
				nowX = now + dr[d];
				if(canGo(nowX)){
					push(nowX);
					arr[nowX] = arr[now]+1;
				}
			}
			cnt++;
		}
	}

	public static void push(int x){
		visited[x] = true;
		q.add(x);
	}

	public static boolean isRange(int x){
		return 0 <= x && x < 100001;
	}

	public static boolean canGo(int x){
		if(!isRange(x)||visited[x]){return false;}
		return true;
	}
}