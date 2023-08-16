import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String[][] arr = new String[5][];
        //배열의 행중 최대길이
        int max = 0;
        for(int i=0;i<5;i++){
            //입력받고
            String s = sc.next();
            arr[i] = s.split("");
            //최대길이구하기
            if (max < arr[i].length){
                max = arr[i].length;
            }
        }

        //행의 최대길이 만큼
        for(int i=0;i<max;i++){
            //모든행을 돌면서
            for(int j=0;j<5;j++){
                if (isRange(arr[j],i)) {
                    System.out.print(arr[j][i]);
                }
            }
        }
    }

    //범위 체크
    public static boolean isRange(String[] arr, int x){
        int n = arr.length;
        return 0 <= x && x < n;
    }
}