class Solution {
    public int solution(String t, String p) {
        int targetLen = p.length();
        int answer = 0;
        
        for (int i = 0; i < t.length() - targetLen + 1; i++) {
            String target = t.substring(i, i + targetLen);
            if (target.compareTo(p) <= 0) {
                answer++;
            }
        }
        return answer;
    }
}