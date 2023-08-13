import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for(int k=0;k<n;k++){
            String s = sc.next();
            String[] temp = s.split("");
            List<String> checker = new ArrayList<>();
            boolean check = true;
            checker.add(temp[0]);
            for(int i=1;i<temp.length;i++){
                if(temp[i-1].equals(temp[i])){
                    continue;
                } else {
                    if (checker.contains(temp[i])){
                        check = false;
                        break;
                    } else{
                        checker.add(temp[i]);
                    }
                }
            }
            if (check){cnt++;}  
        }
        System.out.print(cnt);
    }
}