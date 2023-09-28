import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, cnt, x, y, map[][];
	public static boolean visited[][];
	// 북동남서
	public static int[] dr = { -1, 0, 1, 0};
	public static int[] dc = { 0, 1, 0, -1};
	public static StringBuilder sb = new StringBuilder();
	public static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			temp = bf.readLine().split("");
			for (int j = 0; j < M; j++) {
				if(temp[j].equals("O")){
					map[i][j] = 0;
				} else if (temp[j].equals("P")){
					map[i][j] = 2;
				} else if (temp[j].equals("X")){
					map[i][j] = 1;
				} else if (temp[j].equals("I")){
					map[i][j] = 0;
					push(i,j);
				}
			}
		}
		// 입력끝
		
		BFS();
		if(cnt==0){
			System.out.println("TT");
		} else {
			System.out.println(cnt);
		}
	}

	public static void push(int x, int y) {
		if (canGo(x, y)) {
			visited[x][y] = true;
			q.add(new Node(x, y));
		}
	}

	public static void BFS() {
		while (!q.isEmpty()) {
			Node now = q.poll();
			if(map[now.x][now.y]==2){cnt++;}
			for (int d = 0; d < 4; d++) {
				int nowX = now.x + dr[d];
				int nowY = now.y + dc[d];
				if (canGo(nowX, nowY)) {
					push(nowX, nowY);
				}
			}
		}
	}

	public static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	public static boolean canGo(int x, int y) {
		if (!isRange(x, y)) {
			return false;
		} else if (map[x][y] == 1 || visited[x][y]) {
			return false;
		}
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