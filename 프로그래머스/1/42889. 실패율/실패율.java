import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] reached = new int[N+2];
        double[] fails = new double[N+1];
        
        // 현재 도달한 스테이지의 플레이어 수
        for (int i : stages) {
            reached[i] += 1;
        }
        
        int total = 0;
        
        for (int i : reached) {
            total += i;
        }
        
        // 각 스테이지 별 실패율
        for (int i = 1; i <= N; i++) {
            if (total == 0) {
                fails[i] = 0;
            } else {
                fails[i] = (double) reached[i] / total;
            }
            total -= reached[i];
        }
        
        HashMap<Integer, Double> map = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            map.put(i, fails[i]);
        }
        
        return map.entrySet().stream()
            .sorted((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()))
            .mapToInt(entry -> entry.getKey()).toArray();
    }
}