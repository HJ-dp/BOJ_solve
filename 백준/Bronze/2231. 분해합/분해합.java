import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int answer = 0;
		int N = Integer.parseInt(s);
		for (int i = 1; i <= N; i++) {
			if (bun(i) == N) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

	public static int bun(int s) {
		int N = s;
		while (s > 0) {
			N += s % 10;
			s /= 10;
		}
		return N;
	}
}