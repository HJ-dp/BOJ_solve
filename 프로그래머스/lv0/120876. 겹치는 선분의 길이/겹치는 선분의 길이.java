import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int[] arr = new int[202];
        for(int[] s : lines){
            for(int i = s[0]+100;i<s[1]+100;i++){
                arr[i] += 1;
            }
        }
        int cnt = 0;
        for(int i : arr){
            if (i>1){
                cnt++;
            }
        }
        
        return cnt;
    }
}