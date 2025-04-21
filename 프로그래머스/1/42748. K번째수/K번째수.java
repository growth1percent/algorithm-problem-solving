import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] copy = array;
            for (int j = 0; j < commands[0].length; j++) {
                int[] slicedArray = Arrays.copyOfRange(copy, command[0] - 1, command[1]);
                Arrays.sort(slicedArray);
                answer[i] = slicedArray[command[2] - 1];
            }
        }
        return answer;
    }
}