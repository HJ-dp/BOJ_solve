import java.util.*;
import java.math.*;

public class Main {
    public static int N;
    public static String dp[] = new String[1001];
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(dp,"-1");
        try{
            while(true){
                N = sc.nextInt();
                dp[0] = "1";
                dp[1] = "1";
                dp[2] = "3";
                for(int i=3;i<=N;i++){
                    fibo(i);
                }
                sb.append(dp[N]).append("\n");

            }
        } catch(Exception e){
            System.out.println(sb);
        }
    }

    public static void fibo(int x){
        if(dp[x]!="-1"){return;}
        BigInteger dp1 = new BigInteger(dp[x-1]);
        BigInteger dp2 = new BigInteger(dp[x-2]);
        BigInteger Num2 = new BigInteger("2");
        dp2 = dp2.multiply(Num2);
        dp[x] = (dp1.add(dp2)).toString();
        // return dp[x];
    }
}