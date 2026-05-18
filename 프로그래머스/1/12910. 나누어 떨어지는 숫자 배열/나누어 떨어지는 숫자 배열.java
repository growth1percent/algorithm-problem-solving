import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        for (int num : arr) {
            if (num % divisor == 0) {
                list.add(num);
            }
        } 
        
        Collections.sort(list);
        
        if (list.size() == 0) {
            return new int[] {-1};
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}