import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int N, cnt, map[][];
	public static List<Integer> arr = new ArrayList<>();
	public static boolean visited[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] temp = sc.next().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					DFS(i, j);
					arr.add(cnt);
					cnt = 0;
				}
			}
		}
		System.out.println(arr.size());
		Collections.sort(arr);
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

	public static void DFS(int x, int y) {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		visited[x][y] = true;
		cnt++;
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
		if (!isRange(x, y)) {
			return false;
		} else if (visited[x][y] || map[x][y] == 0) {
			return false;
		}
		return true;
	}
}