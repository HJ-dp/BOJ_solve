import java.io.*;
import java.util.*;

public class Main {
    public static final int INF = Integer.MAX_VALUE;
	public static int V,S, E, temp, max, answer[], item[];
    public static ArrayList<Node>[] arr;
	public static StringBuilder sb = new StringBuilder();
	public static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bf.readLine().split(" ");
        //정점의 수
        V = Integer.parseInt(temp[0]);
        //범위
		S = Integer.parseInt(temp[1]);
        //간선의 수
		E = Integer.parseInt(temp[2]);
        temp = bf.readLine().split(" ");
        item = new int[V+1];
        for(int i=1;i<=V;i++){
            item[i] = Integer.parseInt(temp[i-1]);
        }
        arr = new ArrayList[V+1];
        for(int i=1;i<=V;i++){
            arr[i] = new ArrayList<>();
        }
        while(E-->0){
            temp = bf.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int c = Integer.parseInt(temp[2]);
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }
        
        for(int v=1;v<=V;v++){
            visited = new boolean[V+1];
            answer = new int[V+1];
            pq.add(new Node(v,0));
            Arrays.fill(answer,INF);
            answer[v] = 0;
            while(!pq.isEmpty()){
                Node Num = pq.poll();
                if(!visited[Num.n]){
                    visited[Num.n] =true;
                    for(Node i : arr[Num.n]){
                        if(answer[i.n] > i.w + answer[Num.n]){
                            answer[i.n] = i.w + answer[Num.n];
                            pq.add(new Node(i.n,answer[i.n]));
                        } 
                    }
                }
            }
            int sum = 0;
            for(int i=1;i<=V;i++){
                if(answer[i]<=S){
                    sum += item[i];
                }
            }
            max = Math.max(sum,max);
        }
        sb.append(max).append("\n");
        System.out.println(sb);
	}

    static class Node implements Comparable<Node>{
        int n, w;

        public Node(int n, int w){
            this.n = n;
            this.w = w;
        }
        @Override
        public int compareTo(Node n) {

        if (this.w > n.w)
            return 1;
        else if (this.w < n.w)
            return -1;
        return 0;
    }
    }
}