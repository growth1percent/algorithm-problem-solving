import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, 0}); // {현재 합, 인덱스}
        int count = 0;
        
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int sum = current[0];
            int index = current[1];
            
            if (index == numbers.length) {
                if (sum == target) count++;
            } else {
                int num = numbers[index];
                stack.push(new int[]{sum + num, index + 1});
                stack.push(new int[]{sum - num, index + 1});
            }
        }
        
        return count;
    }
}