import java.util.*;
import java.io.*;

public class Main {
    public static int M, N, S, P1, D;
    static long step[];
    public static ArrayList<Node>[] arr;
    public static boolean visited[];
    public static PriorityQueue<Node> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bf.readLine().split(" ");
        //정점
        N = Integer.parseInt(temp[0]);
        //간선
        M = Integer.parseInt(temp[1]);

        //정점으로부터의 최단거리
        step = new long[N];
        Arrays.fill(step,Long.MAX_VALUE);

        //방문처리배열
        visited = new boolean[N];

        //각 정점의 연결된 간선
        arr = new ArrayList[N];
        temp = bf.readLine().split(" ");

        for(int i=0;i<N;i++){
            arr[i] = new ArrayList<>();
            if(Integer.parseInt(temp[i])==1 && i!=N-1){
                visited[i] = true;
            }
        }

        for(int i=0;i<M;i++){
            temp = bf.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int c = Integer.parseInt(temp[2]);
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }
        //입력끝

        q.add(new Node(0,0));
        daik();
        if(step[N-1]==Long.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(step[N-1]);
        }
    }

    public static void daik(){
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
        int x;
        long d;
        public Node(int x,long d){
            this.x = x;
            this.d = d;
        }

        public int compareTo(Node n){
            return (int)(this.d - n.d);
        }
    }
}