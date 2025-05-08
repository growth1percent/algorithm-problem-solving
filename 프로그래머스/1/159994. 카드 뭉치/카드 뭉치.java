import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> queue1 = new ArrayDeque<>();
        Deque<String> queue2 = new ArrayDeque<>();
        Boolean answer = true;
        
        for(String s1 : cards1) {
            queue1.addLast(s1);
        }
        
        for (String s2 : cards2) {
            queue2.addLast(s2);
        }
        
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