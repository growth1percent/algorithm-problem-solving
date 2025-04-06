import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        stack.push(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            } else {
                continue;
            }
        }
        
        ArrayList<Integer> reversedList = new ArrayList<>(stack);
        Collections.reverse(reversedList);
        
        return reversedList.stream().mapToInt(Integer::intValue).toArray();
    }
}