import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int num =0;
		
		int bre = N/2;
		for (int i = 0; i < bre; i++) {
			if(M>0) {
				M--;
				num++;
			}
		}
		System.out.println(num);
	}
}