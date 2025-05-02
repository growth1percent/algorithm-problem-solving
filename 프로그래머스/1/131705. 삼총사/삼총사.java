import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int n = number.length;
        Arrays.sort(number);
        
        for (int i = 0; i < n-2; i++) {
            if (number[i] > 0) break;
            
            for (int j = i + 1; j < n-1; j++) {
                if (number[i] + number[j] > 0) break;
                
                for (int k = j + 1; k < n; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    } else if (number[i] + number[j] + number[k] > 0) break;
                }
            }
        }
        return answer; 
    }
}