import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 체육복을 가지고 있는 학생들의 초기 값
        int answer = n - lost.length;
            
        Arrays.sort(reserve);
        Arrays.sort(lost);
        
        // 여벌 체육복을 가져왔지만 체육복을 도난당한 학생
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == lost[j]) {
                    answer++;
                    lost[j] = -1;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        
        // 여분의 체육복 없이 체육복을 도난 당한 학생 중, 체육복을 빌린 학생
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
            
        return answer;
    }
}