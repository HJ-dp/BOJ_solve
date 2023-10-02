import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static int N, M;
    public static ArrayList<Integer> arr = new ArrayList<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        boolean zero = false;
		String[] temp = bf.readLine().split(" ");
        for(int i=0;i<N;i++){
            M = Integer.parseInt(temp[i]);
            if(M!=0){zero=true;}
            arr.add(M);
        }

        Collections.sort(arr, new NumberComparator());
        Collections.reverse(arr);
        if(zero){
            for(int i=0;i<arr.size();i++){
                sb.append(arr.get(i));
            }
        } else {
            sb.append(0);
        }
        System.out.println(sb);
	}
    static class NumberComparator implements Comparator<Integer>{
	@Override
    public int compare(Integer o1, Integer o2){
        String s1 = Integer.toString(o1);
        String s2 = Integer.toString(o2);
        BigInteger a = new BigInteger(s1+s2);
        BigInteger b = new BigInteger(s2+s1);
    	return a.compareTo(b);
    }
    }
}