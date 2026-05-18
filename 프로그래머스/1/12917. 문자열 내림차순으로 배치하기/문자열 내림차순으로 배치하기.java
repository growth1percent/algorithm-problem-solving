import java.util.*;

class Solution {
    public String solution(String s) {
        char[] cArr = s.toCharArray();
        
        Arrays.sort(cArr);
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : cArr) {
            sb.append(c);
        }
        
        return sb.reverse().toString();
    }
}