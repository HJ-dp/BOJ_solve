import java.io.*;
import java.util.*;

public class Main {
	public static int N, dp[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		dp = new int [N+1];
		for(int i=0;i<=N;i++){
			dp[i] = -1;
		}
		System.out.println(dp(N));
	}

	public static int dp(int x){
		if (x == 1) return 0;
		if (dp[x]!=-1) return dp[x];
		int result = dp(x-1)+1;
		if(x%3==0){result=Integer.min(result,dp(x/3)+1);}
		if(x%2==0){result=Integer.min(result,dp(x/2)+1);}
		dp[x] = result;
		return result;
	}
}