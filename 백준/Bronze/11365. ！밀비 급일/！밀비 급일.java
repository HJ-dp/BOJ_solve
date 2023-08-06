import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        while (true){
            String s = sc.nextLine();
            if (s.equals("END")){break;}
            else {
                String[] temp = s.split("");
                for(int i=temp.length;i>0;i--){
                    System.out.print(temp[i-1]);
                }
                System.out.println();
            }
        }
	}
}