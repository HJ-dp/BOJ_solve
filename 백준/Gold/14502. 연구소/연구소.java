import java.util.*;
import java.io.*;

public class Main {
	public static int N, M, K, max,c, map[][];
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	public static boolean visited[][], grid[][];
	public static Node[] pick;
	public static ArrayList<Node> start = new ArrayList<>();
	public static ArrayList<Node> kabe = new ArrayList<>();
	public static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//맵 크기
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		//세울 수 있는 벽의 수
		K = 3;
		pick = new Node[K];
		
		//맵 입력받기
		map = new int[N][M];
		for(int i=0;i<N;i++){
			temp = bf.readLine().split(" ");
			for(int j=0;j<M;j++){
				map[i][j] = Integer.parseInt(temp[j]);
				if(map[i][j]==2){
					start.add(new Node(i,j));
				} else if (map[i][j]==0){
					kabe.add(new Node(i,j));
				}
			}
		}

		powerSet(0,0);
		System.out.println(max);
    }

	public static void powerSet(int x,int d){
		if(d == K){
			visited = new boolean[N][M];
			grid = new boolean[N][M];
			for(Node n : pick){
				grid[n.x][n.y] = true;
			}
			start();
			BFS();
			return;
		} else if (x == kabe.size()){
			return;
		}
		Node now = kabe.get(x);
		
		pick[d] = now;
		powerSet(x+1,d+1);

		powerSet(x+1,d);
		
	}
	public static void start(){
		for(Node n : start){
			visited[n.x][n.y] = true;
			q.add(n);
		}
	}

	public static void push(int x,int y){
		if(visited[x][y]){return;}
		visited[x][y] = true;
		q.add(new Node(x,y));
	}

	public static void BFS(){
		int cnt = 0;
		while(!q.isEmpty()){
			Node now = q.poll();
			for(int d=0;d<4;d++){
				int nx = now.x + dr[d];
				int ny = now.y + dc[d];
				if(canGo(nx,ny)){
					push(nx,ny);
				}
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(!visited[i][j] && map[i][j]==0 &&!grid[i][j]){
					cnt++;
				}
			}
		}
		max = Math.max(cnt,max);
	}

	public static boolean isRange(int x,int y){
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	public static boolean canGo(int x,int y){
		if(!isRange(x,y)) return false;
		else if(visited[x][y] || map[x][y]==1 || grid[x][y]) {
			return false;
			}
		return true;
	}

	static class Node{
		int x,y;
		public Node(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}