import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int idx = score.length - 1;
        int answer = 0;

        // m에 따른 최저 점수와 총 점수 계산 
        while (idx >= m - 1) {
            int minScore = score[idx - m + 1];
            answer += minScore * m;
            idx -= m;
        }
        
        return answer;
    }
}