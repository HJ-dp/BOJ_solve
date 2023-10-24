import java.util.*;
import java.io.*;

public class Main {
    static int N, M, arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //가지고 있는 카드
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        String[] temp = bf.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(arr);
        //찾을 숫자
        M = Integer.parseInt(bf.readLine());
        temp = bf.readLine().split(" ");
        for(int i=0;i<M;i++){
            int a = Integer.parseInt(temp[i]);
            sb.append(bs(a)).append("\n");
        }

        System.out.println(sb);
        
    }

    public static int bs(int x){
        int left = 0;
        int right = N-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] > x){
                right = mid -1;
            } else if (arr[mid] < x){
                left = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}