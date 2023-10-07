import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    	{{0,1,1,0},
         {1,1,0,0},
         {0,0,0,0},
         {0,0,0,0}},

    	{{1,1,0,0},
         {0,1,1,0},
         {0,0,0,0},
         {0,0,0,0}},

    	{{1,0,0,0},
         {1,1,0,0},
         {0,1,0,0},
         {0,0,0,0}},

    	{{0,1,0,0},
         {1,1,0,0},
         {1,0,0,0},
         {0,0,0,0}},

    	{{1,1,1,0},
         {1,0,0,0},
         {0,0,0,0},
         {0,0,0,0}},

    	{{1,0,0,0},
         {1,0,0,0},
         {1,1,0,0},
         {0,0,0,0}},

    	{{0,0,1,0},
         {1,1,1,0},
         {0,0,0,0},
         {0,0,0,0}},

    	{{1,1,0,0},
         {0,1,0,0},
         {0,1,0,0},
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
    public static int N, M, max, arr[][];
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bf.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        arr = new int[N][M];
        for(int i=0;i<N;i++){
            temp = bf.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                max = Math.max(max,block_Value(i,j));
            }
        }

        System.out.println(max);
	}

    public static int block_Value(int x,int y){
        int max_v = 0;
        for(int i=0;i<19;i++){
            boolean ok =true;
            int sum = 0;
            for(int dx=0;dx<4;dx++){
                for(int dy=0;dy<4;dy++){
                    if(block[i][dx][dy]==0){continue;}
                    if(x+dx >= N || y+dy >= M){ok=false;}
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