import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String s = bf.readLine();
		String[] temp = s.split("");
        long answer = 0;
		for(int i =0;i<temp.length;i++) {
			char rr =temp[i].charAt(0);
            int num = (int)rr - 96;
            answer += ((num * Math.pow(31,i)));
		}
        System.out.println((answer%1234567891));
	}
}