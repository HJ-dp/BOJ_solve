import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap; 


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, String> map = new HashMap<>();
		String[] temp = bf.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		for (int i = 0; i<n;i++) {
			temp = bf.readLine().split(" ");
			map.put(temp[0], temp[1]);
		}
		
		for (int i =0; i<m;i++) {
			String s = bf.readLine();
			bw.write(map.get(s)+"\n"); 
		}
		bw.flush(); 
		bw.close();

		
	}

}
