import java.util.*;

public class Main {
	public static int N, M, K, cnt, map[][];
	public static boolean visited[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			M = sc.nextInt();
			N = sc.nextInt();
			if (N == 0 && M == 0) {
				break;
			}
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			cnt=0;
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						DFS(i, j);
						cnt++;
					}
				}
			}
			System.out.printf("%d\n", cnt);
		}
	}

	public static void DFS(int x, int y) {
		int[] dr = { -1, 0, 1, 0, -1, -1, 1, 1 };
		int[] dc = { 0, 1, 0, -1, -1, 1, 1, -1 };
		visited[x][y] = true;
		for (int d = 0; d < 8; d++) {
			int nowX = x + dr[d];
			int nowY = y + dc[d];
			if (canGo(nowX, nowY)) {
				DFS(nowX, nowY);
			}
		}

	}

	public static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	public static boolean canGo(int x, int y) {
		if (!isRange(x, y)) {
			return false;
		} else if (visited[x][y] || map[x][y] == 0) {
			return false;
		}
		return true;
	}
}