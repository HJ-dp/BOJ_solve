import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		System.out.println(ihang(N,M));
	}

	public static int ihang(int i,int j) {
		if (j==0) return 1;
		else if (i < j) return 0;
		int a = ihang(i-1,j-1) + ihang(i-1,j);
		return a;
	}
}