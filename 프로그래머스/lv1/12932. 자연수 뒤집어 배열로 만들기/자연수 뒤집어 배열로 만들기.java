class Solution {
    public int[] solution(long n) {
        String s = Long.toString(n);
        int[] answer = new int[s.length()];
        int i = 0;
        while(i<answer.length){
            answer[i++] = (int) (n % 10);
            n/=10;
        }
        return answer;
    }
}