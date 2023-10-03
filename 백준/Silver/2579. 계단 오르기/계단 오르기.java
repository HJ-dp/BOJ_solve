import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, arr[], dp[];
    public static int[] dr = {-1,-1,0};
    public static int[] dc = {0,-1,-1};
    public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N+1];
        dp = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        dp[0] = arr[0];
        dp[1] = arr[1] + arr[0];
        if(N>1){
            dp[2] = arr[2] + Math.max(dp[1],dp[0]);
            for(int i=3;i<=N;i++){
                dp[i] = Math.max(arr[i]+arr[i-1]+dp[i-3],arr[i]+dp[i-2]);
            }
        }
        System.out.println(dp[N]);
    }
}