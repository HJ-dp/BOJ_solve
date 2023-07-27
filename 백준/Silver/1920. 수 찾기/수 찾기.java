import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st, stt;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		int[] arr2 = new int[m];
		stt = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr2[i] = Integer.parseInt(stt.nextToken());
		} 
		Arrays.sort(arr);

		for (int i = 0; i < m; i++) {
			if (Arrays.binarySearch(arr, arr2[i]) >= 0) {
				bw.write(1 + "\n"); // 버퍼에 있는 값 전부 출력
				bw.flush(); // 남아있는 데이터를 모두 출력시킴
			} else {
				bw.write(0 + "\n"); // 버퍼에 있는 값 전부 출력
				bw.flush(); // 남아있는 데이터를 모두 출력시킴
			}
		}
		bw.close();
	}
}