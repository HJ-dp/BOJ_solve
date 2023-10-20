import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, step[];
    public static ArrayList<Node>[] arr;
    public static boolean visited[];
    public static PriorityQueue<Node> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bf.readLine().split(" ");
        //정점
        N = Integer.parseInt(temp[0]);
        //주어지는 행의 수
        M = Integer.parseInt(temp[1]);

        //각 정점의 연결된 간선
        arr = new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }

        for(int t=0;t<M;t++){
            temp = bf.readLine().split(" ");
            //주문표
            if(temp[0].equals("0")){
                int a = Integer.parseInt(temp[1]);
                int b = Integer.parseInt(temp[2]);

                q.add(new Node(a,0));
                daik();
                if(step[b]==Integer.MAX_VALUE){
                    System.out.println(-1);
                } else {
                    System.out.println(step[b]);
                }
            }
            //배 입력
            else {
                int a = Integer.parseInt(temp[1]);
                int b = Integer.parseInt(temp[2]);
                int c = Integer.parseInt(temp[3]);
                arr[a].add(new Node(b,c));
                arr[b].add(new Node(a,c));
            }
        }
    
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
            for(Node n : arr[now.x]){
                if(step[n.x] > now.d + n.d){
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