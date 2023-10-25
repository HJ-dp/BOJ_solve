import java.util.*;
import java.io.*;

public class Main {
    public static int N, S, E, day, cnt, map[][];
    public static int[] dr = {-1,0,1,0};
    public static int[] dc = {0,1,0,-1};
    public static boolean ocr, visited[][];
    static Queue<Node> q = new LinkedList<>();
    static Queue<Node> numQ = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bf.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        S = Integer.parseInt(temp[1]);
        E = Integer.parseInt(temp[2]);
        map = new int[N][N];
        

        for(int i=0;i<N;i++){
            temp = bf.readLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        while(!ocr){
        visited= new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                push(i,j);
                numQ.add(new Node(i,j));
                BFS();
                }
            }
        }
        if(ocr){
            day++;
            ocr = false;
        } else {
            System.out.println(day);
            break;
        }
        }

    }

    public static boolean isRange(int x,int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static boolean canGo(int x,int y){
        if(!isRange(x,y)){return false;}
        if(visited[x][y]){return false;}
        return true;
    }

    public static void push(int x,int y){
        visited[x][y] = true;
        q.add(new Node(x,y));
    }

    public static void BFS(){
        int sum = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            cnt++;
            sum += map[now.x][now.y];
            for(int d=0;d<4;d++){
                int nx = now.x + dr[d];
                int ny = now.y + dc[d];
                if(canGo(nx,ny) && cha(now.x,now.y,nx,ny)){
                    push(nx,ny);
                    numQ.add(new Node(nx,ny));
                }
            }
        }
        if(cnt>1){ocr = true;}
        sum /= cnt;
        while(!numQ.isEmpty()){
            Node now = numQ.poll();
            map[now.x][now.y] = sum;
        }
    }

    public static boolean cha(int x,int y, int nx, int ny){
        int a = Math.abs(map[x][y] - map[nx][ny]);
        return S <= a && a <= E;
    }

    static class Node{
        int x, y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

}