import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, cnt, map[][], answer[][];
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };
	public static Queue<Node> q = new LinkedList<>();
	public static boolean nowC, Goal, visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		// 맵 입력받기
		map = new int[N][M];
		visited = new boolean[N][M];
		answer = new int[N][M];
		for(int i=0;i<N;i++) {
			temp = bf.readLine().split("");
			for(int j=0;j<M;j++) {
				if(temp[j].equals(".")) {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}// 입력 끝
		cnt = Integer.MAX_VALUE;
		push(0, 0);
		BFS();
		int ans = (Goal)? answer[N-1][M-1] : -1;
		System.out.println(ans);
	}

	public static void push(int x, int y) {
		visited[x][y] = true;
		q.add(new Node(x, y));
	}

	public static void BFS() {
		while (!q.isEmpty()) {
			Node now = q.poll();
			nowC = (map[now.x][now.y]==0)? false:true;
			if(now.x==N-1 && now.y == M-1) {
				Goal = true;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nowX = now.x + dr[d];
				int nowY = now.y + dc[d];
				if (canGo(nowX, nowY)) {
					answer[nowX][nowY] = answer[now.x][now.y]+1;
					push(nowX, nowY);
				}
			}
		}
	}

	public static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	public static boolean canGo(int x, int y) {
		if (!isRange(x, y))
			return false;
		else if (visited[x][y])
			return false;
		else if(nowC && map[x][y] == 1) {return false;}
		else if(!nowC && map[x][y] == 0) {return false;}
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