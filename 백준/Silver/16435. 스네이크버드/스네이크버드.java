import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//과일 개수
		int n = sc.nextInt();
		//뱀
		int snake = sc.nextInt();
		//과일 배열
		int[] arr = new int[n];
		//과일 입력받기
		for(int i = 0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		//정렬
		Arrays.sort(arr);
		for(int i=0;i<n;i++) {
            //뱀보다 큰 높이의 과일을 만나면 멈추기
			if(snake < arr[i]) {
				break;
			}
			snake++;
		}
        //출력
		System.out.println(snake);
		
	}
}
