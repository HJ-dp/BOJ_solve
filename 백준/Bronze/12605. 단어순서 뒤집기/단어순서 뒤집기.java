import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i=1;i<=n;i++){
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            String[] answer = new String[arr.length];
            for(int j=0;j<arr.length;j++){
                answer[j] = arr[arr.length-1-j];
            }
            String a = String.join(" ",answer);
            System.out.printf("Case #%d: %s\n",i,a);
        }
    }
}