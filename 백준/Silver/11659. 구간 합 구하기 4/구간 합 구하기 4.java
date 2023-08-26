import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		arr[0] = sc.nextInt();
		for (int i = 1; i < N; i++) {
			arr[i] = arr[i-1] + sc.nextInt();
		}
		
		for(int i =0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int answer = arr[b-1];
			if (a!=1){ answer -= arr[a-2];}
			System.out.println(answer);
		}

	}
}