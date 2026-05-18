class Solution {
    public String solution(String s) {
        int sNum = s.length();
        
        String answer = "";
        
        if (sNum % 2 == 0) {
            answer = s.substring(sNum / 2 - 1, sNum / 2 + 1);
        } else {
            answer = s.substring(sNum / 2, sNum / 2 + 1);
        }
    
        return answer;
    }
}