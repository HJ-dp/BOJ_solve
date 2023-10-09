import java.util.*;

public class Main {
    public static int N, count, arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        Queen(0);
        System.out.println(count);
    }

    public static void Queen(int d){
        if(d==N){
            count++;
            return;
        }

        for(int i=0;i<N;i++){
            arr[d] = i;
            if(possible(d)){
                Queen(d+1);
            }
        }
    }


    public static boolean possible(int t){
        for(int i=0;i<t;i++){
            if(arr[t] ==  arr[i]){
                return false;
            }
            else if(Math.abs(t - i) == Math.abs(arr[t] - arr[i])){
                return false;
            }
        }
        return true;
    }
}