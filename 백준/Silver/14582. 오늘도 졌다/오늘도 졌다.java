import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int[] arr2 = new int[9];
        for (int j=0;j<9;j++) {
            arr[j] = sc.nextInt();
        }
        for (int j=0;j<9;j++) {
            arr2[j] = sc.nextInt();
        }
        String answer = (reversal(arr,arr2))? "Yes" : "No";
        System.out.print(answer);
	}
    public static boolean reversal (int[] arr, int[] arr2){
        int home=0;
        int away=0;
        boolean drama = false;
        for (int i =0;i<9;i++){
            home += arr[i];
            if (home > away){
                return true;
            }
            away += arr2[i];
        }
        return false;
    }
}

