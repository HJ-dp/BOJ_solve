import java.util.*;

public class Main {
    public static ArrayList<Integer>[] edges;
    public static Queue<Integer> q = new LinkedList<>();
    public static int indegree[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        edges = new ArrayList[n+1];
        indegree = new int[n+1];
        for(int i=1;i<n+1;i++){
            edges[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges[a].add(b);
            indegree[b]++;
        }
        for(int i=1;i<n+1;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
        while(!q.isEmpty()) {
			int t = q.poll();
            System.out.print(t+" ");
			for(int i=0;i<edges[t].size();i++){
				if(edges[t].get(i)>=1) {
					int y = edges[t].get(i);
					indegree[y]--;
					if(indegree[y]==0) {
						q.add(y);
					}
				}//연결확인
			}//연결끊는 작업
		}
    }
}