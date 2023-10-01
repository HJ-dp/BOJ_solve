import java.io.*;
import java.util.*;

public class Main {
	public static int N, M,last, indegree[], time[],answer[];
    public static ArrayList<Integer>[] arr;
    public static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while(T-->0){
            String[] temp = bf.readLine().split(" ");
            N = Integer.parseInt(temp[0]);
            M = Integer.parseInt(temp[1]);
            indegree = new int[N+1];
            time = new int[N+1];
            answer = new int[N+1];
            arr = new ArrayList[N+1];
            for(int i=1;i<=N;i++){
                arr[i] = new ArrayList<>();
            }
            temp = bf.readLine().split(" ");
            for(int i=0;i<N;i++){
                time[i+1] = Integer.parseInt(temp[i]);
            }
            for(int i=0;i<M;i++){
                temp = bf.readLine().split(" ");
                int a = Integer.parseInt(temp[0]);
                int b = Integer.parseInt(temp[1]);
                arr[a].add(b);
                indegree[b]++;
            }
            int target = Integer.parseInt(bf.readLine());
            for(int i=1;i<=N;i++){
                if(indegree[i] == 0){
                    q.add(i);
                }
            }

            while(!q.isEmpty()){
                int now = q.poll();
                answer[now] += time[now];
                last = now;
                for(int i : arr[now]){
                    indegree[i]--;
                    answer[i] = Math.max(answer[i],answer[now]);
                    if(indegree[i]==0){
                        q.add(i);
                    }
                }
            }
            System.out.println(answer[target]);
        }
	}
}