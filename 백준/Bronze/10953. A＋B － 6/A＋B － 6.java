import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			String s = sc.next();
			String[] arr = s.split(",");
			int answer = 0;
			answer += Integer.parseInt(arr[0]);
			answer += Integer.parseInt(arr[1]);
			System.out.println(answer);
		}
	}
}