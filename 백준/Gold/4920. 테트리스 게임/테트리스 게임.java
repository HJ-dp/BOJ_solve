import java.io.*;
import java.util.*;

public class Main {
	public static int[][][] block = new int[][][] {
    	{{1,1,1,1},
    	{0,0,0,0},
    	{0,0,0,0},
    	{0,0,0,0}},

    	{{1,0,0,0},
        {1,0,0,0},
       	{1,0,0,0},
        {1,0,0,0}},

    	{{1,1,0,0},
         {1,1,0,0},
         {0,0,0,0},
         {0,0,0,0}},

    	{{1,1,0,0},
         {0,1,1,0},
         {0,0,0,0},
         {0,0,0,0}},

    	{{0,1,0,0},
         {1,1,0,0},
         {1,0,0,0},
         {0,0,0,0}},

    	{{1,1,1,0},
         {0,0,1,0},
         {0,0,0,0},
         {0,0,0,0}},

      	{{0,1,0,0},
         {0,1,0,0},
         {1,1,0,0},
         {0,0,0,0}},

     	{{1,0,0,0},
         {1,1,1,0},
         {0,0,0,0},
         {0,0,0,0}},

      	{{1,1,0,0},
         {1,0,0,0},
         {1,0,0,0},
         {0,0,0,0}},

      	{{1,1,1,0},
         {0,1,0,0},
         {0,0,0,0},
         {0,0,0,0}},

      	{{0,1,0,0},
         {1,1,1,0},
         {0,0,0,0},
         {0,0,0,0}},

      	{{0,1,0,0},
         {1,1,0,0},
         {0,1,0,0},
         {0,0,0,0}},

      	{{1,0,0,0},
         {1,1,0,0},
         {1,0,0,0},
         {0,0,0,0}}
    };
    public static int T,max, N, arr[][];
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
    public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(true){
            N = sc.nextInt();
            if(N==0){break;}
            max= Integer.MIN_VALUE;
            T++;
            arr = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    max = Math.max(max,block_Value(i,j));
                }
            }

            sb.append(T).append(". ").append(max).append("\n");
        }
        System.out.println(sb);
	}

    public static int block_Value(int x,int y){
        int max_v = Integer.MIN_VALUE;
        for(int i=0;i<13;i++){
            boolean ok =true;
            int sum = 0;
            for(int dx=0;dx<4;dx++){
                for(int dy=0;dy<4;dy++){
                    if(block[i][dx][dy]==0){continue;}
                    if(x+dx >= N || y+dy >= N){ok=false;}
                    else {
                        sum += arr[x+dx][y+dy];}
                }
            }
            if(ok){
                max_v = Math.max(max_v,sum);
            }
        }
        return max_v;
    }
}