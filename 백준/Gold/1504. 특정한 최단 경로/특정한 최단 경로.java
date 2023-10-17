import java.util.*;
import java.io.*;

public class Main {
    static int N, E, start, end, ans1, ans2;
    static int step[];
    static boolean visited[];
    static ArrayList<Node>[] arr;
    static PriorityQueue<Node> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bf.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        E = Integer.parseInt(temp[1]);
        ans1 = 0;
        ans2 = 0;
        arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            temp = bf.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int c = Integer.parseInt(temp[2]);
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }

        temp = bf.readLine().split(" ");
        start = Integer.parseInt(temp[0]);
        end = Integer.parseInt(temp[1]);
        int[] tmp = {1,start,end};
        int[] tmp2 = {start,end,N};
        for(int i=0;i<3;i++){
            if(tmp[i]==tmp2[i]){continue;}
            q.add(new Node(tmp[i],0));
            daik();
            if(step[tmp2[i]]==0){
                ans1=-1;
                break;
            }
            ans1 += step[tmp2[i]];
        }
        int[] temp3 = {1,end,start};
        int[] temp4 = {end,start,N};
        for(int i=0;i<3;i++){
            if(temp3[i]==temp4[i]){continue;}
            q.add(new Node(temp3[i],0));
            daik();
            if(step[temp4[i]]==0){
                ans2=-1;
                break;
            }
            ans2 += step[temp4[i]];
        }
        int answer = 0;
        if(ans1 == -1 && ans2 !=-1){
            answer = ans2;
        } else if (ans1 != -1 && ans2 == -1){
            answer = ans1;
        } else {
            answer = Math.min(ans1,ans2);
        }
        
        System.out.println(answer);
    }

    public static void daik(){
        step = new int[N+1];
        visited= new boolean[N+1];

        while(!q.isEmpty()){
            Node now = q.poll();
            if(!visited[now.v]){
                step[now.v] = now.d;
                visited[now.v] =true;
                for(Node n : arr[now.v]){
                    if(!visited[n.v]){
                        q.add(new Node(n.v,n.d + now.d));
                    } else if (step[now.v] > n.d + now.d){
                        step[now.v] = n.d + now.d;
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int v;
        int d;
        public Node(int v,int d){
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Node n){
            if(this.d==n.d){
                return 0;
            }
            return this.d - n.d;
        }
    }
}