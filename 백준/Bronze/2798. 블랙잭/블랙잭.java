import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		//최소차이 변수
		int min = Integer.MAX_VALUE;
		//최소차이 값 저장용 변수
		int value = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i != j){
					for (int k=0;k<n;k++){
						if (i!=k && j!=k){
							int temp = arr[i]+arr[j]+arr[k];
							if (min > abs(temp,m)){
								min = abs(temp,m);
								value = temp;
							}
						}
					}
				}
			}
		}
		System.out.print(value);
	}
	//목표값이 넘으면 정수최대값 반환
	public static int abs(int n,int m){
		return (m - n < 0)? Integer.MAX_VALUE : m-n;
	}
}