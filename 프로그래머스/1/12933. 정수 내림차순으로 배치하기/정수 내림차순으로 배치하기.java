import java.util.*;

class Solution {
    public long solution(long n) {
        String str = Long.toString(n);
        String[] array = str.split("");
        
        Arrays.sort(array, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        
        
        return Long.parseLong(sb.toString());
    }
}