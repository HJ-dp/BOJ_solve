import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		long[] arr = new long[1001];
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2;i<=N;i++){
			arr[i] = ((long)arr[i-1] + (long)arr[i-2])%10007;
		}
		System.out.println(arr[N]%10007);
	}
}