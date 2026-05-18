class Solution {
    public String solution(int a, int b) {
        int[] arr = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        int dayNum = 0;
        for (int i = 1; i < a; i++) {
            dayNum += arr[i];
        }
        
        dayNum += b;
        
        String answer = day[dayNum % 7];
        
        return answer;
    }
}