import java.util.*;

class Solution {
    public static String[] bb = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        int size = babbling.length;
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = babbling[i].length();
            for(int j=0;j<4;j++){
                if(babbling[i].contains(bb[j])){
                    arr[i] -= bb[j].length();
                }
            }
        }
        for(int i=0;i<size;i++){
            if (arr[i]==0){answer++;}
        }

        return answer;
    }
}