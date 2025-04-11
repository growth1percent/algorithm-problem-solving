import java.util.*;

class Solution {
    public long solution(long n) {
        String str = Long.toString(n);
        String[] array = str.split("");
        Arrays.sort(array, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        
        for (String s : array) {
            sb.append(s);
        }
        
        return Long.parseLong(sb.toString());
    }
}