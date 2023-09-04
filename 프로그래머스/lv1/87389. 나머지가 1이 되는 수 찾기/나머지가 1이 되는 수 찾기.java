class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1;
        while(i++<=1000000){
            if(n % i ==1){
                answer = i;
                break;
            }
        }
        return answer;
    }
}