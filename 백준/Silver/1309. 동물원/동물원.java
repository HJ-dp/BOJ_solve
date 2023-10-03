import java.io.*;
import java.util.*;

public class Main {
    public static final int MOD = 9901;
	public static int N, dp[];
    public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 3;
        for(int i=2;i<=N;i++){
            dp[i] = ((2 * dp[i-1]) + dp[i-2]) % MOD;
        }

        System.out.println(dp[N]);
    }
}