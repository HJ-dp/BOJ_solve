import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while(s!=null){
            if (s!=null){
            System.out.println(s);
            try {
                s = sc.nextLine();
            }catch(Exception e) {
                break;
            }
        }
        }
	}
}