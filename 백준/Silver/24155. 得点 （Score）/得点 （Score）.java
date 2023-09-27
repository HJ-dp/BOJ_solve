import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[102];
        List<Integer> li = new ArrayList<>();
        for (int i=0;i<T;i++){
            int a = Integer.parseInt(br.readLine());
            arr[a]++;
            li.add(a);
        }
        for(int i=99;i>=0;i--){
            arr[i] += arr[i+1];
        }
        for (int i : li){
            int answer = (arr[i+1]==0)? 1 : arr[i+1]+1;
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}