import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int G = mma(a,b);
        a /= G;
        b /= G;
        if (a==b){return 1;}
        while(b!=1){
            if(b%2==0){
                b/=2;
            } else if(b%5==0){
                b/=5;
            }else{
                return 2;
            }
        }
        return 1;
        
    }
    
    public static int mma(int a, int b){
        int max = Integer.max(a,b);
        int min = Integer.min(a,b);
        if (max%min==0){
            return min;
        }
        return mma(max%min,min);
    }
}