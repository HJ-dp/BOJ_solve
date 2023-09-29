import java.io.*;
import java.util.*;

public class Main {
	public static Long N, M;
	public static Queue<Long> q = new LinkedList<>();
	public static HashMap<Long, Long> hs = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Long.parseLong(temp[0]);
		M = Long.parseLong(temp[1]);
		push(N);
		hs.put(N, (long) 0);
		BFS();
		Long answer = (hs.containsKey(M))? hs.get(M)+1 :-1;
		System.out.println(answer);
	}

	public static void push(Long x) {
		q.add(x);
	}

	public static void BFS() {
		while (!q.isEmpty()) {
			Long Num = q.poll();
			Long nowX = Num * 2;
			if (canGo(nowX)) {
				hs.put(nowX, hs.get(Num)+1);
				push(nowX);
			}
			nowX = Num * 10 +1;
			if (canGo(nowX)) {
				hs.put(nowX, hs.get(Num)+1);
				push(nowX);
			}
		}
	}

	public static boolean isRange(Long x) {
		return 1 <= x && x <= M;
	}

	public static boolean canGo(Long x) {
		if (!isRange(x))
			return false;
		else if (hs.containsKey(x))
			return false;
		return true;
	}
}