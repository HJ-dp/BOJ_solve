import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static int N, M, cnt, max;
	public static boolean visited[][];
	public static String arr[][];
	public static HashSet<String> hs = new HashSet<>();
	public static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		arr = new String[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			temp = bf.readLine().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = temp[j];
			}
		}
		DFS(0,0);
		System.out.println(max);
	}

	public static void DFS(int x, int y) {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		
		visited[x][y] = true;
		hs.add(arr[x][y]);
		cnt++;
		if(max<cnt) {
			max = cnt;
		}
//		System.out.println(cnt);
//		System.out.println(arr[x][y]);
		for (int d = 0; d < 4; d++) {
			int nowX = x + dr[d];
			int nowY = y + dc[d];
			if (canGo(nowX, nowY)) {
				DFS(nowX, nowY);
				
			}
		}
		cnt--;
		hs.remove(arr[x][y]);
		visited[x][y] = false;
		
		
	}

	public static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	public static boolean canGo(int x, int y) {
		if (!isRange(x, y)) {
			return false;
		} else if (hs.contains(arr[x][y])|| visited[x][y]) {
			return false;
		}
		return true;
	}

}