
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = {a,b,c};
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sec=0;
		for (int i : arr) {
			if (max < i) {
				max = i;
			}
			
			if (min > i) {
				min = i;
			}
		}
		for (int i : arr) {
			if (i != max && i != min) {
				sec = i;
			}
		}
		System.out.printf("%d %d %d",min,sec,max);
		
	}
}