import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo(n));
    }

    public static int fibo(int i){
        int[] arr = new int[i+1];
        arr[0] = 0;
        arr[1] = 1;
        for (int j=2;j<i+1;j++){
            arr[j] = arr[j-1] + arr[j-2];
        }
        return arr[i];
    }
}