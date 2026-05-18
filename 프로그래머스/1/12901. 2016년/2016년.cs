public class Solution {
    public string solution(int a, int b) {
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        string[] s = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        int dayNum = 0;
        
        for (int i = 1; i < a; i++) {
            dayNum += days[i];
        }
        
        dayNum += b;
        
        return s[dayNum % 7];
    }
}