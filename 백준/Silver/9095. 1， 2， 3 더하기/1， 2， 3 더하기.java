import java.io.*;
import java.util.*;

public class Main {
	public static int N, arr[] = new int[12];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3;i<=11;i++){
            dp(i);
        }

		for(int t=1;t<=N;t++){
            int a = Integer.parseInt(bf.readLine());
            System.out.println(arr[a]);
        }//입력 끝
    }

    public static int dp(int x){
        if (arr[x]!=0){
            return arr[x];
        }
        arr[x] = arr[x-1] + arr[x-2] + arr[x-3];
        return arr[x];
    }
}