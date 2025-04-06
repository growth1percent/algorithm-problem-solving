class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long max = 0;
        long min = 0;
        
        max = Math.max(a, b);
        min = Math.min(a, b);
        
        for (long i = min; i <= max; i++) {
            answer += i;
        }
        
        return answer;
    }
}