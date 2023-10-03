import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, arr[][], ans[][];
    public static int[] dr = {-1,-1,0};
    public static int[] dc = {0,-1,-1};
    public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        arr = new int[N][M];
        ans = new int[N][M];
        for(int i=0;i<N;i++){
            temp = bf.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        //입력 끝
        ans[0][0] = arr[0][0];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(i==0 && j==0){continue;}
                int max = 0;
                for(int d=0;d<3;d++){
                    int nx = i + dr[d];
                    int ny = j + dc[d];
                    if(isRange(nx,ny)){
                        max = Math.max(ans[nx][ny]+arr[i][j],max); 
                    }
                }
                ans[i][j] = max;
            }
        }

        System.out.println(ans[N-1][M-1]);
    }

    public static boolean isRange(int x,int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}