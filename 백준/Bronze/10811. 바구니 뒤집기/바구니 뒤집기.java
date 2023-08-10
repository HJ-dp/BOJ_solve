import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = i+1;
		}
		
		for(int k=0;k<m;k++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int[] temp = new int[b-a+1];
            int size = b-a;
            for(int i=a-1;i<b;i++){
                temp[size--] = arr[i];
            }
            
            for(int i=a-1;i<b;i++){
                arr[i] = temp[++size];
            }
		}
        for(int i : arr){
            System.out.print(i+" ");
        }
	}
}
