import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = bf.readLine().split("");
		LinkedList<String> list = new LinkedList<>();
		for (String a : s) {
			list.add(a);
		}
		int n = Integer.parseInt(bf.readLine());

		ListIterator<String> iter = list.listIterator();
		while(iter.hasNext()) {
			iter.next();
		}
		for (int tc = 1; tc <= n; tc++) {
			StringTokenizer stk = new StringTokenizer(bf.readLine(), " ");
			switch (stk.nextToken()) {
			case "L":
				if (iter.hasPrevious()) {
					iter.previous();
				}
				break;
			case "D":
				if (iter.hasNext()) {
					iter.next();
				}
				break;
			case "B":
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			case "P":
				iter.add(stk.nextToken());
				break;
			}
		}
		for (String a : list) {
			bw.write(a + "");
		}
		bw.flush();
		bw.close();
	}
}