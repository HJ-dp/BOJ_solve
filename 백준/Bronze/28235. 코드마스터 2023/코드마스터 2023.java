import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String a = "";
        switch(s){
            case "SONGDO":
                a = "HIGHSCHOOL";
                break;
            case "CODE":
                a = "MASTER";
                break;
            case "2023":
                a = "0611";
                break;
            case "ALGORITHM":
                a = "CONTEST";
                break;
        }
        System.out.println(a);
    }
}