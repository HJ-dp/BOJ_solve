import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String N = bf.readLine();
        String K = bf.readLine();
        BigInteger a = new BigInteger(N);
        BigInteger b = new BigInteger(K);
        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
    }
}