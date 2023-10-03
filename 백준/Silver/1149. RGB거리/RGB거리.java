import java.io.*;
import java.util.*;

public class Main {
	public static int N, min, arr[][], ans[][];
    public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
        arr = new int[N][3];
        ans = new int[N][3];
        min = Integer.MAX_VALUE;
        String[] temp = bf.readLine().split(" ");
        arr[0][0] = Integer.parseInt(temp[0]);
        arr[0][1] = Integer.parseInt(temp[1]);
        arr[0][2] = Integer.parseInt(temp[2]);
        for(int i=1;i<N;i++){
            temp = bf.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            arr[i][0] = Math.min(arr[i-1][1]+a,arr[i-1][2]+a);
            int b = Integer.parseInt(temp[1]);
            arr[i][1] = Math.min(arr[i-1][0]+b,arr[i-1][2]+b);
            int c = Integer.parseInt(temp[2]);
            arr[i][2] = Math.min(arr[i-1][0]+c,arr[i-1][1]+c);
        }
        for(int i=0;i<3;i++){
            min = Math.min(arr[N-1][i],min);
        }
        System.out.println(min);
        //입력 끝
    }
}