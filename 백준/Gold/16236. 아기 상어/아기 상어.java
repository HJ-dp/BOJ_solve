import java.io.*;
import java.util.*;

public class Main { /* 지도 크기 현재 x,y 타겟xy, 걸린시간, 아기상어크기,먹어야하는 수, 맵, 최단거리기 */
	public static int N, nowX, nowY, tX, tY, time, size = 2,need, map[][], temp[][];
	// 현재 먹이로부터의 최단거리
	public static int min;
	public static boolean visited[][];
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };
	public static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		need = size;
		for (int i = 0; i < N; i++) {
			String[] temp = bf.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				// 초기위치
				if (map[i][j] == 9) {
					nowX = i;
					nowY = j;
				}
			}
		} // 입력끝
		while (true) {
			temp = new int[N][N];
			visited = new boolean[N][N];
			tX = -1;
			tY = -1;
			min = Integer.MAX_VALUE;
			// 현재위치로부터
			push(nowX, nowY);
			// 타겟 탐색
			BFS();
			// 타겟이 없으면 끝내
			if (tX == -1) {
				break;
			}
			// 타겟 있을땐 움직이기
			move();
		}

		System.out.println(time);
	}

	public static void move() {
		time += temp[tX][tY];
		//섭취필요 마리수 깎기
		need--;
		//다먹었으면 성장하고 섭취 필요 마리수 초기화
		if(need==0){
			size++;
			need= size;
		}
		map[nowX][nowY] = 0;
		nowX = tX;
		nowY = tY;
	}

	public static void push(int x, int y) {
		visited[x][y] = true;
		q.add(new Node(x, y));
	}

	public static void BFS() {
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = now.x + dr[d];
				int ny = now.y + dc[d];
				// 그 위치 갈수 있다?
				if (canGo(nx, ny)) {
					// 일단 최단거리 기록
					temp[nx][ny] = temp[now.x][now.y] + 1;
					// 몸크기가 같거나빈공간이면 그냥 지나가
					if (map[nx][ny] == 0 || map[nx][ny] == size) {
						push(nx, ny);
						// 크기가 작은 먹이라면 최단거리의우선순위재보기
					} else if (min > temp[nx][ny]) {
						// 더 가까우면
						min = temp[nx][ny];
						tX = nx;
						tY = ny;
						visited[nx][ny] = true;
						// 거리가 같으면 ㅇ
					} else if (min == temp[nx][ny]) {
						visited[nx][ny] = true;
						// 현재타겟의 위치가 더 낮거나 높이는 같지만 더 왼쪽일경
						if (tX > nx || (tX == nx && tY > ny)) {
							tX = nx;
							tY = ny;
						}
					}
				}
			}
		}
	}

	public static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	public static boolean canGo(int x, int y) {
		if (!isRange(x, y)) {
			return false;
		} else if (map[x][y] > size || visited[x][y]) {
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