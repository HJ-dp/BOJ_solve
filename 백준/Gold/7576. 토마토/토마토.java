import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static int N, M, cnt, map[][], visited[][];
	public static boolean ans;
	public static Queue<Node> q = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		M = Integer.parseInt(temp[0]);
		N = Integer.parseInt(temp[1]);
		map = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			temp = bf.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}

        for(int i = 0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==1){
                    push(i,j);
                }
            }
        }
        for(int i = 0;i<N;i++){
            for(int j=0;j<M;j++){
                if (map[i][j]==1){
					visited[i][j] = 0;
					push(i,j);
				} else if(map[i][j]==-1){
					visited[i][j]=-1;
				}
            }
        }
		BFS();

		All:
		for(int i = 0;i<N;i++){
            for(int j=0;j<M;j++){
				if(visited[i][j]==0){
					ans = true;
					break All;
				}
			}
		}

		int answer = (ans)? -1 : cnt-1;
		System.out.println(answer);

	}

	public static void push(int x, int y) {
		visited[x][y] = cnt+1;
		q.add(new Node(x, y));
	}

	public static void BFS() {
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
		while (!q.isEmpty()) {
			Node now = q.poll();
			cnt = visited[now.x][now.y];
            for(int d=0;d<4;d++){
                int x = now.x + dr[d];
                int y = now.y + dc[d];
                if(canGo(x,y)){
                    push(x,y);
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
		} else if (map[x][y] == -1 || visited[x][y]!=0) {
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