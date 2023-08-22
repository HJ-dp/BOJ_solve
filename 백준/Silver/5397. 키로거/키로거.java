import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 테스트케이스 수
		int n = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= n; tc++) {
			String[] s = bf.readLine().split("");
			LinkedList<String> list = new LinkedList<>();
			ListIterator<String> iter = list.listIterator();
			for (String a : s) {
				switch (a) {
				case "<":
					if (iter.hasPrevious()) {
						iter.previous();
					}
					break;
				case ">":
					if (iter.hasNext()) {
						iter.next();
					}
					break;
				case "-":
					if (iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				default:
					iter.add(a);
					break;
				}
			}
			for (String a : list) {
				bw.write(a + "");
			}
            bw.write("\n");
			bw.flush();

		}
		bw.close();
	}
}