import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float degree = 0;
        double grade = 0;
        for(int k=0;k<20;k++){
            String s = sc.next();
            float temp = sc.nextFloat();
            String g = sc.next();
            switch(g) {
                case "A+": 
                degree += temp;
                grade += 4.5* temp;
                break;
                case "A0":
                degree += temp;
                grade += 4.0* temp;
                break;
                case "B+":
                degree += temp;
                grade += 3.5* temp;
                break;
                case "B0":
                degree += temp;
                grade += 3.0* temp;
                break;
                case "C+":
                degree += temp;
                grade += 2.5* temp;
                break;
                case "C0":
                degree += temp;
                grade += 2.0* temp;
                break;
                case "D+":
                degree += temp;
                grade += 1.5* temp;
                break;
                case "D0":
                degree += temp;
                grade += 1.0 * temp;
                break;
                case "F":
                degree += temp;
                    break;
                case "P":
                break;
            }
        }
        System.out.print(String.format("%.6f",grade / degree));
    }
}