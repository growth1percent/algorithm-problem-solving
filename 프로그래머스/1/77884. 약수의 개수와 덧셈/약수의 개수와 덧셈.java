class Solution {
    public int solution(int left, int right) {
        // 어떤 수의 약수 개수가 홀수인 경우는 그 수가 **정수 제곱수(perfect square)**일 때 뿐이다.
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                answer -= i;
            } else {
                answer += i;
            }
        }
        
        return answer;
    }
}