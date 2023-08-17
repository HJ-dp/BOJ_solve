import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String s = sc.nextLine();
            if (s.charAt(0)=='.'){
                break;
            } 
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<s.length();i++){
                if (s.charAt(i)=='('){
                    stack.push(s.charAt(i));
                } else if (s.charAt(i)==')' && !stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                } else if (s.charAt(i)=='['){
                    stack.push(s.charAt(i));
                } else if (s.charAt(i)==']' && !stack.isEmpty() && stack.peek()=='['){
                    stack.pop();
                } else if (s.charAt(i)==')' || s.charAt(i)==']'){
                    stack.push(s.charAt(i));
                }
            }

            String answer = (stack.isEmpty())? "yes" : "no";
            System.out.println(answer);
        }
    }
}

