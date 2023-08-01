import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int hour = 0;
        int minu = 0;

        if (m>=45){
            System.out.printf("%d %d",n,m-45);
        } else {
            m -= 45;
            if (n==0){
                n = 24;
            }
            System.out.printf("%d %d",n-1,60+m);
        }
    }
}