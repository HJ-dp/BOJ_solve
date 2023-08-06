import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i=0;i<3;i++){
            arr[i] = sc.nextInt();
        }
        
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (arr[i]<arr[j]){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            }
        }
        System.out.print(arr[1]);
	}
}