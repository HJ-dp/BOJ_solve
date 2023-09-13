import java.util.*;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i =0;i<3;i++){
            int a = sc.nextInt();
            BigInteger compare = new BigInteger("0");
            BigInteger sum = new BigInteger("0");
            for(int j = 0;j<a;j++){
                BigInteger c = new BigInteger(sc.next());
                sum=sum.add(c);
            }
            String s = (sum.equals(compare))? "0" : (sum.compareTo(compare) > 0)? "+":"-";
            System.out.println(s);
        }
    }
}