class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for(String s : dic){
        int Sl = s.length();
        if (Sl == spell.length){
            int cnt = 0;
            for(int i=0;i<Sl;i++){
                if(s.contains(spell[i])){
                      cnt++;
                }  
            }
            if (cnt == spell.length){
                System.out.println("ddd");
                answer = 1;
            }
        }
    }
    return answer;
    }
}