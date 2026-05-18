import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int answer = 0;
        
        int maxNum = nums.length / 2;
        
        if (map.size() < maxNum) {
            answer = map.size();
        } else {
            answer = maxNum;
        }
        
        return answer;
    }
}