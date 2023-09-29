import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, time, cnt, map[][];
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	public static Queue<Node> q = new LinkedList<>();
	public static Queue<Node> meltQ = new LinkedList<>();
	public static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		
		//맵 입력받기  
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			temp = bf.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}//입력 끝  
		
		while(true) {
			cnt=0;
			visited = new boolean[N][M];
			push(0,0);
			BFS();
			if(cnt==N*M) {break;}
			melting();
			time++;
		}
		System.out.println(time);
	}
	
	public static void melting() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) {
					int cnt = 0;
					for(int d=0;d<4;d++) {
						if(visited[i + dr[d]][j+dc[d]]) {cnt++;}
						if (cnt >= 2) {meltQ.add(new Node(i,j));break;}
					}
				}
			}
		}
		while(!meltQ.isEmpty()) {
			Node now = meltQ.poll();
			map[now.x][now.y] = 0;
		}
	}
	
	public static void push(int x,int y) {
		visited[x][y] = true;
		cnt++;
		q.add(new Node(x,y));
	}
	
	public static void BFS() {
		while(!q.isEmpty()) {
			Node now = q.poll();
			for(int d=0;d<4;d++) {
				int nowX = now.x + dr[d];
				int nowY = now.y + dc[d];
				if(canGo(nowX,nowY)) {
					push(nowX, nowY);
				}
			}
		}
	}
	
	public static boolean isRange(int x,int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
	
	public static boolean canGo(int x, int y) {
		if(!isRange(x,y)) return false;
		else if (map[x][y]==1 || visited[x][y]) return false;
		return true;
	}
	
	static class Node{
		int x;
		int y;
		public Node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}