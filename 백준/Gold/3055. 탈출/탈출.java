import java.io.*;
import java.util.*;

public class Main {/* n,m,현재위치, 걸린시간, 맵 */
	public static int N, M, nx, ny,fx,fy, time, map[][];
	public static boolean possible, visited[][];
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };
	public static Queue<Node> q;
    public static Queue<Node> fireQ;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			String[] temp = bf.readLine().split(" ");
			N = Integer.parseInt(temp[0]);
			M = Integer.parseInt(temp[1]);
			map = new int[N][M];
            q = new LinkedList<>();
            fireQ = new LinkedList<>();
			visited = new boolean[N][M];
			time = 0;
            possible = false;
			for (int i = 0; i < N; i++) {
				temp = bf.readLine().split("");
				for (int j = 0; j < M; j++) {
					switch (temp[j]) {
					case "X":
						map[i][j] = 1;
						break;
                    case "D":
						map[i][j] = -1;
                        fx = i;
                        fy = j;
						break;
					case "*":
						map[i][j] = 2;
                        visited[i][j] = true;
                        fireQ.add(new Node(i,j));
						break;
					case "S":
						map[i][j] = 0;
						push(i, j);
						break;
					case ".":
						map[i][j] = 0;
						break;
					}
				}
			} // 입력끝
			while (true) {
                FireBFS();
				BFS();
				if (possible) {
					break;
				} else if(q.size()==0){break;}
				time++;
			}

			if (!possible) {
				sb.append("KAKTUS").append("\n");
			} else {
				sb.append(time).append("\n");
			}
		System.out.println(sb);
	}// 메인 함수

	public static void push(int x, int y) {
		visited[x][y] = true;
		q.add(new Node(x, y));
	}

	public static void BFS() {
        int a = q.size();
        while(a-->0){
			Node now = q.poll();
            if(isExit(now.x,now.y)){
                possible = true;
                return;
            }
			for (int d = 0; d < 4; d++) {
				nx = now.x + dr[d];
				ny = now.y + dc[d];
				if (canGo(nx, ny)) {
					push(nx, ny);
				}
			}
        }
	}
    public static void FireBFS() {
        int a = fireQ.size();
        if (a==0) {return;}
        while(a-->0){
			Node now = fireQ.poll();
			for (int d = 0; d < 4; d++) {
				nx = now.x + dr[d];
				ny = now.y + dc[d];
				if (isRange(nx, ny) && map[nx][ny]!=1 && map[nx][ny]!=2 &&map[nx][ny]!=-1) {
                    map[nx][ny] = 2;
                    visited[nx][ny] = true;
					fireQ.add(new Node(nx,ny));
				}
			}
        }
	}

	public static boolean isExit(int x, int y) {
		return x == fx && y == fy;
	}

	public static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	public static boolean canGo(int x, int y) {
		if (!isRange(x, y)) {
			return false;
		} else if (map[x][y]==1|| map[x][y]==2 || visited[x][y]) {
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