import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        for (int i=0;i<m;i++){
            boolean sep = (sc.nextInt()==1) ? true : false;
            int num = sc.nextInt();
            if (sep){
                int start = num - 1;
                while(start<n){
                    arr[start] = (arr[start]==0) ? 1:0;
                    start += num;
                }

            } else {
                int check=1;
                int now = num-1;
                arr[now] = (arr[now]==0)? 1 : 0;
                while (true){
                    if (isRange(n,now-check) && isRange(n,now+check) && arr[now-check] == arr[now+check]){
                        arr[now-check] = (arr[now-check]==0) ? 1:0;
                        arr[now+check] = (arr[now+check]==0) ? 1:0;
                        check++;
                    } else {
                        break;
                    }
                }
            }
            
        }
        for (int i=1;i<arr.length+1;i++){
            System.out.printf("%d ",arr[i-1]);
            if (i%20==0){System.out.println();}
        }
    }
    public static boolean isRange(int n,int x){
        return 0 <= x && x < n;
    }

}