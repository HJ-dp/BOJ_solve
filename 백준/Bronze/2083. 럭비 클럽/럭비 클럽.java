import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			String s = sc.next();
			String de = "Junior";
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (s.equals("#")){
				break;
			} 
			if (a > 17 || b >= 80){
				de = "Senior";
			}
			System.out.printf("%s %s\n",s,de);


		}
		
	}
}