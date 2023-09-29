import java.io.*;
import java.util.*;

public class Main {
	
	public static int cnt, uf[];
	public static long answer;
	public static ArrayList<Node> arr = new ArrayList<>();
	public static StringBuilder sb = new StringBuilder();
	public static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		visited = new boolean[N][N];
		//메이크셋 
		uf = new int[N+1];
		for(int i=1;i<=N;i++) {
			uf[i]= i;
		}
		
		for(int i =0;i<N;i++) {
			String[] temp = bf.readLine().split(" ");
			for(int j=0;j<N;j++){
				if(i==j){continue;}
				if(!visited[i][j]){
					long v = Integer.parseInt(temp[j]);
					visited[i][j]= true;
					visited[j][i]=true;
					arr.add(new Node(i,j,v));
					arr.add(new Node(j,i,v));
				}
			}
		}
		
		Collections.sort(arr);
		for(Node n : arr) {
			if(find(n.x) != find(n.y)) {
				union(n.x,n.y);
				cnt++;
				answer+=n.d;
			}
			if(cnt==N-1) {
				break;
			}
		}
		System.out.println(answer);
		
	}// 메인 함수
	
	public static void union(int x,int y) {
		int X = find(x);
		int Y = find(y);
		uf[X] = Y;
	}
	public static int find(int x) {
		if(uf[x]==x) {
			return x;
		}
		int root = find(uf[x]);
		uf[x] = root;
		return root;
	}
	static class Node implements Comparable<Node>{
		int x;
		int y;
		long d;
		public Node(int x,int y, long d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
		@Override
		public int compareTo(Node n) {
	        if(this.d > n.d) {
	            return 1; 
	        } else if (this.d==n.d){
				return 0;
			}
	        return -1;
	    }
	}
}