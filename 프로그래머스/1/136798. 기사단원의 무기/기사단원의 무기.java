class Solution {
    public int solution(int number, int limit, int power) {
        // 1. number 별로 약수의 개수를 구하고 limit을 넘지 않는다면, answer에 더하기
        // 2. number 별로 약수의 개수가 limit을 넘는다면, power을 answer에 더하기
        // 3. 배열의 합 
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int count = 0;
            
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    if (j == i / j) {
                        count++;
                    } else {
                        count += 2;
                    }
                }
            }
            
            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }
        
        return answer;
    }
}