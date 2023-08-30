import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int k=0;k<n;k++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int answer = 1;
            for(int i=0;i<b;i++){
                answer = answer * a %10; 
            }
            answer = (answer==0)? 10:answer;
            System.out.println(answer);
        }       
	}
}