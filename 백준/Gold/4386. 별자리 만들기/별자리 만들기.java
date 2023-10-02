import java.util.*;
import java.io.*;

public class Main {
	public static int N, M, uf[];
	public static double stars[][];
	public static ArrayList<Node> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//별의 수
		N = Integer.parseInt(bf.readLine());
		stars = new double[N][2];
		uf = new int[N];
		for(int i=0;i<N;i++){
			uf[i] = i;
		}
		//맵 입력받기
		for(int i=0;i<N;i++){
			String[] temp = bf.readLine().split(" ");
			Double a = Double.parseDouble(temp[0]);
			Double b = Double.parseDouble(temp[1]);
			stars[i][0] = a;
			stars[i][1] = b;
		}// 입력 끝
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(i==j){continue;}
				double a = Math.abs(stars[j][0] - stars[i][0]);
				double b = Math.abs(stars[j][1] - stars[i][1]);
				double c = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
				arr.add(new Node(i,j,c));
			}
		}
		Collections.sort(arr);
		int n = 0;
		double answer = 0.0;
		for(Node i : arr){
			if(find(i.x)==find(i.y)){continue;}
			union(i.x,i.y);
			answer += i.v;
			n++;
			if(n==N-1){break;}
		}
		System.out.printf("%.2f",(double) Math.round(answer * 100) / 100);
    }

	public static void union(int x, int y){
		int X = find(x);
		int Y = find(y);
		if(X==Y) return;
		uf[X] = Y;
	}

	public static int find(int x){
		if(uf[x]==x){
			return x;
		}
		int root = find(uf[x]);
		uf[x] = root;
		return root;
	}

	static class Node implements Comparable<Node>{
		int x, y;
		double v;
		public Node(int x,int y,double v){
			this.x = x;
			this.y = y;
			this.v = v;
		}
		@Override
		public int compareTo(Node n){
			if ((this.v - n.v) > 0) return 1;
			else if ((this.v - n.v) < 0) return -1;
			return 0;
		} 
	}
}