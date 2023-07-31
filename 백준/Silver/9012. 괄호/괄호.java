import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			String[] arr = new String[n];
			int size = 0;
			String s = sc.next();
			String[] temp = s.split("");
			for (String a : temp) {
				if (a.equals("(")) {
					arr[size++] = a;
				} else if (a.equals(")") && size!=0 && arr[size-1].equals("(")) {
						size--;
				} else {
					arr[size++] = a;
				}
			}
			if (size > 0) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
			
		}
	}
}