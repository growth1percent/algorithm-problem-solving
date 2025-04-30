import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scoreMap = new HashMap<>();
        
        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            char neg = s.charAt(0);
            char pos = s.charAt(1);
            
            if (choices[i] > 4) {
                scoreMap.put(pos, scoreMap.getOrDefault(pos, 0) + (choices[i] - 4));
            } else if (choices[i] < 4) {
                scoreMap.put(neg, scoreMap.getOrDefault(neg, 0) + (4 - choices[i]));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(scoreMap.getOrDefault('R', 0) >= scoreMap.getOrDefault('T', 0) ? 'R' : 'T');
        sb.append(scoreMap.getOrDefault('C', 0) >= scoreMap.getOrDefault('F', 0) ? 'C' : 'F');
        sb.append(scoreMap.getOrDefault('J', 0) >= scoreMap.getOrDefault('M', 0) ? 'J' : 'M');
        sb.append(scoreMap.getOrDefault('A', 0) >= scoreMap.getOrDefault('N', 0) ? 'A' : 'N');
        
        return sb.toString();
    }
}