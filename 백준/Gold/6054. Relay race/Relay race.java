import java.util.*;
import java.io.*;

public class Main {
    public static int N, realtime, speed[];
    public static ArrayList<Integer>[] arr;
    public static boolean visited[];
    public static PriorityQueue<Node> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //몇 마리?
        N = Integer.parseInt(bf.readLine());
        //각 소가 신호를 보낼 소
        arr = new ArrayList[N+1];
        //런타임
        speed = new int[N+1];
        //뛰었는지 체크
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=1;i<=N;i++){
            String[] temp = bf.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            speed[i] = a;
            int b = Integer.parseInt(temp[1]);
            for(int j=0;j<b;j++){
                arr[i].add(Integer.parseInt(temp[j+2]));
            }
        }//입력끝
        visited[1] = true;
        q.add(new Node(1,speed[1]));
        daik();

        System.out.println(realtime);
    }

    public static void daik(){
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.t > realtime){
                realtime = now.t;
            }
            for(int i : arr[now.x]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(new Node(i, now.t + speed[i]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int x, t;
        public Node(int x,int t) {
            this.x = x;
            this.t = t;
        }

        public int compareTo(Node n){
            if(this.t == n.t){
                return 0;
            }
            return this.t - n.t ;
        }
    }

}