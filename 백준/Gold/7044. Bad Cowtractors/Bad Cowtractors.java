import java.io.*;
import java.util.*;

public class Main {

	public static int cnt, uf[];
	public static long answer, total;
	public static boolean ok;
	public static ArrayList<Node> arr = new ArrayList<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		// 메이크셋
		uf = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			uf[i] = i;
		}

		for (int i = 0; i < M; i++) {
			temp = bf.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);
			arr.add(new Node(a, b, c));
		}

		Collections.sort(arr);
		for (Node n : arr) {
			if (find(n.x) != find(n.y)) {
				union(n.x, n.y);
				cnt++;
				answer += n.d;
			}
			if (cnt == N-1) {
				ok = true;
				break;
			}
		}
		if(ok){
			sb.append(answer).append("\n");
		} else {
			sb.append(-1).append("\n");
		}
		System.out.println(sb);

	}// 메인 함수

	public static void union(int x, int y) {
		int X = find(x);
		int Y = find(y);
		uf[X] = Y;
	}

	public static int find(int x) {
		if (uf[x] == x) {
			return x;
		}
		int root = find(uf[x]);
		uf[x] = root;
		return root;
	}

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int d;

		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Node n) {
			if (this.d < n.d) {
				return 1;
			} else if (this.d == n.d) {
				return 0;
			}
			return -1;
		}
	}
}