class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int sum = 0;
        for(int i=0;i<num;i++){
            answer[i] = i;
            sum += i;
        }
        while (sum!=total){
          if (sum > total){
            for(int i=0;i<num;i++){
            answer[i] -= 1;
            }
            sum-=num;
        } else {
            for(int i=0;i<num;i++){
            answer[i] += 1;
            }
            sum+=num;
        }
        }
        return answer;
    }
}