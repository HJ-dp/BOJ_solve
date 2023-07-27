import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int cnt = 0;
		int x = 0;
		int y = 0;
		All: 
        for (int i = n-1; i >= 0; i--) {
			int idx = i;
			int max = arr[i];
			for (int j = 0; j < i; j++) {
				// 최대값찾기
				if (max < arr[j]) {
					max = arr[j];
					idx = j;
				}
			}
			if (i != idx) {
				int temp = arr[i];
				arr[i] = arr[idx];
				arr[idx] = temp;
				cnt++;
				if (cnt == m) {
                    x = arr[i];
				    y = arr[idx];
					break All;
				}
			}
		}
		if (cnt == m) {
			if (x > y) {
				System.out.printf("%d %d", y, x);
			} else {
				System.out.printf("%d %d", x, y);
			}
		} else if (cnt < m) {
			System.out.println(-1);
		}
	}
}