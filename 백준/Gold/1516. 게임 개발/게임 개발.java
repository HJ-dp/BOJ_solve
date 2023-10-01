import java.io.*;
import java.util.*;

public class Main {
	public static int N, M,last, indegree[], time[],answer[];
    public static ArrayList<Integer>[] arr;
    public static Queue<Integer> q = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();
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
			int tmp = 1;
			while(true){
				int a = Integer.parseInt(temp[tmp++]);
				if(a==-1){break;}
				arr[a-1].add(i);
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
        for(int i=0;i<N;i++){
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb);
	}
}