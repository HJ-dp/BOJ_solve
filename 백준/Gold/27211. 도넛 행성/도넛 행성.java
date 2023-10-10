import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, count, map[][];
    public static int[] dr = {-1,0,1,0};
    public static int[] dc = {0,1,0,-1};
    public static boolean visited[][];
    public static Queue<Node> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            temp = bf.readLine().split(" ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && map[i][j]==0){
                push(i,j);
                BFS();
                count++;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isRange(int x,int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static boolean canGo(int x,int y){
        if(!isRange(x,y)){return false;}
        else if (map[x][y]==1 || visited[x][y]){return false;}
        return true;
    }

    public static void push(int x,int y){
        visited[x][y] = true;
        q.add(new Node(x,y));
    }

    public static void BFS(){
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int d=0;d<4;d++){
                int nx = now.x + dr[d];
				if(nx < 0) {nx += N;}
				else if(nx >= N){nx -= N;}
                int ny = now.y + dc[d];
				if(ny < 0) {ny += M;}
				else if(ny >= M){ny -= M;}
                if(canGo(nx,ny)){
                    push(nx,ny);
                }
            }
        }
    }
    
    static class Node{
        int x, y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }

    }
}