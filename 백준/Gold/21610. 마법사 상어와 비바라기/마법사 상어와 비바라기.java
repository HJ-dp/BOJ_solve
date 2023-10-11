import java.io.*;
import java.util.*;

public class Main {
    static int N, M, map[][];
    static int[] dr = {0,-1,-1,-1,0,1,1,1};
    static int[] dc = {-1,-1,0,1,1,1,0,-1};
    static boolean visited[][];
    static Queue<Node> q = new LinkedList<>();
    static Queue<Node> c = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        map = new int[N][N];
        for(int i=0;i<N;i++){
            temp = bf.readLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        //첫 구름
        q.add(new Node(N-1,0));
        q.add(new Node(N-1,1));
        q.add(new Node(N-2,0));
        q.add(new Node(N-2,1));

        for(int i=0;i<M;i++){
            temp = bf.readLine().split(" ");
            int a = Integer.parseInt(temp[0])-1;
            int b = Integer.parseInt(temp[1]);
            move(a,b);
            rain();
            waterPlus();
            cloud();
        }

        int sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    public static int waterCnt(int x,int y){
        int[] r = {-1,-1,1,1};
        int[] c = {-1,1,1,-1};
        int cnt = 0;
        for(int d=0;d<4;d++){
            int cx = x + r[d];
            int cy = y + c[d];
            if(isRange(cx,cy) && map[cx][cy] > 0){
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean isRange(int x,int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }


    public static void move(int dir, int dis){
        while(!q.isEmpty()){
            Node now = q.poll();
            int nx = now.x + (dr[dir] * dis);
            int ny = now.y + (dc[dir] * dis);
            push(nx,ny);
        }
    }

    public static void push(int x,int y){
        while(!isRange(x,y)){
            if(x < 0){x += N;}
            else if(x >= N){x -= N;}
            if(y < 0) {y += N;}
            else if(y >= N){y -= N;}
        }
        c.add(new Node(x,y));
    }

    public static void rain(){
        visited = new boolean[N][N];
        while(!c.isEmpty()){
            Node now = c.poll();
            visited[now.x][now.y] = true;
            map[now.x][now.y]++;
            q.add(new Node(now.x,now.y));
        }
    }

    public static void waterPlus(){
        while(!q.isEmpty()){
            Node now = q.poll();
            map[now.x][now.y] += waterCnt(now.x,now.y);
        }
    }

    public static void cloud(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && map[i][j]>=2){
                    map[i][j] -= 2;
                    q.add(new Node(i,j));
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