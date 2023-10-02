import java.util.*;
import java.io.*;

public class Main {
	public static int N, M, max,c = Integer.MAX_VALUE, map[][], dist[][];
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	public static boolean visited[][], suc = true;
	public static Node[] pick;
	public static ArrayList<Node> start = new ArrayList<>();
	public static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//맵 크기
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		//놓을 수 있는 바이러스 수
		M = Integer.parseInt(temp[1]);
		pick = new Node[M];
		//맵 입력받기
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++){
			temp = bf.readLine().split(" ");
			for(int j=0;j<N;j++){
				map[i][j] = Integer.parseInt(temp[j]);
				if (map[i][j]==2){
					start.add(new Node(i,j));
				}
			}
		}
		powerSet(0,0);
		if(c == Integer.MAX_VALUE){
			System.out.println(-1);
		} else {
			System.out.println(c);
		}
    }

	public static void powerSet(int x,int d){
		if(d == M){
			visited = new boolean[N][N];
			dist= new int[N][N];
			start();
			BFS();
			if(suc){
				c = Integer.min(c,max);
			}
			return;
		} else if (x == start.size()){
			return;
		}
		Node now = start.get(x);
		pick[d] = now;
		powerSet(x+1,d+1);
		powerSet(x+1,d);
		
	}
	public static void start(){
		for(Node n : pick){
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
		max = 0;
		suc = true;
		while(!q.isEmpty()){
			Node now = q.poll();
			for(int d=0;d<4;d++){
				int nx = now.x + dr[d];
				int ny = now.y + dc[d];
				if(canGo(nx,ny)){
					dist[nx][ny] = dist[now.x][now.y]+1;
					max = Integer.max(max,dist[nx][ny]);
					push(nx,ny);
				}
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(map[i][j]!=1 && !visited[i][j]){
					suc = false;
					break;
				}
			}
		}
		if (!suc){
			max = -1;
		}
		
	}

	public static boolean isRange(int x,int y){
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	public static boolean canGo(int x,int y){
		if(!isRange(x,y)) return false;
		else if(visited[x][y] || map[x][y]==1) {
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