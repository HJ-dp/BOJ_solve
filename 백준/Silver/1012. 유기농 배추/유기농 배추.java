import java.util.*;

public class Main {
    
    public static int cnt, N, M, map[][];
    public static boolean visited[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc=1;tc<=t;tc++){
            M = sc.nextInt();
            N = sc.nextInt();
            map = new int[N][M];
            visited = new boolean[N][M];
            cnt = 0;
            int K = sc.nextInt();
            for(int i=0;i<K;i++){
                int y = sc.nextInt();
                int x = sc.nextInt();
                map[x][y] = 1;
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        DFS(i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void DFS(int x, int y){
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        visited[x][y]=true;
        for(int d=0;d<4;d++){
            int nowX = x + dr[d];
            int nowY = y + dc[d];
            if(canGo(nowX,nowY) &&!visited[nowX][nowY]){
                DFS(nowX,nowY);
            }
        }

    }

    public static boolean isRange(int x,int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static boolean canGo(int x,int y){
        if (!isRange(x,y)){return false;}
        else if(map[x][y]==0 || visited[x][y]){
            return false;
        }
        return true;
    }
}