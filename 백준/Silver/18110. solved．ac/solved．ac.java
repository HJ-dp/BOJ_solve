import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.IOException;

public class Main {
	public static void main(String args[])throws IOException  {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //투표인원수
		int T = Integer.parseInt(bf.readLine());;
        int answer = 0;
        int[] arr = new int[T];
        //인원수 의견 입력
        for(int i=0;i<T;i++){
            arr[i] = Integer.parseInt(bf.readLine());;
        }
        //15%
        int n = (int) Math.round(T*0.15);
        //정렬
        Arrays.sort(arr);
        //앞뒤 15% 자르기
        int[] arr2 = Arrays.copyOfRange(arr, 0+n, arr.length-n);

        //평균값 구하기
        double sum = 0;
        for (int i =0;i<arr2.length;i++){
            sum += arr2[i];
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        answer = (int) Math.round(sum / arr2.length);
        bw.write(answer+"");  
        bw.flush(); 
        bw.close(); 
	}
}