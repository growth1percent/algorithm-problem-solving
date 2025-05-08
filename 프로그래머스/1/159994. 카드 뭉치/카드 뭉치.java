import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));
        Deque<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2));
        Boolean answer = true;
        
        for (String g : goal) {
            if (!queue1.isEmpty() && queue1.peek().equals(g)) {
                queue1.removeFirst();
            } else if (!queue2.isEmpty() && queue2.peek().equals(g)) {
                queue2.removeFirst();
            } else {
                answer = false;
                break;
            }
        }
        
        return answer == true ? "Yes" : "No";
    }
}