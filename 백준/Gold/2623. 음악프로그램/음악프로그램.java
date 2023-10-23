import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, indegree[];
    public static ArrayList<Integer>[] arr;
    public static Queue<Integer> q = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();

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
			for(int j=1;j<a;j++){
                int b = Integer.parseInt(temp[j]);
				int c = Integer.parseInt(temp[j+1]);
				indegree[c]++;
				arr[b].add(c);
			}
        }

        int cnt = 0;

        for(int i=1;i<=N;i++){
            if(indegree[i]==0){
                q.add(i);
                cnt++;
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append("\n");
            for(int i : arr[now]){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                    cnt++;
                }
            }
        }
        if(cnt == N){
            System.out.println(sb);
        } else {
            System.out.println(0);
        }
	}
}