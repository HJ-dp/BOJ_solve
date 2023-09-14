import java.util.Scanner;

public class Main {
    public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.next().split("");
        int cnt = 0;
        boolean check = false;
        All:
		for(String a : s) {
			if (a.equals("X")) {
				cnt++;
                continue;
            } else if ((a.equals("."))&& cnt>0){  
				if (check(cnt)){
                    check = true;
                    break All;
                }
                cnt = 0;
                sb.append(".");
                continue;
			}
            cnt = 0;
            sb.append(".");
		}
        if (check(cnt)){
            check = true;
        }
        if (check){
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
	}
    public static boolean check(int cnt){
        if(cnt % 2==1){
            return true;
        }
        while(cnt!=0){
            if(cnt >=4){
                cnt -= 4;
                sb.append("AAAA");
            } else if(cnt==2){
                cnt -= 2;
                sb.append("BB");
            }
        }
        return false;
    }
}