import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] split = s.split("");
        Arrays.sort(split, Collections.reverseOrder());
        
        for (String str : split) {
            answer += str;
        }
        
        return answer;
    }
}