import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, K,cnt,max;
	public static String[][] map;
	public static boolean visited[][];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		K = Integer.parseInt(temp[2]);
		map = new String[N][M];
		for(int i=0;i<N;i++){
			Arrays.fill(map[i], ".");
		}
		visited = new boolean[N][M];
		
		for(int i=0;i<K;i++) {
			temp = bf.readLine().split(" ");
			int a = Integer.parseInt(temp[0])-1;
			int b = Integer.parseInt(temp[1])-1;
			map[a][b] = "#";
		}//입력끝
		
        for(int i = 0;i<N;i++){
            for(int j=0;j<M;j++){
            	if(canGo(i,j)) {
					cnt = 0;
            		DFS(i,j);
            	}
            }
        }

		System.out.println(max);

	}
	
	public static void DFS(int x,int y) {
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		visited[x][y] = true;
		cnt++;
		if(max < cnt) {max = cnt;}
		for(int d=0;d<4;d++) {
			int nowX = x + dr[d];
			int nowY = y + dc[d];
			if(canGo(nowX,nowY)) {
				DFS(nowX,nowY);
			}
		}
		
	}

	public static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	public static boolean canGo(int x, int y) {
		if (!isRange(x, y)) {
			return false;
		} else if (map[x][y].equals(".") || visited[x][y]) {
			return false;
		}
		return true;
	}

	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}