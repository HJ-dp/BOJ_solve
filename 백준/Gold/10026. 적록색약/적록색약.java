import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N, cnt;
	public static boolean shift, visited[][];
	public static String now, arr[][];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new String[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] temp = bf.readLine().split("");
			for (int j = 0; j < N; j++) {
				arr[i][j] = temp[j];
			}
		}
		for(int k=0;k<2;k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					now = arr[i][j];
					if (canGo(i, j)) {
						DFS(i, j);
						cnt++;
					}
				}
			}
			System.out.print(cnt +" ");
			visited = new boolean[N][N];
			cnt = 0;
			shift = true;
		}

	}

	public static void DFS(int x, int y) {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		visited[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nowX = x + dr[d];
			int nowY = y + dc[d];
			if (canGo(nowX, nowY)) {
				DFS(nowX, nowY);
			}
		}
	}

	public static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	public static boolean canGo(int x, int y) {
		if (!isRange(x, y)|| visited[x][y]) {
			return false;
		} 
		else if (shift &&!visited[x][y] && (arr[x][y].equals("R") && now.equals("G") || arr[x][y].equals("G") && now.equals("R"))) {
			return true;
		}
		else if (!arr[x][y].equals(now)) {
			return false;
		}
		return true;
	}

}