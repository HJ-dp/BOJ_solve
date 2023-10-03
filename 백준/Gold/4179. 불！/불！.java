import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, MAXIM, time, map[][];
    public static int[] dr = {-1,0,1,0};
    public static int[] dc = {0,1,0,-1};
    public static boolean survive, visited[][],fire[][];
    public static Queue<Node> q = new LinkedList<>();
    public static Queue<Node> fireQ = new LinkedList<>();
    public static Queue<Node> temp = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        MAXIM = 9999999;
        map = new int[N][M];
        visited = new boolean[N][M];
        fire = new boolean[N][M];
        for(int i=0;i<N;i++){
            temp = bf.readLine().split("");
            for(int j=0;j<M;j++){
                switch(temp[j]){
                    case "#":
                    map[i][j] = 1;
                    break;
                    case "J":
                    map[i][j] = 0;
                    push(i,j);
                    break;
                    case "F":
                    pushFire(i,j);
                    break;
                    case ".":
                    map[i][j] = 0;
                    break;
                }
            }
        }
        //입력 끝

        while(true){
            time++;
            Fired();
            BFS();
            if(survive){break;}
            if(time>MAXIM){break;}
        }

        if(survive){
            System.out.println(time);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static boolean isExit(int x,int y){
        return x == 0 || x == N-1 || y ==0 || y == M-1;
    }

    public static void push(int x,int y){
        visited[x][y] = true;
        q.add(new Node(x,y));
    }

    public static void pushFire(int x,int y){
        fire[x][y] = true;
        fireQ.add(new Node(x,y));
    }

    public static void BFS(){
        while(!q.isEmpty()){
            Node now = q.poll();
            if(isExit(now.x,now.y)){
                survive = true;
                break;
            }
            for(int d=0;d<4;d++){
                int nx = now.x + dr[d];
                int ny = now.y + dc[d];
                if(canGo(nx,ny)){
                    temp.add(new Node(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
        while(!temp.isEmpty()){
            Node now = temp.poll();
            push(now.x,now.y);
        }
    }

    public static void Fired(){
        while(!fireQ.isEmpty()){
            Node now = fireQ.poll();
            map[now.x][now.y] = 2;
            for(int d=0;d<4;d++){
                int nx = now.x + dr[d];
                int ny = now.y + dc[d];
                if(isRange(nx,ny)&& !fire[nx][ny] && map[nx][ny]!=1){
                    temp.add(new Node(nx,ny));
                    fire[nx][ny] = true;
                }
            }
        }
        while(!temp.isEmpty()){
            Node now = temp.poll();
            pushFire(now.x,now.y);
        }
    }

    public static boolean isRange(int x,int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static boolean canGo(int x,int y){
        if (!isRange(x,y)){
            return false;
        }
        else if (visited[x][y]|| fire[x][y] || map[x][y]==1 || map[x][y] == 2){
            return false;
        }
        return true;
    }

    static class Node{
        int x, y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}