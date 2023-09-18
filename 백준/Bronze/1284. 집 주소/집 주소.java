import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0){break;}
            coco(n);
        }
    }

    public static void coco(int n){
        int num = 1;
        while(n!=0){
            int temp = n % 10;
            n /= 10;
            if (temp == 0){
                num += 4;
            } else if (temp == 1){
                num += 2;
            } else {
                num += 3;
            }
            num += 1;
        }
        System.out.println(num);
    }
}