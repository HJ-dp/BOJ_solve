public class Main {
    public static void main(String[] args) {
        int[] answer = new int[10001];
        for(int i=0;i<10000;i++){
            int a = self(i);
            if (a<10001){
                answer[self(i)] = 1;
            }
        }
        for(int i=0;i<10000;i++){
        	if(answer[i]==0) {
        		System.out.println(i);
        	}
        }
	}
    public static int self(int x) {
        int temp = x;
        while(x >= 1){
            temp += x%10;
            x /= 10;
        }
		return temp;
	}
}