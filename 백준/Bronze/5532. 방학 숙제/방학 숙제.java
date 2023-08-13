import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        double d = sc.nextInt();
        int answer = (Math.ceil(a/c) > Math.ceil(b/d))? (int)(n-Math.ceil(a/c)) : (int)(n-Math.ceil(b/d));
        System.out.print(answer);
        }
}