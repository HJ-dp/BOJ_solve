import java.io.*;
import java.util.*;

public class Main {
    static int N, M, start, end, step[], parent[];
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static ArrayList<Node>[] arr;
    static PriorityQueue<Node> q = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true){
        String[] temp = bf.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        start = Integer.parseInt(temp[2]);
        end = Integer.parseInt(temp[3]);
        if(N==0 && M == 0 && start ==0 && end ==0){break;}
        arr = new ArrayList[N+1];
        step = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
            step[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<M;i++){
            temp = bf.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int c = Integer.parseInt(temp[2]);
            arr[a].add(new Node(b,c));
        }
        q.add(new Node(start,0));
        dajk();
        sb.append(step[end]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dajk(){
        while(!q.isEmpty()){
            Node now = q.poll();
            if(step[now.x] > now.d){
                step[now.x] = now.d;
            } else {continue;}
            for(Node i : arr[now.x]){
                if(step[i.x]==Integer.MAX_VALUE){
                    q.add(new Node(i.x, i.d + step[now.x]));
                } else {
                    step[i.x] = Math.min(step[i.x],i.d + step[now.x]);
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int x, d;
        public Node(int x, int d){
            this.x = x;
            this.d = d;
        }

        public int compareTo(Node n){
            if(this.d == n.d){
                return 0;
            }
            return this.d - n.d;
        }
    }
}