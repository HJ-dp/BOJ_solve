import java.io.*;
import java.util.*;

public class Main {
	public static int N;
    public static Node arr[] = new Node[41];
    public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
        arr[0] = new Node(1,0);
        arr[1] = new Node(0,1);
        arr[2] = new Node(1,1);
        for(int i=3;i<41;i++){
            Node a = arr[i-1];
            Node b = arr[i-2];
            arr[i] = new Node(a.x+b.x,a.y+b.y);
        }

        while(N-->0){
            int K = Integer.parseInt(bf.readLine());
            sb.append(arr[K].x).append(" ").append(arr[K].y).append("\n");
        }
        System.out.println(sb);
        //입력 끝
    }
    static class Node{
        int x,y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}