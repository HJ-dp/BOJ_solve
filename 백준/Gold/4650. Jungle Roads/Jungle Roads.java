import java.io.*;
import java.util.*;

public class Main {
	
	public static int answer, cnt, uf[];
	public static ArrayList<Node> arr;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			answer = cnt = 0;
			arr = new ArrayList<>();
			int N = Integer.parseInt(bf.readLine());
			if(N==0) {break;}
			//메이크셋 
			uf = new int[28];
			for(int i=1;i<28;i++) {
				uf[i]= i;
			}
			
			for(int i =1;i<N;i++) {
				String[] temp = bf.readLine().split(" ");
				int a = temp[0].charAt(0)-64;
				int T = Integer.parseInt(temp[1]);
				for(int j=1;j<=T;j++) {
					int b = temp[2*j].charAt(0)-64;
					int v = Integer.parseInt(temp[2*j+1]);
					arr.add(new Node(a,b,v));
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
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		
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
	        }else if (this.d==n.d){
				return 0;
			}
	        return -1;
	    }
	}
}