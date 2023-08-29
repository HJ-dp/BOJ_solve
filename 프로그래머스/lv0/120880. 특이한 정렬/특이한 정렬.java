class Solution {
    public int[] solution(int[] numlist, int n) {
        int x = numlist.length;
        int[] answer = new int[numlist.length];
        int size = 0;
        for(int t=0;t<x;t++){
            int min = Integer.MAX_VALUE;
            int now = 0;
            for(int i=0;i<x;i++){
                if (numlist[i]==0){continue;}
                if (Math.abs(n - numlist[i]) < min){
                    min = Math.abs(n - numlist[i]);
                    now = numlist[i];           
                } else if (Math.abs(n - numlist[i]) == min){
                    now = (now > numlist[i]) ? now : numlist[i];
                }
            }
            answer[size++] = now;
            for(int i=0;i<x;i++){
                if(numlist[i]==now){numlist[i]=0;}
            }
        }
        
        return answer;
    }
}