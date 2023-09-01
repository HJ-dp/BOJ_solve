import java.util.*;

public class Main {

    public static int N =0;
    public static int M =0;
    public static ArrayList<Integer> arr = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        let(0);
	}
    public static void let(int a){
        if(arr.size() == M){
            print();
            return;
        }
        for(int i=1;i<=N;i++){
            if(arr.contains(i)){continue;}
            arr.add(i);
            let(a+1);
            arr.remove(arr.size()-1);
        }
    } 

    public static void print(){
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }
    
}