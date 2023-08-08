import java.util.Scanner;

public class Main {
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int hive = 1;
		int answer = 1;
		while (n>hive) {
			hive += (6*answer);
			answer++;
		}
		System.out.println(answer);
	}
}