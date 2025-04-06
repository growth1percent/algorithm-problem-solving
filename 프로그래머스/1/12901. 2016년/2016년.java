class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        
        for (int i = 1; i < a; i++) {
            totalDays += days[i];
        }
        
        totalDays += b;
        
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        answer = week[(totalDays - 1) % 7];
        
        return answer;
    }
}