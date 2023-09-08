import java.util.Arrays;
import java.util.*;

public class Main {
	public static int n, m, min, arr[], ans[];
	public static StringBuilder sb = new StringBuilder();
	public static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		ans = new int[m];
		visited = new boolean[n];
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
			if(!visited[i] && !hashset.contains(arr[i]) && arr[i]>=min) {
				ans[depth] = arr[i];
                min = arr[i];
				visited[i]=true;
                hashset.add(arr[i]);
				dfs(depth+1);
                visited[i]=false;
                min=0;
			}
		}
	}
}