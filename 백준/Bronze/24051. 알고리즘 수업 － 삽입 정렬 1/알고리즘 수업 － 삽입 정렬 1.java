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

		All: for (int i = 1; i < n; i++) {
			int loc = i - 1;
			int newItem = arr[i];
			while (0 <= loc && newItem < arr[loc]) {
                cnt++;
                if (cnt==m){System.out.print(arr[loc]); break All;}
				arr[loc + 1] = arr[loc];
				loc--;
			}
			if (loc + 1 != i) {
                cnt++;
                if (cnt==m){System.out.print(arr[loc]); break All;}
				arr[loc + 1] = newItem;
			}
		}
        if (cnt < m){System.out.print(-1);}
	}
}