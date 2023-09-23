import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static HashSet<Integer> hs = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String[] temp = bf.readLine().split(" ");
		for (int i = 0; i < temp.length; i++) {
			int n = Integer.parseInt(temp[i]);
			hs.add(n);
		}
		List<Integer> li = new ArrayList<>(hs);
		Collections.sort(li);
		for(int i=0;i<li.size();i++) {
			System.out.print(li.get(i)+" "); 
		}
	}
}