import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] day = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int answer = 0;
        
        System.out.println(day[(mon(n)+m-1)%7]);
    }
    
    public static int mon(int i){
        int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
        int temp = 0;
        for (int j =0;j<i-1;j++){
            temp += month[j];
        }
        return temp;
    }
}