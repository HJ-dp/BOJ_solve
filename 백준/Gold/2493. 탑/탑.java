import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] s = bf.readLine().split(" ");
        for(int k =0;k<n;k++){
        	//숫자받고
            int num = Integer.parseInt(s[k]);
            while(true){
                if(stack.isEmpty()){
                    sb.append(0).append(" ");
                    stack.push(new Node(num,k+1));
                    break;
                }
                Node now = stack.pop();
                if(now.value < num){
                    continue;
                } else if (now.value > num){
                    sb.append(now.idx).append(" ");
                    stack.push(now);
                    stack.push(new Node(num,k+1));
                    break;
                } else {
                    sb.append(now.idx).append(" ");
                    stack.push(new Node(num,k+1));
                    break;
                }
            }
        }
        System.out.println(sb);
	}

    static class Node{
        int value;
        int idx;
        public Node(int x,int y){
            this.value = x;
            this.idx = y;
        }
    }
}