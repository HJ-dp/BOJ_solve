import java.io.*;
import java.util.*;

public class Main {
    public static final int INF = Integer.MAX_VALUE;
	public static int V, E, S, answer[];
    public static ArrayList<Node>[] arr;
	public static StringBuilder sb = new StringBuilder();
	public static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
        //정점의 수
        V = Integer.parseInt(temp[0]);
        //간선의 수
		E = Integer.parseInt(temp[1]);
        //시작 정점
        S = Integer.parseInt(bf.readLine());
        visited = new boolean[V+1];
        answer = new int[V+1];
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
        }
        
        pq.add(new Node(S,0));
        Arrays.fill(answer,INF);
        answer[S] = 0;
        while(!pq.isEmpty()){
            Node Num = pq.poll();
            visited[Num.n] =true;
            for(Node i : arr[Num.n]){
                if(answer[i.n] > i.w + answer[Num.n]){
                    answer[i.n] = i.w + answer[Num.n];
                    pq.add(new Node(i.n,answer[i.n]));
                } 
            }
        }
        for(int i=1;i<=V;i++){
            if(!visited[i]){sb.append("INF").append("\n");}
            else {sb.append(answer[i]).append("\n");}
        }
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