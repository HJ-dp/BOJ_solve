import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, indegree[];
    public static ArrayList<Integer>[] arr;
	public static StringBuilder sb = new StringBuilder();
	public static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
        indegree = new int[N+1];
        arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            temp = bf.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            indegree[b]++;
            arr[a].add(b);
        }

        for(int i=1;i<=N;i++){
            if(indegree[i]==0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int now = pq.poll();
            sb.append(now).append(" ");
            for(int i : arr[now]){
                indegree[i]--;
                if(indegree[i]==0){
                    pq.add(i);                    
                }
            }
        }
        System.out.println(sb);
	}
}