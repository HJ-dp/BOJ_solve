
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] answer = new int[n];
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}

		int idx = 0;
		int i = 0;
		int cnt = 1;
		//배열을 끝까지 채울때까지 반복
		while (answer[n - 1] == 0) {
			//이미 들어간 값일때
			if (arr[i % n] == 0) {
				//카운트 감소시키기
				cnt--;
			} else if (cnt == k && arr[i % n] != 0) {
				//정답 배열 안에 넣기
				answer[idx++] = arr[i % n];
				//사용한 숫자임을 표시
				arr[i % n] = 0;
				//카운트 초기화
				cnt = 0;
			}
			cnt++;
			i++;
		}
		//출력부
		System.out.print("<");
		for (int j = 0; j < n - 1; j++) {
			System.out.print(answer[j] + ", ");
		}
		System.out.print(answer[n - 1] + ">");
	}
}