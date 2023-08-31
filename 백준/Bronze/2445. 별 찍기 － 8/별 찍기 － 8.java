import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int k=1;k<=n;k++){
        	for(int i=0;i<k;i++) {
        		System.out.print("*");
        	}
        	for(int i=0;i<n*2-(2*k);i++) {
        		System.out.print(" ");
        	}
        	for(int i=0;i<k;i++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
        for (int k=n-1;k>0;k--){
        	for(int i=k;i>0;i--) {
        		System.out.print("*");
        	}
        	for(int i=0;i<n*2-(2*k);i++) {
        		System.out.print(" ");
        	}
        	for(int i=k;i>0;i--) {
        		System.out.print("*");
        	}
        	System.out.println();
        }              
	}
}