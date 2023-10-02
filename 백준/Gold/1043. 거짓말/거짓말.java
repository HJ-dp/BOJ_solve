import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, cnt, t, uf[];
    public static ArrayList<Integer>[] arr;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bf.readLine().split(" ");
        //정점의 수
        N = Integer.parseInt(temp[0]);
        //간선의 수
		M = Integer.parseInt(temp[1]);
        arr = new ArrayList[M+1];
        uf = new int[N+1];
        for(int i=1;i<=M;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=1;i<=N;i++){
            uf[i] = i;
        }

        temp = bf.readLine().split(" ");
        int x = Integer.parseInt(temp[0]);
        if(x!=0){
            for(int i=1;i<=1;i++){
                int a = Integer.parseInt(temp[i]);
                for(int j=2;j<=x;j++){
                    int b = Integer.parseInt(temp[j]);
                    union(b,a);
                }
                t = a;
            }
        }

        for(int i=1;i<=M;i++){
            temp = bf.readLine().split(" ");
            x = Integer.parseInt(temp[0]);
            for(int j=1;j<=x;j++){
                int a = Integer.parseInt(temp[j]);
                arr[i].add(a);
            }
        }
        for(int i=1;i<=M;i++){
            if(arr[i].size()!=1){
                for(int j=1;j<arr[i].size();j++){
                    union(arr[i].get(0),arr[i].get(j));
                }
            }
        }
        for(int i=1;i<=M;i++){
            if (find(arr[i].get(0))!=find(t)){
                cnt++;
            }
        }
        sb.append(cnt).append("\n");
        System.out.println(sb);
	}

    public static void union(int x,int y){
        int X = find(x);
        int Y = find(y);
        uf[X] = Y;
    }

    public static int find(int x){
        if(uf[x]==x){
            return x;
        }
        int root = find(uf[x]);
        uf[x] = root;
        return root;
    }
}