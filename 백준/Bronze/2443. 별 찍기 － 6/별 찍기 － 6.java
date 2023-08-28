import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int k=0;k<n;k++){
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