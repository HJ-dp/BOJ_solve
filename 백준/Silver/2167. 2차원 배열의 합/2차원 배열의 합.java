import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int x1 = sc.nextInt() - 1;
			int y1 = sc.nextInt() - 1;
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			int sum = 0;
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					sum += arr[i][j];
				}
			}
			System.out.println(sum);
		}
	}
}
