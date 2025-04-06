import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int n : arr) {
            if (n % divisor == 0) {
                list.add(n);        
            } else {
                continue;
            }
        }
        
        if (list.isEmpty()) {
            list.add(-1);
        }
        
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}