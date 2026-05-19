using System;

public class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        long A = Math.Min(a, b);
        long B = Math.Max(a, b);
        
        answer = (A + B) * (B - A + 1) / 2;
        
        return answer;
    }
}