class Solution {
    public int solution(int num) {
        int answer = 0;
        Long current = (long) num;
        
        if (current == 1) {
            return 0;
        }
        
        while (current != 1) {
            if (answer == 500) {
                return -1;
            }
            
            if (current % 2 == 0) {
                current /= 2;
            } else {
                current = current * 3 + 1;
            }
            
            answer++;
        }
        
        return answer;
    }
}