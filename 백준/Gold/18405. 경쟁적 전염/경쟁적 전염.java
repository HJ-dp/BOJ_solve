import java.io.*;
import java.util.*;

public class Main {
    public static int N, K, NOW, S, X, Y, map[][];
    
    public static int[] dr = {0,0,1,-1};
    public static int[] dc = {1,-1,0,0};
    public static boolean goal, visited[][];
    public static Queue<Node> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bf.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            temp = bf.readLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        temp = bf.readLine().split(" ");
        S = Integer.parseInt(temp[0]);
        X = Integer.parseInt(temp[1])-1;
        Y = Integer.parseInt(temp[2])-1;
        while(S-->0){
            for(int i=1;i<=K;i++){
                NOW = i;
                q = new LinkedList<>();
                for(int a=0;a<N;a++){
                    for(int b=0;b<N;b++){
                        if(map[a][b]==i && !visited[a][b]){
                            push(a,b);
                        }
                    }
                }
                BFS();
                if (goal){break;}
            }
        }

        System.out.println(map[X][Y]);
    }


    public static void BFS(){
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.x==X && now.y==Y){
                goal = true;
                return;
            }
            for(int d=0;d<4;d++){
                int nx = now.x + dr[d];
                int ny = now.y + dc[d];
                if(canGo(nx,ny)){
                    map[nx][ny] = NOW;
                }
            }
        }
    }


    public static boolean isRange(int x,int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static boolean canGo(int x,int y){
        if(!isRange(x,y)){
            return false;
        }
        if(map[x][y]!=0 || visited[x][y]){
            return false;
        }
        return true;
    }

    public static void push(int x,int y){
        visited[x][y] = true;
        q.add(new Node(x,y));
    }

    static class Node{
        int x,y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}