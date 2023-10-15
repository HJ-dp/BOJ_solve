import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, uf[];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		uf = new int[N+1];
		boolean check = false;

		for(int i=1;i<=N;i++){
			uf[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			String[] temp = bf.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				int x = Integer.parseInt(temp[j-1]);
				if (x == 1) {
                    union(i,j);
				}
			}
		}

		String[] temp = bf.readLine().split(" ");
		int y = find(Integer.parseInt(temp[0]));
		for (int j =1; j < M; j++) {
			int x = find(Integer.parseInt(temp[j]));
			if(x != y) {
				check=true;
				break;
			}
		}

		if (check) {
			sb.append("NO").append("\n");
		} else {
			sb.append("YES").append("\n");
		}
		System.out.println(sb);
	}

	public static void union(int x,int y){
		int X = find(x);
		int Y = find(y);
        if(X < Y){
            uf[Y] = X;
        } else {
            uf[X] = Y;
        }
	}

	public static int find(int x){
		if (uf[x]==x){
			return x;
		}
		int root = find(uf[x]);
		uf[x] = root;
		return root;
	}
}