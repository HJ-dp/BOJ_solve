import java.io.*;
import java.util.*;

public class Main {
	public static int N, M,last, indegree[], time[],answer[];
    public static ArrayList<Integer>[] arr;
    public static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        indegree = new int[N];
        time = new int[N];
        answer = new int[N];
        arr = new ArrayList[N];
        for(int i=0;i<N;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<N;i++){
            String[] temp = bf.readLine().split(" ");
            int t = Integer.parseInt(temp[0]);
            time[i] = t;
            int d = Integer.parseInt(temp[1]);
            for(int j=0;j<d;j++){
                int a = Integer.parseInt(temp[2+j])-1;
                arr[a].add(i);
                indegree[i]++;
            }
        }

        for(int i=0;i<N;i++){
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
        int max = 0;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<answer.length;i++){
            ans = Math.max(ans,answer[i]);
        }
        System.out.println(ans);
        
	}
}