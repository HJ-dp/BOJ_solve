import java.util.*;
import java.io.*;

public class Main {
    public static int M, N, S, P1, D, step[], ans1, ans2;
    public static ArrayList<Node>[] arr;
    public static boolean flag, visited[];
    public static PriorityQueue<Node> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bf.readLine().split(" ");
        //정점
        N = Integer.parseInt(temp[0]);
        //간선
        M = Integer.parseInt(temp[1]);

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
        }
        temp = bf.readLine().split(" ");
        S = Integer.parseInt(temp[0]);
        P1 = Integer.parseInt(temp[1]);
        D = Integer.parseInt(temp[2]);
        //입력끝
        
        //시작점에서 P1 과 P2
        q.add(new Node(S,0));
        daik();

        if(step[P1]==Integer.MAX_VALUE){
            ans1 = -1;
        } else {
            ans1 += step[P1];
            //P1에서 D 
            q.add(new Node(P1,0));
            daik();
            if(step[D]==Integer.MAX_VALUE){
                ans1 = -1;
            } else {
                ans1 += step[D];
            }
        }

        flag = true;
        q.add(new Node(S,0));
        daik();
        if(step[D]==Integer.MAX_VALUE){
            ans2 = -1;
        }else {
            ans2 = step[D];
        }
        
        System.out.printf("%d %d\n",ans1, ans2);
    }

    public static void daik(){
        //정점으로부터의 최단거리
        step = new int[N+1];
        Arrays.fill(step,Integer.MAX_VALUE);
        //방문처리배열
        visited = new boolean[N+1];

        while(!q.isEmpty()){
            Node now = q.poll();
            if(flag && now.x == P1){
                continue;
            }
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