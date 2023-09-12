import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n = Math.min(n,sc.nextInt());
        n = Math.min(n,sc.nextInt());
        int m = sc.nextInt();
        m = Math.min(m,sc.nextInt());
        System.out.println(n+m-50);
    }
}