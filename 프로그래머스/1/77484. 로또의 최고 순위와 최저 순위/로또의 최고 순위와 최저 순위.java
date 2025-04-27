import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<>();
        
        int matchCount = 0;
        int zeroCount = 0;
        
        for (int num : win_nums) {
            set.add(num);
        }
        
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
            } else if (set.contains(lotto)) {
                matchCount++;
            }
        }
        
        int high = Math.min(7 - (zeroCount + matchCount), 6);
        int low = Math.min(7 - matchCount, 6);
        
        return new int[] {high, low};
    }
}