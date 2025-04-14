class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long a = (long) x;
        int idx = 0;
        
        if (x > 0) {
            for (long i = a; i <= a * n; i+=a) {
                answer[idx++] = i;
            }
        } else if (x < 0) {
            for (long i = a; i >= a * n; i+=a) {
                answer[idx++] = i;
            }
        } else {
            answer[0] = 0;
        }
        
        return answer;
    }
}