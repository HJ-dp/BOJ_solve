import java.io.*;
import java.util.*;

public class Main {
	public static int F, N, M, time, map[][][];
	//북동남서 상하  
	public static int[] df = {0,0,0,0,1,-1};
	public static int[] dr = {-1,0,1,0,0,0};
	public static int[] dc = {0,1,0,-1,0,0};
	
	public static StringBuilder sb = new StringBuilder();
	public static Queue<Node> q;
	public static boolean answer, visited[][][];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] temp = bf.readLine().split(" ");
			F = Integer.parseInt(temp[0]);
			N = Integer.parseInt(temp[1]);
			M = Integer.parseInt(temp[2]);
			if(F == 0 && N == 0 && M == 0) {break;}
			map = new int[F][N][M];
			visited = new boolean[F][N][M];
			time = 0;
			answer = false;
			q = new LinkedList<>();
			for(int t=F-1;t>=0;t--) {
				for(int i=0;i<N;i++) {
					temp = bf.readLine().split("");
					for(int j=0;j<M;j++) {
						String s = temp[j];
						if(s.equals("S")) {
							push(t,i,j);
							map[t][i][j]=0;
						} else if (s.equals(".")) {
							map[t][i][j]=0;
						} else if (s.equals("#")) {
							map[t][i][j]=1;
						} else if (s.equals("E")) {
							map[t][i][j]=-1;
						}
					}
				}
				
				bf.readLine();
			}
			// 입력끝
			BFS();
			// for(int t =F-1;t>=0;t--){
			// for(int i=0;i<N;i++){
			// 		System.out.println(Arrays.toString(map[t][i]));
			// 	}
			// 	System.out.println();
			// }

			if(answer) {
				sb.append("Escaped in ").append(time).append(" minute(s).").append("\n");
			} else {
				sb.append("Trapped!").append("\n");
			}
			
		}
		System.out.println(sb);

	}
	public static void push(int f,int x, int y) {
		if(canGo(f,x,y)) {
			visited[f][x][y] = true;
			q.add(new Node(f,x,y));
		}
	}
	
	public static void BFS() {
		while(!q.isEmpty()) {
			Node now = q.poll();
			for(int d=0;d<6;d++) {
				int nowF = now.floor + df[d];
				int nowX = now.x + dr[d];
				int nowY = now.y + dc[d];
				if(canGo(nowF,nowX,nowY)) {
					if (map[nowF][nowX][nowY]==-1) {
						time= map[now.floor][now.x][now.y]+1;
						answer = true;
						return;
					}
					push(nowF,nowX,nowY);
					map[nowF][nowX][nowY] = map[now.floor][now.x][now.y]+1;
				}
			}
		}
	}
	
	public static boolean isRange(int f,int x,int y) {
		return 0 <= f && f < F && 0<= x && x < N && 0<= y && y < M;
	}
	
	public static boolean canGo(int f,int x,int y) {
		if(!isRange(f,x,y)) {return false;}
		else if(map[f][x][y]==1 || visited[f][x][y]) {
			return false;
		}
		return true;
	}

	static class Node {
		int floor;
		int x;
		int y;

		public Node(int f, int x, int y) {
			this.floor = f;
			this.x = x;
			this.y = y;
		}
	}

}