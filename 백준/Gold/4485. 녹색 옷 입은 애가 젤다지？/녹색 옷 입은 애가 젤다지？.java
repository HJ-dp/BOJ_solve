import java.io.*;
import java.util.*;

public class Main {
	public static int N, tc, map[][], step[][];
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	public static PriorityQueue<Node> q = new PriorityQueue<>();
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			N = Integer.parseInt(bf.readLine());
			tc++;
			if(N==0){break;}
			map = new int[N][N];
			step = new int[N][N];
			for(int i=0;i<N;i++){
				Arrays.fill(step[i],-1);
			}
			for(int i=0;i<N;i++){
				String[] temp = bf.readLine().split(" ");
				for(int j=0;j<N;j++){
					map[i][j] = Integer.parseInt(temp[j]);
				}
			}
			// 입력끝
			// step[0][0] = map[0][0];
			q.add(new Node(0,0,map[0][0]));
			daik();
			sb.append("Problem ").append(tc+": ").append(step[N-1][N-1]).append("\n");
		}
		System.out.println(sb);

	}

	public static void daik() {
		while(!q.isEmpty()){
			Node now = q.poll();
			if(step[now.x][now.y] == -1){
				step[now.x][now.y] = now.d;
			}
			for(int d=0;d<4;d++){
				int nx = now.x + dr[d];
				int ny = now.y + dc[d];
				if(isRange(nx,ny)){
					if(step[nx][ny] == -1){
						step[nx][ny] = map[nx][ny] + step[now.x][now.y];
						q.add(new Node(nx,ny,step[nx][ny]));
					} else {
						step[nx][ny] = Math.min(step[nx][ny],map[nx][ny] + step[now.x][now.y]);
					}
				}
			}
		}
	}

	public static boolean isRange(int x,int y){
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	static class Node implements Comparable<Node>{
		int x, y, d;
		public Node(int x,int y,int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Node n){
			if(this.d==n.d){return 0;}
			return  this.d - n.d;
		}
	}
}