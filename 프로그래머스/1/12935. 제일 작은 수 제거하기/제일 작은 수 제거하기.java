import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        /*
        int min = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int value : arr) {
            if (value != min) {
                answer.add(value);
            }
        }
        
        return arr.length <= 1 ? new int[] {-1} : answer.stream().mapToInt(Integer::intValue).toArray();
        */
        
        int min = arr[0];
        int minIdx = 0;
        
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIdx = i;
            }
        }
        
        int[] answer = new int[arr.length - 1];
        int idx = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (i == minIdx) {
                continue;
            }
            answer[idx++] = arr[i];
        }
        
        return arr.length <= 1 ? new int[] {-1} : answer;
    }
}
