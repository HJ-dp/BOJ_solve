import java.util.*;
import java.io.*;

public class Main {
	
	public static tree[] map;
	public static tree root;
	public static int rootInt;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int N = Integer.parseInt(s);
		String[] tmp = bf.readLine().split(" ");
		map = new tree[N];
		for(int i=0;i<N;i++) {
			map[i] = new tree();
		}
		for (int i = 0; i < tmp.length; i++) {
			if(!tmp[i].equals("-1")) {
			int a = Integer.parseInt(tmp[i]);
			map[a].cT += Integer.toString(i) + " ";
			} else {
				root = map[i];
				rootInt = i;
			}
		}
		s = bf.readLine();
		int M = Integer.parseInt(s);
		// 입력끝

		Stack<tree> stack = new Stack<>();
		int answer = 0;
		if(M!=rootInt) {
			stack.add(root);			
		}
		while (!stack.isEmpty()) {
			tree temp = stack.pop();
			if (temp.cT.equals("")) {
				answer++;
				continue;
			}
			String[] arr = temp.cT.split(" ");
			for (int i = 0; i < arr.length; i++) {
				int tp = Integer.parseInt(arr[i]);
				if (tp == M && arr.length == 1) {
					answer++;
				}
				if (tp != M) {
					stack.add(map[tp]);
				}
			}
		}
		System.out.println(answer);
	}

	static class tree {
		String cT;

		public tree() {
			this.cT = "";
		}
	}
}