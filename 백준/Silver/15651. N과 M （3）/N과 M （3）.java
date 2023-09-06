import java.util.Scanner;

public class Main {

	public static int N, M = 0;
	public static int[] answer;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		answer = new int[M];
		let(0);
		System.out.println(sb);
	}

	public static void let(int d) {
		if(d==M) {
			for(int i=0;i<M;i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			answer[d] = i;
			let(d+1);
		}
		

	}

}