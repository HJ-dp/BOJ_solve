import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        //최고활잡이
        int max = 0;
        //현재까지 지나온 봉우리
        int now = 0;
        //현재높이
        arr[0] = sc.nextInt();
        int mh = arr[0];
        for(int i=1;i<n;i++){
            arr[i] = sc.nextInt();
            if(mh > arr[i]){
                now++;
                if (now>max){
                max = now;
                }
                continue;
            } else {
                mh = arr[i];
                now=0;
            }
        }
        System.out.println(max);
    }
}