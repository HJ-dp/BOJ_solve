import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, A, B, answer[];
    static boolean visited[];
    public static ArrayList<Node>[] arr;
    public static PriorityQueue<Node> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bf.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        A = Integer.parseInt(temp[2]);
        B = Integer.parseInt(temp[3]);
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        answer = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
            answer[i] = Integer.MAX_VALUE;
        }

        for(int t=0;t<M;t++){
            temp = bf.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            int d = Integer.parseInt(temp[2]);
            arr[x].add(new Node(y,d));
            arr[y].add(new Node(x,d));
        }   
        q.add(new Node(A,0));
        daik();  
        System.out.println(answer[B]);
    }

    public static void daik(){
        while(!q.isEmpty()){
            Node now = q.poll();
            visited[now.x] = true;
            if(answer[now.x] > now.d){
                answer[now.x] = now.d;
            }
            for(Node n : arr[now.x]){
                if(!visited[n.x]){
                    q.add(new Node(n.x,now.d + n.d));
                } else if (answer[n.x] > now.d + n.d){
                    answer[n.x] = now.d + n.d;
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int x;
        int d;
        public Node(int x,int d){
            this.x = x;
            this.d = d;
        }

        @Override
        public int compareTo(Node n){
            if(this.d == n.d){
                return 0;
            }
            return this.d - n.d;
        }
    }
}