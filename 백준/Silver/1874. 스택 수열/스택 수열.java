import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        //출력해야하는 수열 입력받기
		int T=sc.nextInt();
        int[] arr = new int[T];
        for(int i=0;i<T;i++){
            arr[i] = sc.nextInt();
        }
        //현재출력해야할 인덱스
        int idx = 0;
        //답 기록용
        ArrayList<String> answer = new ArrayList<>();
        //사용할 스택
        int[] stack = new int[T+1];
        int size = 0;

        int i = 1;
		while(i<=T+1){
            //i가 끝까지 다다르고 스택이 비었을경우 stop
            if (size==0 && i == T+1){break;}
            //스택이 비었거나 스택의 상위값이 현재 찾는 값이 아니면 넣기
            if (size==0 || stack[size-1]!=arr[idx]){
                stack[size++] = i;
                answer.add("+");
                i++;
                continue;
            }
            //스택이 비지 않고 스택 상위값이 현재 찾는 값이면 빼기
            if (size!=0 && stack[size-1]==arr[idx]){
                answer.add("-");
                size--;
                idx++;
                continue;
            }
		}
        
        //스택이 비지 않았으면 NO
        if (size!=0) { System.out.println("NO");
        //스택이 비었으면 출력
        } else {
            for(int j=0;j<answer.size();j++){
                System.out.println(answer.get(j));
            }
        }
	}
}