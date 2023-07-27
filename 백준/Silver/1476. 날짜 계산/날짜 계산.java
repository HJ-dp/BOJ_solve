import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int cnt = 0;
        while (true){
            int a = (cnt%15)+1;
            int b = (cnt%28)+1;
            int c = (cnt%19)+1;
            if (a==e && b==s && c==m){
                System.out.print(cnt+1);
                break;
            }
            cnt++;
        }
    }
}