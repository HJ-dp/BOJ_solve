import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr;
        arr = s.split("");
        for (int i=0;i<s.length();i++){
            if (i!=0 && i%10==0){
                System.out.println();
            }
            System.out.print(arr[i]); 
        }
    }
}