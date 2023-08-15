import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //사람수
        int n = sc.nextInt();
        //시간수
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        //정렬
        Arrays.sort(arr);

        //누적합
        for(int i=1;i<n;i++){
            arr[i] += arr[i-1];
        }
        //누적합 총합
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }
        System.out.println(sum);
    }
}