class Solution {
    public int[] solution(int n, int m) {        
        int a = n;
        int b = m;
        // #최대공약수 #유클리드 호제법 - a, b = b, a % b;
        while (b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        
        int gcd = a;
        int lcm = n * m / gcd;
        
        int[] answer = new int[] {gcd, lcm};
        
        return answer;
    }
}