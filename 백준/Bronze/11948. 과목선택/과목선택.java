import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int n2 = Integer.parseInt(bf.readLine());
		int n3 = Integer.parseInt(bf.readLine());
		int n4 = Integer.parseInt(bf.readLine());
		int n5 = Integer.parseInt(bf.readLine());
		int n6 = Integer.parseInt(bf.readLine());
		int sum = n + n2 + n3+ n4;
		int m = Math.min(n,n2);
		m = Math.min(m,n3);
		m = Math.min(m,n4);
		sum -= m;
		int mm = Math.max(n5,n6);
		System.out.println(sum+mm);
	}	
}