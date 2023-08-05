import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = 0;
        int m = 0;
        int s = 0;
		for (int i = 0; i < 4; i++) {
			n += sc.nextInt();
		}
        m = n / 60;
        s = n % 60;
        System.out.printf("%d\n%d",m,s);
	}
}