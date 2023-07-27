import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int cnt = 0;
        int x = 0;
        int y = 0;
        All:
        for (int i = n-1; i > 0;i--){
            for (int j = 0;j<i;j++){
                if (arr[j] > arr[j+1]){
                    cnt++;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    if (cnt == m){x =arr[j]; y=arr[j+1]; break All;  }
                }
            }
        }
        if (cnt == m){
            if (x>y) {
                System.out.printf("%d %d",y,x);
            } else { 
                System.out.printf("%d %d",x,y);
            }
        } else if (cnt < m) { System.out.println(-1); }
    }
}