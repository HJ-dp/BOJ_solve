class Solution {
    public int solution(int[] common) {
        int ch = common[1] - common[0];
        if ((common[common.length-1] - common[common.length-2]) == ch){
            return common[common.length-1] + ch;
        } else {
            int temp = common[1] / common[0];
            return common[common.length-1] * temp;
        }
        
    }
}