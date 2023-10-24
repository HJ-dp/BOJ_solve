import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, S, step[];
    public static ArrayList<Node>[] arr;
    public static boolean visited[];
    public static PriorityQueue<Node> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bf.readLine().split(" ");
        //간선
        N = Integer.parseInt(temp[0]);
        //정점
        M = Integer.parseInt(temp[1]);
        //시작점
        S = Integer.parseInt(temp[2]);

        //각 정점의 연결된 간선
        arr = new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            temp = bf.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int c = Integer.parseInt(temp[2]);
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }//입력끝
        q.add(new Node(S,0));
        daik();
        step[0] = 0;
        int max = 0;
        for(int i=1;i<=N;i++){
            max = Math.max(max,step[i]);
        }
        System.out.println(max*2);
    }

    public static void daik(){
        //정점으로부터의 최단거리
        step = new int[N+1];
        Arrays.fill(step,Integer.MAX_VALUE);
        //방문처리배열
        visited = new boolean[N+1];

        while(!q.isEmpty()){
            Node now = q.poll();
            if(step[now.x] > now.d){
                step[now.x] = now.d;
            } else {continue;}
            visited[now.x] = true;
            for(Node n : arr[now.x]){
                if(!visited[n.x]){
                    q.add(new Node(n.x,step[now.x]+n.d));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int x, d;
        public Node(int x,int d){
            this.x = x;
            this.d = d;
        }

        public int compareTo(Node n){
            return this.d - n.d;
        }
    }
}