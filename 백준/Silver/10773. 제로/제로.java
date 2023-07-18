import java.util.Scanner;
import java.util.Stack;
public class Main {
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
    Stack<Integer> st = new Stack<>();
    for (int i=0;i<T;i++){
        int a = sc.nextInt();
        if (a==0){
            st.pop();
        } else {
            st.push(a);
        }
    }
    int sum=0;
    for (int i=0;i<st.size();i++){
        sum += st.get(i);
    }
	System.out.print(sum);
}
}