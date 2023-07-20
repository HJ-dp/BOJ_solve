import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int comp = n * m;
        int[] answer = new int[5];
        for (int i=0;i<5;i++){
            int t = sc.nextInt();
            answer[i] = t - comp;
        }
        for (int i=0;i<5;i++){
            System.out.print(answer[i]+" ");
        }
    }
}