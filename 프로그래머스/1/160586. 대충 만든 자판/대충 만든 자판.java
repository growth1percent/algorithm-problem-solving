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
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (String target : targets) {
            int count = 0;
            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                if (map.containsKey(c)) {
                    count += map.get(c);
                } else {
                    count = -1;
                    break;
                }
            }
            answer.add(count);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}