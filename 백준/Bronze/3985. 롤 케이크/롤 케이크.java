import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len+1];
        int tc = sc.nextInt();
        // 예상 최대값
        int max = 0;
        // 예상 최대 주인공
        int Num = 0;
        // 실제 최대값
        int real = 0;
        // 그 주인공
        int realNum = Integer.MAX_VALUE;
        for(int test_case=1;test_case<=tc;test_case++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (max < b-a){
                max = b-a;
                Num = test_case;
            }
            //롤케이크 나누기
            for (int i=a;i<=b;i++){
                if(arr[i]==0){
                    arr[i]= test_case;
                }
            }
        }
        //빈도수 구하기
        int[] answer = new int[tc+2];
        for(int i=0;i<arr.length;i++){
            //없는값은 빼고
            if(arr[i]!=0){
                answer[arr[i]]++;
            }
        }
        //빈도수 비교
        for(int i=0;i<answer.length;i++){
            if (real < answer[i]  ){
                real = answer[i];
                realNum = i;
            }
        }
        System.out.println(Num);
        System.out.println(realNum);
    }
}


