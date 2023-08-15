import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //동전수
        int n = sc.nextInt();
        //돈
        int money = sc.nextInt();
        //동전들
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        //동전수
        int cnt = 0;
        //큰 수부터 나눠내려가기
        int i = n-1;
        while(money!=0){
            cnt += money / arr[i];
            money %= arr[i];
            i--;
        }
        System.out.println(cnt);
    }
}