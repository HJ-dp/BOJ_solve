import java.util.*;
import java.io.*;

public class Main {
    static int N, map[][], start, loop;
    static int[] dr = {1,0};
    static int[] dc = {0,1};
    static Node[][] arr;
    static boolean visited[][];
    static PriorityQueue<Node> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        arr = new Node[N][N];
        visited = new boolean[N][N];
        loop = 2;
        for(int i=0;i<N;i++){
            String[] temp = bf.readLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(temp[j]);
                arr[i][j] = new Node(0,0,Integer.MAX_VALUE);
            }
        }
        q.add(new Node(0,0,0));
        daik();

        System.out.println(arr[N-1][N-1].d);
    }

    public static void daik(){
        while(!q.isEmpty()){
            Node now = q.poll();
            if (now.x == N-1 && now.y == N-1){
                arr[now.x][now.y] = now;
                return;
            }
            if(arr[now.x][now.y].d > now.d){
                visited[now.x][now.y]= true;
                arr[now.x][now.y] = now;
            } else {continue;}
            if(now.x == N-1){
                start = 1;
                loop = 2;
            } else if (now.y == N-1){
                start = 0;
                loop = 1;
            } else {
                start = 0;
                loop = 2;
            }
            
            for(int d = start; d<loop; d++){
                int nx = now.x + dr[d];
                int ny = now.y + dc[d];
                int cost = 0;
                if(isRange(nx,ny) && !visited[nx][ny]){
                    int co = needButton(now.x,now.y,nx,ny);
                    cost = arr[now.x][now.y].d + co;
                    q.add(new Node(nx,ny,cost));
                }
            }
        }
    }

    public static boolean isRange(int x,int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static int needButton(int x1, int y1, int x2, int y2){
        if(map[x1][y1] > map[x2][y2]){
            return 0;
        }
        return Math.abs(map[x1][y1] - map[x2][y2])+1;
    }

    static class Node implements Comparable<Node>{
        int x,y;
        int d;
        public Node(int x,int y,int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Node n){
            return this.d - n.d;
        }
    }
}