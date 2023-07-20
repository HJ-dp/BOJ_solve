import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int d = sc.nextInt();

		double day = (double)(d - a) / (a - b) + 1;
        day = Math.ceil(day);

		System.out.println(Math.round(day));
	}
}