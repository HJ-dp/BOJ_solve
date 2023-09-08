import java.util.Arrays;
import java.util.*;

public class Main {
	public static int n, m, arr[], ans[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		ans = new int[m];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		if (depth==m) {
			for(int i=0;i<m;i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
        HashSet<Integer> hashset = new HashSet<>();
		for(int i=0;i<n;i++) {
			if(!hashset.contains(arr[i])) {
				ans[depth] = arr[i];
                hashset.add(arr[i]);
				dfs(depth+1);
			}
		}
	}
}