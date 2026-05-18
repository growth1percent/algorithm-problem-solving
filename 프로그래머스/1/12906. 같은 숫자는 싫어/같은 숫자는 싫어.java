import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i : arr) {
            if (queue.isEmpty()) {
                queue.addLast(i);
            } else {
                if (queue.peekLast() != i) {
                    queue.addLast(i);   
                }
            }
        }

        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}