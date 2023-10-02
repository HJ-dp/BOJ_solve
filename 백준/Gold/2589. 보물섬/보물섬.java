import java.util.*;
import java.io.*;

public class Main {
	public static int N, M, max, map[][], dist[][];
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	public static boolean visited[][];
	public static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//맵 크기
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);

		//맵 입력받기
		map = new int[N][M];
		
		for(int i=0;i<N;i++){
			temp = bf.readLine().split("");
			for(int j=0;j<M;j++){
				switch (temp[j]){
					case "W":
					map[i][j] = 0;
					break;
					case "L":
					map[i][j] = 1;
					break;
				}
			}
		}// 입력 끝 
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				dist = new int[N][M];
				visited = new boolean[N][M];
				if(canGo(i,j)){
					push(i,j);
				}
				BFS();
			}
		}
		System.out.println(max);
    }

	public static void push(int x,int y){
		visited[x][y] = true;
		q.add(new Node(x,y));
	}

	public static void BFS(){
		int cnt = 0;
		while(!q.isEmpty()){
			Node now = q.poll();
			for(int d=0;d<4;d++){
				int nx = now.x + dr[d];
				int ny = now.y + dc[d];
				if(canGo(nx,ny)){
					dist[nx][ny] = dist[now.x][now.y] +1;
					cnt = Math.max(dist[nx][ny],cnt);
					push(nx,ny);
				}
			}
		}
		max = Math.max(max,cnt);
	}

	public static boolean isRange(int x,int y){
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	public static boolean canGo(int x,int y){
		if(!isRange(x,y)){return false;}
		else if(map[x][y]==0 || visited[x][y]){return false;}
		return true;
	}

	static class Node{
		int x,y;
		public Node(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}