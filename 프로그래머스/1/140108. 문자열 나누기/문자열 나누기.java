class Solution {
    public int solution(String s) {
        int answer = 0;
        int count = 0;
        char target = s.charAt(0);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target) {
                count++;
            } else {
                count--;
            }
            
            if (count == 0) {
                answer++;
                if (i + 1 < s.length()) {
                    target = s.charAt(i + 1);   
                }
            }
        }
        
        if (count > 0) {
            answer++;
        }
        
        return answer;
    }
}