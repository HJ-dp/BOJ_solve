import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int k=1;k<n+1;k++){
            for (int i =0;i<n-k;i++){
                System.out.print(" ");
            }
            for (int j=0;j<(2*k)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int k=1;k<n;k++){
            for (int i =0;i<k;i++){
                System.out.print(" ");
            }
            for (int j=1;j<(2*n)-2*k;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        
	}
}