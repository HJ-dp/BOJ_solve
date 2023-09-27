import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, max, size, cnt, map[][];
	public static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			temp = bf.readLine().split(" ");
			for(int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(temp[j]);
			}
		} // 입력끝

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if (map[i][j]==1 && canGo(i,j)){
					DFS(i,j);
					max = (max < cnt)? cnt : max;
					cnt =0;
					size++;
				}
			}
		}
		System.out.println(size);
		System.out.println(max);
	}

	public static void DFS(int x,int y){
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		visited[x][y] = true;
		cnt++;
		for(int d=0;d<4;d++){
			int nowX = x + dr[d];
			int nowY = y + dc[d];
			if(canGo(nowX,nowY)){
				DFS(nowX,nowY);
			}
		}
	}

	public static boolean isRange(int x,int y){
		return 0 <= x && x < N && 0 <= y && y < M;
	}
	
	public static boolean canGo(int x,int y){
		if(!isRange(x,y)){return false;}
		else if(map[x][y]==0 || visited[x][y]){
			return false;
		}
		return true;
	}

}