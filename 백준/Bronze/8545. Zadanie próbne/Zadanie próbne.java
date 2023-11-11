import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String a=s.next();
        for(int i=1;i<=a.length();i++){
            System.out.print(a.charAt(a.length()-i));
        }
    }
}