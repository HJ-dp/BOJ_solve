import java.io.*;
import java.util.*;

public class Main {
	public static int F, N, M, time, max, map[][][];
	// 북동남서 상하
	public static int[] df = { 0, 0, 0, 0, 1, -1 };
	public static int[] dr = { -1, 0, 1, 0, 0, 0 };
	public static int[] dc = { 0, 1, 0, -1, 0, 0 };

	public static StringBuilder sb = new StringBuilder();
	public static Queue<Node> q;
	public static boolean answer, visited[][][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		M = Integer.parseInt(temp[0]);
		N = Integer.parseInt(temp[1]);
		F = Integer.parseInt(temp[2]);
		map = new int[F][N][M];
		visited = new boolean[F][N][M];
		answer = true;
		q = new LinkedList<>();
		for (int t = 0; t < F; t++) {
			for (int i = 0; i < N; i++) {
				temp = bf.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					map[t][i][j] = Integer.parseInt(temp[j]);
				}
			}
		} // 입력끝
		for (int t = 0; t < F; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[t][i][j]==1) {
						push(t,i,j);
					}
				}
			}
		}
		BFS();
		for (int t = 0; t < F; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[t][i][j]==0) {
						answer = false;
					}
				}
			}
		}
		max = (answer)? max:-1;
		System.out.println(max);

	}

	public static void push(int f, int x, int y) {
		if (canGo(f, x, y)) {
			visited[f][x][y] = true;
			q.add(new Node(f, x, y));
		}
	}

	public static void BFS() {
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int d = 0; d < 6; d++) {
				int nowF = now.floor + df[d];
				int nowX = now.x + dr[d];
				int nowY = now.y + dc[d];
				if (canGo(nowF, nowX, nowY)) {
					push(nowF, nowX, nowY);
					map[nowF][nowX][nowY] = map[now.floor][now.x][now.y] + 1;
					max = (max < map[nowF][nowX][nowY])? map[nowF][nowX][nowY]-1 : max;
				}
			}
		}
	}

	public static boolean isRange(int f, int x, int y) {
		return 0 <= f && f < F && 0 <= x && x < N && 0 <= y && y < M;
	}

	public static boolean canGo(int f, int x, int y) {
		if (!isRange(f, x, y)) {
			return false;
		} else if (map[f][x][y] ==-1 || visited[f][x][y]) {
			return false;
		}
		return true;
	}

	static class Node {
		int floor;
		int x;
		int y;

		public Node(int f, int x, int y) {
			this.floor = f;
			this.x = x;
			this.y = y;
		}
	}

}