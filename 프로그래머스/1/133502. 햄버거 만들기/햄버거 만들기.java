import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        
        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);
            
            if (stack.size() >= 4) {
                int s1 = stack.pop();
                int s2 = stack.pop();
                int s3 = stack.pop();
                int s4 = stack.pop();
                
                if (s1 == 1 && s2 == 3 && s3 == 2 && s4 == 1) {
                    count++;
                } else {
                    stack.push(s4);
                    stack.push(s3);
                    stack.push(s2);
                    stack.push(s1);
                }
            }
        }
        return count;
    }
}