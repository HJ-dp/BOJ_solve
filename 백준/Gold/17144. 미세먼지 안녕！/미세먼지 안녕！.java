import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, T, x1, y1, x2, y2, answer, map[][], tmp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		T = Integer.parseInt(temp[2]);
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			temp = bf.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				//공기청정기 위치 잡기
				if (map[i][j]==-1 && x1==0){
					x1 = i;
					y1 = j;
				} else if(map[i][j]==-1) {
					x2 = i;
					y2 = j;
				}
			}
		}//입력끝

		while(T-->0){
			tmp = new int[N][M];
			boom();
			vacum();
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(map[i][j]==-1){continue;}
				answer += map[i][j];
			}
		}
		System.out.println(answer);
	}

	public static void vacum(){
		int nowX = x1;
		int nowY = y1;
		int dust = 0;
		int tempDust = 0;
		int[] dr = {0,-1,0,1,0,1,0,-1};
		int[] dc = {1,0,-1,0,1,0,-1,0};
		for(int d=0;d<8;d++){
			if(d==4){
			nowX=x2;
			nowY=y2;
			dust = 0;
			tempDust = 0;
			}
			while(true){
				nowX += dr[d];
				nowY += dc[d];
				if(!isRange(nowX,nowY)){
					nowX -= dr[d];
					nowY -= dc[d];
					break;
				} else if (map[nowX][nowY]==-1){break;}
				tempDust = map[nowX][nowY];
				map[nowX][nowY] = dust;
				dust = tempDust;
			}
		}
	}
	
	public static void boom(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(map[i][j]!=0){
					dust(i,j);
				}
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				map[i][j] += tmp[i][j];
			}
		}
	}

	public static void dust(int x, int y){
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		int cnt = 0;
		for(int d=0;d<4;d++){
			int nowX = x + dr[d];
			int nowY = y + dc[d];
			if(canGo(nowX,nowY)){
				tmp[nowX][nowY] += map[x][y]/5;
				cnt++;
			}
		}
		map[x][y] -= (map[x][y]/5) * cnt;
	}

	public static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	public static boolean canGo(int x, int y) {
		if (!isRange(x, y)) {
			return false;
		} else if (map[x][y] == -1) {
			return false;
		}
		return true;
	}
}