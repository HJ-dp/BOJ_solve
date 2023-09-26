import java.io.*;
import java.util.*;

public class Main {
	public static int n, m, cnt=1, map[][], visited[][];
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	public static Queue<Node> q = new LinkedList<>();
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		map = new int[n][m];
		visited = new int[n][m];
		for(int i=0;i<n;i++) {
			temp = bf.readLine().split("");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		push(0,0);
		BFS();
		
		System.out.print(visited[n-1][m-1]);
	}
	
	public static void push(int x,int y) {
		visited[x][y] = cnt;
		q.add(new Node(x,y));
	}
	
	public static boolean isRange(int x,int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}
	
	public static boolean canGo(int x,int y) {
		if(!isRange(x,y)) {return false;}
		else if(map[x][y]==0 || visited[x][y]!=0) {
			return false;
		}
		return true;
	}

	public static void BFS() {
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			for(int d=0;d<4;d++) {
				cnt = visited[now.x][now.y]+1;
				int nowX = now.x + dr[d];
				int nowY = now.y + dc[d];
				if(canGo(nowX,nowY)) {
					push(nowX,nowY);
				}
			}
		}
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