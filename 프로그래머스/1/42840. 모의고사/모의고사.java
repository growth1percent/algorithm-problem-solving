import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[][] type = new int[][] {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] answer = new int[3];
        for (int i = 0; i < type.length; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (type[i][j % type[i].length] == answers[j]) {
                    answer[i] += 1;
                }
            }
        }
        
        int max = Arrays.stream(answer).max().getAsInt();
        ArrayList<Integer> arrays = new ArrayList<>();
        
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == max) {
                arrays.add(i + 1);
            }
        }
        
        return arrays.stream().mapToInt(Integer::intValue).toArray();
    }
}