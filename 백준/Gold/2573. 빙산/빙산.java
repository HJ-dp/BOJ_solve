import java.util.*;
import java.io.*;

public class Main {
	public static int N, M, max,time, map[][], melt[][];
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,1,0,-1};
	public static boolean visited[][], done;
	public static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//맵 크기
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);

		//맵 입력받기
		map = new int[N][M];
		
		for(int i=0;i<N;i++){
			temp = bf.readLine().split(" ");
			for(int j=0;j<M;j++){
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}// 입력 끝

		while (true){
			time++;
			visited = new boolean[N][M];
			melt = new int[N][M];
			melting();
			melt();
			int c = 0;
			visited = new boolean[N][M];
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(map[i][j]!=0 && !visited[i][j]){
						c++;
						push(i,j);
						BFS();
					}
				}
			}
			if(c>1){ 
				done = true;
				break;
			} else if (c==0){
				break;
			}
		}
		if(done){
			System.out.println(time);
		} else {
			System.out.println(0);
		}

    }

	public static void print(){
		for(int i=0;i<N;i++){
			System.out.println(Arrays.toString(map[i]));
		}
	}

	public static void push(int x,int y){
		visited[x][y] = true;
		q.add(new Node(x,y));
	}

	public static void melt(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				map[i][j] -= melt[i][j];
				if(map[i][j]<0){map[i][j]=0;}
			}
		}
	}

	public static void melting(){
		for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(map[i][j]!=0 && !visited[i][j]){
						push(i,j);
				}
			}
		}
		while(!q.isEmpty()){
			Node now = q.poll();
			int cnt = 0;
			for(int d=0;d<4;d++){
				int nx = now.x + dr[d];
				int ny = now.y + dc[d];
				if(isRange(nx,ny) && map[nx][ny]==0){
					cnt++;
				}
			}
			melt[now.x][now.y] = cnt;
		}
	}

	public static void BFS(){
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
	}

	public static boolean isRange(int x,int y){
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	public static boolean canGo(int x,int y){
		if(!isRange(x,y)){return false;}
		else if(map[x][y]==0 || visited[x][y]){return false;}
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