class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] array = s.toCharArray();
        int idx = 0;
        
        while (idx < s.length()) {
            int sameCount = 1;
            int diffCount = 0;
            char c = array[idx];
            for (int i = idx + 1; i < s.length(); i++) {
                if (c == array[i]) {
                    sameCount++;
                } else {
                    diffCount++;
                }
                
                if (sameCount == diffCount) {
                    answer++;
                    idx = i + 1;
                    break;
                }
            }
            if (sameCount != diffCount) {
                answer++;
                break;
            }
        }
        return answer;
    }
}