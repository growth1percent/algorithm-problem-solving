class Solution {
    public int solution(String[] babbling) {
        String[] possible = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for (String word : babbling) {
            String prev = "";
            boolean isValid = true;
            int i = 0;
            
            while (i < word.length()) {
                boolean matched = false;
                for (String p : possible) {
                   if (word.startsWith(p, i) && !p.equals(prev)) {
                       prev = p;
                       i += p.length();
                       matched = true;
                       break;
                   }
                }
                if (!matched) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                answer++;
            }
        }
        
        return answer;
    }
}