class Solution {
    // 에라토스테네스의 체
    public int solution(int n) {
        int answer = 0;
        
        boolean isPrime[] = new boolean[n + 1];
        
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i*i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (isPrime[i])
                answer++;
        }
        
        return answer;
    }
}