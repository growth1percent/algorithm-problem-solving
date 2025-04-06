import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int len = nums.length;
        int maxlen = len / 2;
        
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        if (map.size() >= maxlen) {
            answer = maxlen;
        } else {
            answer = map.size();
        }
        return answer;
    }
}