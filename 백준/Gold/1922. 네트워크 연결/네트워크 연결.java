import java.io.*;
import java.util.*;

public class Main {
	
	public static int answer, cnt, uf[];
	public static ArrayList<Node> arr = new ArrayList<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		//메이크셋 
		uf = new int[N+1];
		for(int i=1;i<=N;i++) {
			uf[i]= i;
		}
		
		for(int i =0;i<M;i++) {
			String[] temp = bf.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);
			arr.add(new Node(a,b,c));
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
		int d;
		public Node(int x,int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
		@Override
		public int compareTo(Node n) {
	        if(this.d > n.d) {
	            return 1; 
	        }
	        return -1;
	    }
	}
}