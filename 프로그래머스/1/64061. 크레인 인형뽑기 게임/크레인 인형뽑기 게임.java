import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<ArrayDeque<Integer>> lanes = new ArrayList<>(board[0].length);
        
        for (int i = 0; i < board[0].length; i++) {
            lanes.add(new ArrayDeque<>());
        }
        
        for (int i = board[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    lanes.get(j).push(board[i][j]);
                }
            }
        }
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        
        for (int m : moves) {
            if(lanes.get(m - 1).isEmpty()) 
                continue;
            
            int doll = lanes.get(m - 1).pop();
            
            if (!stack.isEmpty() && stack.peek() == doll) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(doll);
            }
        }    
        
        return answer;
    }
}