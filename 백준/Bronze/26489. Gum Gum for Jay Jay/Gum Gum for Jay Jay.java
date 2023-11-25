import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(true) {
            try{
                sc.next();
                sum++;
            }catch(Exception e1){
                System.out.println(sum/5);
                break;
            }
        }   
    }
}