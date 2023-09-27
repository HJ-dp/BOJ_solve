import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, K, cnt, map[][];
	public static boolean visited[][];
	public static ArrayList<Integer> answer = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		M = Integer.parseInt(temp[0]);
		N = Integer.parseInt(temp[1]);
		K = Integer.parseInt(temp[2]);
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int t = 0; t < K; t++) {
			temp = bf.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);
			int d = Integer.parseInt(temp[3]);
			for(int i=a;i<c;i++) {
				for(int j=b;j<d;j++) {
					map[i][j] = 1;
				}
			}
		} // 입력끝

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if (map[i][j]==0 && canGo(i,j)){
					DFS(i,j);
					answer.add(cnt);
					cnt =0;
				}
			}
		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for(int i=0;i<answer.size();i++){
			System.out.print(answer.get(i)+" ");
		}
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
		else if(map[x][y]==1 || visited[x][y]){
			return false;
		}
		return true;
	}

}