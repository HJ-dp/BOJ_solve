import java.io.*;
import java.util.*;

public class Main {
	public static int N, max, arr[][], ans[][];
    public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        ans = new int[N][N];
        for(int i=0;i<N;i++){
            String[] temp = bf.readLine().split(" ");
            for(int j=0;j<i+1;j++){
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        ans[0][0] = arr[0][0];
        for(int i=0;i<N-1;i++){
            for(int j=0;j<=i;j++){
                ans[i+1][j] = Math.max(ans[i+1][j], ans[i][j]+arr[i+1][j]);
                ans[i+1][j+1] = Math.max(ans[i+1][j+1], ans[i][j]+arr[i+1][j+1]);
            }
        }
        for(int i=0;i<N;i++){
            max = Math.max(ans[N-1][i],max);
        }

        System.out.println(max);
        //입력 끝
    }
}