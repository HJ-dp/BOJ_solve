import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
        int[] answer = new int[7];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		All:
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
                if (i!=j){
                    answer = seven(arr,i,j);
                    if (hap(answer)==100) {
                        Arrays.sort(answer);
                        break All;
				}
                }
			}
		}
        for (int i:answer){
            System.out.println(i);
        }
		
	}
	
	public static int[] seven(int[] arr, int n, int m) {
		//새 배열 생성
		int[] newArr = new int[7];
		int idx = 0;
		for(int i=0;i<arr.length;i++) {
			//지정된 값일 경우 
			if(arr[i]==arr[n] || arr[i]==arr[m]){
				//넘어감
				continue;
				//정상 값일 경우
			} else {
				//새 배열에 넣어줌
				newArr[idx++] = arr[i];
			}
		}
		//선택된 7명 배열 반환
		return newArr;
	}
	// 배열 합 구하기
	public static int hap(int[] arr) {
		int sum = 0;
		for (int i:arr) {
			sum += i;
		}
		return sum;
	}
}