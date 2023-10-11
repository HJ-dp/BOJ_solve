import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, K, map[][],net[][], dead[][];
    public static int[] dr = {-1,-1,-1,0,1,1,1,0};
    public static int[] dc = {-1,0,1,1,1,0,-1,-1};
    public static PriorityQueue<Integer>[][] arr;
    public static Queue<Integer> tmp = new LinkedList<>();
    public static Queue<Node> newTree = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        K = Integer.parseInt(temp[2]);
        arr = new PriorityQueue[N][N];
        map = new int[N][N];
        net = new int[N][N];
        dead = new int[N][N];

        for(int i=0;i<N;i++){
            temp = bf.readLine().split(" ");
            for(int j=0;j<N;j++){
                net[i][j] = Integer.parseInt(temp[j]);
                map[i][j] = 5;
                arr[i][j] = new PriorityQueue<>();
            }
        }
        for(int i=0;i<M;i++){
            temp = bf.readLine().split(" ");
            int a = Integer.parseInt(temp[0])-1;
            int b = Integer.parseInt(temp[1])-1;
            int c = Integer.parseInt(temp[2]);
            arr[a][b].add(c);
        }
		//입력 끝
        while(K-->0){
            spring();
            summer();
            fall();
            // winter();
        }
        System.out.println(counting());
    }
    public static void spring(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int C = arr[i][j].size();
                
                while(C-->0){
                    int tree = arr[i][j].poll();
                    if(map[i][j] >= tree){
                        map[i][j] -= tree;
                        tmp.add(++tree);
                        if(tree%5==0){
                        for(int d=0;d<8;d++){
                            int nx = i + dr[d];
                            int ny = j + dc[d];
                            if(isRange(nx,ny)){
                                newTree.add(new Node(nx,ny));
                            }
                        }
                    }
                    } else {
                        dead[i][j] += tree/2;
                    }
                }
                while(!tmp.isEmpty()){
                    arr[i][j].add(tmp.poll());
                }
            }
        }
    }

    public static void summer(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] += dead[i][j];
                map[i][j] += net[i][j];
                dead[i][j] = 0;
            }
        }
    }

    public static void fall(){
        while(!newTree.isEmpty()){
            Node now = newTree.poll();
            arr[now.x][now.y].add(1);     
        }
    }

    // public static void winter(){
    //     for(int i=0;i<N;i++){
    //         for(int j=0;j<N;j++){
    //             map[i][j] += net[i][j];
    //         }
    //     }
    // }

    public static int counting(){
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                cnt += arr[i][j].size();
            }
        }

        return cnt;
    }

    public static boolean isRange(int x,int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static class Node{
        int x,y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}