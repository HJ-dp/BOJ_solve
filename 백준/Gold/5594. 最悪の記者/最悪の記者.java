import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, indegree[],cnt,cc,answer[], a[];
    public static ArrayList<Integer>[] arr;
    public static boolean zero, ex;
    public static Queue<Integer> q = new LinkedList<>();
    public static HashMap<Integer,Integer> hs = new HashMap<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
        indegree = new int[N+1];
        a = new int[N+1];
        arr = new ArrayList[N+1];
        answer = new int[N];
        cnt = 1;
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            String[] temp = bf.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            indegree[b]++;
            arr[a].add(b);
        }
        for(int i=1;i<=N;i++){
            if(!arr[i].isEmpty()){
                cc++;
            }
        }

        for(int i=1;i<=N;i++){
            if(indegree[i]==0){
                q.add(i);
            }
            if(hs.containsKey(indegree[i])){
                zero = true;
            } else {
                hs.put(indegree[i],0);
            }
        }

        while(!q.isEmpty()){
            if(q.size()>1){
                ex = true;
            }
            int now = q.poll();
            answer[now-1] = cnt++;
            for(int i : arr[now]){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);                    
                }
            }
        }
        int c = 0;
        for(int i=0;i<answer.length;i++){
            if(answer[i]==0){
                c++;
                answer[i] = cnt++;
            }
        }
        // if(c >= 1){ex=true;}
        for(int i=0;i<answer.length;i++){
            a[answer[i]]= i+1;
        }
        for(int i=1;i<=N;i++){
            sb.append(a[i]).append("\n");
        }
        
        if(ex){
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
        System.out.println(sb);
	}
}