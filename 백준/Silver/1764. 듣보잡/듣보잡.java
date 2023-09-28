import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static ArrayList<String> answer = new ArrayList<>();
	public static HashSet<String> hs = new HashSet<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		for (int i = 0; i < N; i++) {
			String s= bf.readLine();
			hs.add(s);
		}// 입력끝
		for (int i = 0; i < M; i++) {
			String s= bf.readLine();
			if(hs.contains(s)) {
				answer.add(s);				
			}
		}
		Collections.sort(answer);
		sb.append(answer.size()).append("\n");
		for(String s : answer) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}