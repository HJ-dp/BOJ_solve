import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
	public static HashMap<String,Integer> hsMap = new HashMap<>();
	public static ArrayList<String> hs = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		for (int i = 1; i <= N; i++) {
			String s = bf.readLine();
			hs.add(s);
			hsMap.put(s, i);
		} // 입력끝
		for (int i = 0; i < M; i++) {
			String s = bf.readLine();
			if (hsMap.containsKey(s)) {
				sb.append(hsMap.get(s)).append("\n");
			} else {
				sb.append(hs.get(Integer.parseInt(s)-1)).append("\n");
			}
		}
		System.out.println(sb);
	}
}