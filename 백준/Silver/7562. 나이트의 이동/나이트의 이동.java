import java.io.*;
import java.util.*;

public class Main {
	public static int N, X, Y, GX, GY, map[][];
	public static int[] dr = { -2, -2, -1, 1, 2, 2, 1, -1 };
	public static int[] dc = { -1, 1, 2, 2, 1, -1, -2, -2 };
	public static Queue<Node> q = new LinkedList<>();
	public static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t--> 0) {
			N = Integer.parseInt(bf.readLine());
			// 맵 입력받기
			map = new int[N][N];
			visited = new boolean[N][N];
			String[] temp = bf.readLine().split(" ");
			int X = Integer.parseInt(temp[0]);
			int Y = Integer.parseInt(temp[1]);
			temp = bf.readLine().split(" ");
			int GX = Integer.parseInt(temp[0]);
			int GY = Integer.parseInt(temp[1]);
			// 입력 끝
			push(X, Y);
			BFS();
			System.out.println(map[GX][GY]);
		}
	}

	public static void push(int x, int y) {
		visited[x][y] = true;
		q.add(new Node(x, y));
	}

	public static void BFS() {
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int d = 0; d < 8; d++) {
				int nowX = now.x + dr[d];
				int nowY = now.y + dc[d];
				if (canGo(nowX, nowY)) {
					map[nowX][nowY] = map[now.x][now.y]+1;
					push(nowX, nowY);
				}
			}
		}
	}

	public static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	public static boolean canGo(int x, int y) {
		if (!isRange(x, y))
			return false;
		else if (visited[x][y])
			return false;
		return true;
	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}