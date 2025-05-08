import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!map.containsKey(c)) {
                    map.put(c, i + 1);
                } else {
                    if (i + 1 < map.get(c)) {
                        map.put(c, i + 1);
                    }
                }
            }
        }
        
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            String target = targets[i];
            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);
                if (map.containsKey(c)) {
                    count += map.get(c);
                } else {
                    count = -1;
                    break;
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }
}