import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < score.length; i++) {
            queue.addLast(score[i]);
            if (queue.size() > k) {
                int min = Collections.min(queue);
                queue.removeFirstOccurrence(min);
            }
            int currentMin = Collections.min(queue);
            answer[i] = currentMin;
        }
        
        return answer;
    }
}