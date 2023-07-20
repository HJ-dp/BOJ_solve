import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr;
        while (true){
            String s = sc.nextLine();
            if (s.equals("#")){
                break;
            } else {
                s = s.toLowerCase();
                arr = s.split("");
                int temp = 0;
                for(int i=0;i<arr.length;i++){
                    if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("o") || arr[i].equals("u") || arr[i].equals("i")){
                        temp += 1;
                    }
                }
                System.out.println(temp);
                
            }
        }
    }
}