import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        try{
            for(int i=0;i<n;i++){
            String s = sc.next();
            String[] arr = s.split("");
            for(int j=s.length()-1;j>=0;j--){
                System.out.print(arr[j]);
            }
            System.out.println();
        }
        } catch(Exception e) {

        }
        
    }
}