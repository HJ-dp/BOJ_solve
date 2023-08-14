import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] temp = s.split("");
		int i = 1;
		int zero = 0;
		int one = 0;
		boolean now = (temp[0].equals("0")) ? true : false;
		if (temp[0].equals("0")) {
			zero++;
		} else {
			one++;
		}
		while (i < temp.length) {
			boolean nowon = (temp[i].equals("0")) ? true : false;
			if (now == nowon) {
				i++;
				continue;
			} else {
				if (temp[i].equals("0")) {
					zero++;
				} else {
					one++;
				}
			}
			i++;
			now = nowon;
		}
		int answer = (zero < one) ? zero : one;
		System.out.print(answer);
	}
}